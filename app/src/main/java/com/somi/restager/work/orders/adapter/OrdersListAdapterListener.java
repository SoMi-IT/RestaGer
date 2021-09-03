package com.somi.restager.work.orders.adapter;


import com.somi.restager.work.orders.data.Order;


public interface OrdersListAdapterListener {

    void onItemClicked(Order order);
    void onItemNotesClicked(Order order);
    void onItemLocationClicked(Order order);

}//OrdersListAdapterListener
