package com.somi.restager.work.tables.adapter;


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
import com.somi.restager.work.orders.adapter.OrdersListAdapterListener;
import com.somi.restager.work.orders.data.Order;
import com.somi.restager.work.tables.data.Table;

import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class TablesListAdapter extends RecyclerView.Adapter<TablesListAdapter.TablesListAdapterItemView> {


    private ArrayList<Table> tables;
    private final Context context;
    private TablesListAdapterListener listener;


    public TablesListAdapter(Context _context, ArrayList<Table> _schedules) {

        tables = _schedules;
        context = _context;

    }//constructor

    public void updateOrders(ArrayList<Table> _orders) {


        tables = _orders;
        notifyDataSetChanged();

    }//constructor


    public void setListener(TablesListAdapterListener _TablesListAdapterListener){

        listener = _TablesListAdapterListener;

    }//setListener


    @NonNull
    public TablesListAdapterItemView onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_table, parent, false);

        return new TablesListAdapterItemView(v);

    }//onCreateViewHolder


    public void onBindViewHolder(TablesListAdapterItemView holder, int position) {

        holder.itemView.setTag(tables.get(position));

        holder.itemView.setOnClickListener(v -> {

            if (listener != null) listener.onItemClicked(tables.get(holder.getAdapterPosition()));

        });
        Table table = tables.get(position);

        holder.tv_number.setText(table.getNumber()+"");

        if(table.isFree())holder.tv_status.setText("Free");
        else holder.tv_status.setText("Taken");

        holder.tv_room.setText(table.getRoom());
        holder.tv_seats.setText(table.getSeats()+"");

        holder.iv_notes.setOnClickListener(v -> {

            if (listener != null) listener.onItemNotesClicked(tables.get(holder.getAdapterPosition()));

        });

        holder.iv_location.setOnClickListener(v -> {

            if (listener != null) listener.onItemLocationClicked(tables.get(holder.getAdapterPosition()));

        });

    }//onBindViewHolder



    public static class TablesListAdapterItemView extends RecyclerView.ViewHolder {

        CardView cv_card;
        TextView tv_number;
        TextView tv_status;
        TextView tv_room;
        TextView tv_seats;
        ImageView iv_notes;
        ImageView iv_location;

        TablesListAdapterItemView(View itemView) {

            super(itemView);
            cv_card = (CardView) itemView;
            tv_number = itemView.findViewById(R.id.tv_table_item_number);
            tv_status = itemView.findViewById(R.id.tv_table_item_status);
            tv_room = itemView.findViewById(R.id.tv_table_item_room);
            tv_seats = itemView.findViewById(R.id.tv_table_item_seats);
            iv_notes = itemView.findViewById(R.id.iv_table_item_notes);
            iv_location = itemView.findViewById(R.id.iv_table_item_location);

        }

    }//SheetsListAdapterItemView


    public int getItemCount() {

        return tables.size();

    }//getItemCount


}//sheetsListAdapter
