package com.somi.restager.work.orders.adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.somi.restager.R;
import com.somi.restager.work.menu.data.Plate;
import com.somi.restager.work.orders.data.Order;

import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class PlatesListAdapter extends RecyclerView.Adapter<PlatesListAdapter.PlatesListAdapterItemView> {


    private ArrayList<Plate> plates;
    private final Context context;
    private PlatesListAdapterListener listener;


    public PlatesListAdapter(Context _context, ArrayList<Plate> _schedules) {

        plates = _schedules;
        context = _context;

    }//constructor

    public void deletePlate(ArrayList<Plate> _plates, int position) {

        plates = _plates;
        notifyItemChanged(position);

    }//updateOrder

    public void setListener(PlatesListAdapterListener _PlatesListAdapterListener){

        listener = _PlatesListAdapterListener;

    }//setListener


    @NonNull
    public PlatesListAdapterItemView onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_plate, parent, false);

        return new PlatesListAdapterItemView(v);

    }//onCreateViewHolder


    public void onBindViewHolder(PlatesListAdapterItemView holder, int position) {

        Plate plate = plates.get(position);

        holder.itemView.setTag(plate);

        holder.tv_id.setText(plate.getId()+"");
        holder.tv_plate.setText(plate.getName());

        holder.iv_delete.setOnClickListener(v -> {

            if (listener != null) {

                plates.remove(plate);
                notifyItemRemoved(position);
                listener.onItemDeleted(plates);

            }


        });

    }//onBindViewHolder



    public static class PlatesListAdapterItemView extends RecyclerView.ViewHolder {

        CardView cv_card;
        TextView tv_id;
        TextView tv_plate;
        ImageView iv_delete;

        PlatesListAdapterItemView(View itemView) {

            super(itemView);
            cv_card = (CardView) itemView;
            tv_id = itemView.findViewById(R.id.tv_plate_item_id);
            tv_plate = itemView.findViewById(R.id.tv_plate_item_name);
            iv_delete = itemView.findViewById(R.id.iv_plate_item_delete);

        }

    }//SheetsListAdapterItemView


    public int getItemCount() {

        return plates.size();

    }//getItemCount


}//sheetsListAdapter
