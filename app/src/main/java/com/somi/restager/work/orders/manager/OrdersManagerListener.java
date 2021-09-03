package com.somi.restager.work.orders.manager;

import com.somi.restager.work.orders.data.Order;

import java.util.ArrayList;

public interface OrdersManagerListener {

    void dataUpdated(ArrayList<Order> orders, int donePosition, int currentPosition, int newPosition);

}//TaskDataManagerListener
