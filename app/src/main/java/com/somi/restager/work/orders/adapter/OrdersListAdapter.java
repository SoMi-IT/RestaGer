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


    public void updateAllOrders(ArrayList<Order> _orders) {

        orders = _orders;
        notifyDataSetChanged();

    }//updateAllOrders


    public void updateOrder(ArrayList<Order> _orders, int position) {


        orders = _orders;
        notifyItemChanged(position);

    }//updateOrder

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

        holder.iv_info.setOnClickListener(v -> {

            if (listener != null) listener.onItemNotesClicked(orders.get(holder.getAdapterPosition()));

        });


        if (order.getStatus().equals(Order.ORDER_STATUS_STARTED)) {

            holder.cv_card.setCardBackgroundColor(context.getColor(R.color.blue_700));
            holder.tv_status.setText(Order.ORDER_STATUS_STARTED);

        }else if (order.getStatus().equals(Order.ORDER_STATUS_PREPARATION)) {

            holder.cv_card.setCardBackgroundColor(context.getColor(R.color.blue_700));
            holder.tv_status.setText(Order.ORDER_STATUS_PREPARATION);

        }else if (order.getStatus().equals(Order.ORDER_STATUS_READY)) {

            holder.cv_card.setCardBackgroundColor(context.getColor(R.color.teal_700));
            holder.tv_status.setText(Order.ORDER_STATUS_READY);

        }else if (order.getStatus().equals(Order.ORDER_STATUS_INCOMING)) {

            holder.cv_card.setCardBackgroundColor(context.getColor(R.color.blue_700));
            holder.tv_status.setText(Order.ORDER_STATUS_INCOMING);

        }else if (order.getStatus().equals(Order.ORDER_STATUS_DELIVERED)) {

            holder.cv_card.setCardBackgroundColor(context.getColor(R.color.dark_800));
            holder.tv_status.setText(Order.ORDER_STATUS_DELIVERED);

        }else if (order.getStatus().equals(Order.ORDER_STATUS_DISMISSED)) {

            holder.cv_card.setCardBackgroundColor(context.getColor(R.color.dark_600));
            holder.tv_status.setText(Order.ORDER_STATUS_DISMISSED);

        }

    }//onBindViewHolder



    public static class OrdersListAdapterItemView extends RecyclerView.ViewHolder {

        CardView cv_card;
        TextView tv_id;
        TextView tv_status;
        TextView tv_table;
        TextView tv_time;
        TextView tv_plates;
        ImageView iv_info;

        OrdersListAdapterItemView(View itemView) {

            super(itemView);
            cv_card = (CardView) itemView;
            tv_id = itemView.findViewById(R.id.tv_order_item_id);
            tv_status = itemView.findViewById(R.id.tv_order_item_status);
            tv_table = itemView.findViewById(R.id.tv_order_item_table);
            tv_time = itemView.findViewById(R.id.tv_order_item_time);
            tv_plates = itemView.findViewById(R.id.tv_order_item_plates);
            iv_info = itemView.findViewById(R.id.iv_order_item_notes);

        }

    }//SheetsListAdapterItemView


    public int getItemCount() {

        return orders.size();

    }//getItemCount


}//sheetsListAdapter
