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
import com.somi.restager.work.orders.data.Order;

import java.text.SimpleDateFormat;
import java.util.ArrayList;


public class OrdersListAdapter extends RecyclerView.Adapter<OrdersListAdapter.OrdersListAdapterItemView> {


    private ArrayList<Order> orders;
    private final Context context;
    private OrdersListAdapterListener listener;


    public OrdersListAdapter(Context _context, ArrayList<Order> _schedules) {

        orders = _schedules;
        context = _context;

    }//constructor

    public void updateOrders(ArrayList<Order> _orders) {


        orders = _orders;
        notifyDataSetChanged();

    }//constructor


    public void setListener(OrdersListAdapterListener _OrdersListAdapterListener){

        listener = _OrdersListAdapterListener;

    }//setListener


    @NonNull
    public OrdersListAdapterItemView onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_order, parent, false);

        return new OrdersListAdapterItemView(v);

    }//onCreateViewHolder


    public void onBindViewHolder(OrdersListAdapterItemView holder, int position) {

        holder.itemView.setTag(orders.get(position));

        holder.itemView.setOnClickListener(v -> {

            if (listener != null) listener.onItemClicked(orders.get(holder.getAdapterPosition()));

        });
        Order order = orders.get(position);

        holder.tv_id.setText(order.getId()+"");
        holder.tv_table.setText(order.getTableId()+"");
        holder.tv_time.setText(new SimpleDateFormat("HH:mm").format(order.getTime()));
        holder.tv_plates.setText(order.getOrderedPlates().size()+"");

        holder.iv_notes.setOnClickListener(v -> {

            if (listener != null) listener.onItemNotesClicked(orders.get(holder.getAdapterPosition()));

        });

        holder.iv_location.setOnClickListener(v -> {

            if (listener != null) listener.onItemLocationClicked(orders.get(holder.getAdapterPosition()));

        });


        if (order.getStatus() == Order.ORDER_STATUS_STARTED) {

            holder.cv_card.setCardBackgroundColor(context.getColor(R.color.blue_700));
            holder.tv_status.setText("Started");

        }else if (order.getStatus() == Order.ORDER_STATUS_PREPARATION) {

            holder.cv_card.setCardBackgroundColor(context.getColor(R.color.blue_700));
            holder.tv_status.setText("Preparation");

        }else if (order.getStatus() == Order.ORDER_STATUS_READY) {

            holder.cv_card.setCardBackgroundColor(context.getColor(R.color.teal_700));
            holder.tv_status.setText("Ready");

        }else if (order.getStatus() == Order.ORDER_STATUS_INCOMING) {

            holder.cv_card.setCardBackgroundColor(context.getColor(R.color.blue_700));
            holder.tv_status.setText("Incoming");

        }else if (order.getStatus() == Order.ORDER_STATUS_DELIVERED) {

            holder.cv_card.setCardBackgroundColor(context.getColor(R.color.dark_800));
            holder.tv_status.setText("Deliverd");

        }else if (order.getStatus() == Order.ORDER_STATUS_DISMISSED) {

            holder.cv_card.setCardBackgroundColor(context.getColor(R.color.dark_600));
            holder.tv_status.setText("Aborted");

        }

    }//onBindViewHolder



    public static class OrdersListAdapterItemView extends RecyclerView.ViewHolder {

        CardView cv_card;
        TextView tv_id;
        TextView tv_status;
        TextView tv_table;
        TextView tv_time;
        TextView tv_plates;
        ImageView iv_notes;
        ImageView iv_location;

        OrdersListAdapterItemView(View itemView) {

            super(itemView);
            cv_card = (CardView) itemView;
            tv_id = itemView.findViewById(R.id.tv_order_item_id);
            tv_status = itemView.findViewById(R.id.tv_order_item_status);
            tv_table = itemView.findViewById(R.id.tv_order_item_table);
            tv_time = itemView.findViewById(R.id.tv_order_item_time);
            tv_plates = itemView.findViewById(R.id.tv_order_item_plates);
            iv_notes = itemView.findViewById(R.id.iv_order_item_notes);
            iv_location = itemView.findViewById(R.id.iv_order_item_location);

        }

    }//SheetsListAdapterItemView


    public int getItemCount() {

        return orders.size();

    }//getItemCount


}//sheetsListAdapter
