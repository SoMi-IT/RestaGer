package com.somi.restager.work.orders.manager;

import com.somi.restager.work.orders.data.Order;

import java.util.ArrayList;

public interface OrdersManagerListener {

    void OnDataUpdated(ArrayList<Order> orders, int postion);
    void OnAllDataUpdated(ArrayList<Order> orders);

}//OrdersManagerListener
