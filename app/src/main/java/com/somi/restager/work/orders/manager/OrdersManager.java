package com.somi.restager.work.orders.manager;

import com.somi.restager.work.orders.data.Order;
import com.somi.restager.work.orders.filter.data.OrderFilter;
import com.somi.restager.work.orders.data.OrderedPlate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;

public class OrdersManager {


    public static ArrayList<Order> getFakeData(){

        ArrayList<Order> orders = new ArrayList<>();

        Calendar calendar = Calendar.getInstance();

        Order order1 = new Order();
        order1.setId(5690);
        order1.setTableId(45);
        order1.setTime(calendar.getTime());
        order1.setOrderedPlates(new ArrayList<OrderedPlate>(Arrays.asList(new OrderedPlate(),new OrderedPlate())));
        order1.setStatus(Order.ORDER_STATUS_STARTED);

        calendar.add(Calendar.MINUTE, 1);

        Order order2 = new Order();
        order2.setId(5678);
        order2.setTableId(45);
        order2.setTime(calendar.getTime());
        order2.setOrderedPlates(new ArrayList<OrderedPlate>(Arrays.asList(new OrderedPlate(),new OrderedPlate(),new OrderedPlate())));
        order2.setStatus(Order.ORDER_STATUS_PREPARATION);

        calendar.add(Calendar.MINUTE, 2);

        Order order3 = new Order();
        order3.setId(5679);
        order3.setTableId(46);
        order3.setTime(calendar.getTime());
        order3.setOrderedPlates(new ArrayList<OrderedPlate>(Arrays.asList(new OrderedPlate())));
        order3.setStatus(Order.ORDER_STATUS_READY);

        calendar.add(Calendar.MINUTE, 4);

        Order order4 = new Order();
        order4.setId(5680);
        order4.setTableId(47);
        order4.setTime(calendar.getTime());
        order4.setOrderedPlates(new ArrayList<OrderedPlate>(Arrays.asList(new OrderedPlate(),new OrderedPlate())));
        order4.setStatus(Order.ORDER_STATUS_INCOMING);

        calendar.add(Calendar.MINUTE, 5);

        Order order5 = new Order();
        order5.setId(5681);
        order5.setTableId(47);
        order5.setTime(calendar.getTime());
        order5.setOrderedPlates(new ArrayList<OrderedPlate>(Arrays.asList(new OrderedPlate(),new OrderedPlate())));
        order5.setStatus(Order.ORDER_STATUS_DELIVERED);

        calendar.add(Calendar.MINUTE, 4);

        Order order6 = new Order();
        order6.setId(5650);
        order6.setTableId(47);
        order6.setTime(calendar.getTime());
        order6.setOrderedPlates(new ArrayList<OrderedPlate>(Arrays.asList(new OrderedPlate(),new OrderedPlate())));
        order6.setStatus(Order.ORDER_STATUS_DISMISSED);



        orders.add(order1);
        orders.add(order2);
        orders.add(order3);
        orders.add(order4);
        orders.add(order5);
        orders.add(order6);
        orders.add(order1);
        orders.add(order2);
        orders.add(order3);
        orders.add(order4);
        orders.add(order5);

        return orders;

    }//getFakeData


    public static ArrayList<Order> getSortedOrders(ArrayList<Order> orders, int orderType, int sortType) {

        Collections.sort(orders, (obj1, obj2) -> {

            if(orderType == OrderFilter.ORDER_TYPE_FILTER_ID && sortType == OrderFilter.ORDER_TYPE_FILTER_SORT_INCREASING) {

                return Integer.compare(obj1.getId(), obj2.getId()); // To compare integer values

            }else if(orderType == OrderFilter.ORDER_TYPE_FILTER_ID && sortType == OrderFilter.ORDER_TYPE_FILTER_SORT_DECREASING) {

                return Integer.compare(obj2.getId(), obj1.getId()); // To compare integer values

            }else if(orderType == OrderFilter.ORDER_TYPE_FILTER_STATUS && sortType == OrderFilter.ORDER_TYPE_FILTER_SORT_INCREASING) {

                return Integer.compare(obj1.getStatus(), obj2.getStatus()); // To compare integer values

            }else if(orderType == OrderFilter.ORDER_TYPE_FILTER_STATUS && sortType == OrderFilter.ORDER_TYPE_FILTER_SORT_DECREASING) {

                return Integer.compare(obj2.getStatus(), obj1.getStatus()); // To compare integer values

            }else if(orderType == OrderFilter.ORDER_TYPE_FILTER_TABLE && sortType == OrderFilter.ORDER_TYPE_FILTER_SORT_INCREASING) {

                return Integer.compare(obj1.getTableId(), obj2.getTableId()); // To compare integer values

            }else if(orderType == OrderFilter.ORDER_TYPE_FILTER_TABLE && sortType == OrderFilter.ORDER_TYPE_FILTER_SORT_DECREASING) {

                return Integer.compare(obj2.getTableId(), obj1.getTableId()); // To compare integer values

            }else if(orderType == OrderFilter.ORDER_TYPE_FILTER_TIME && sortType == OrderFilter.ORDER_TYPE_FILTER_SORT_INCREASING) {

                return Long.compare((obj1.getTime().getTime()), obj2.getTime().getTime()); // To compare integer values

            }else if(orderType == OrderFilter.ORDER_TYPE_FILTER_TIME && sortType == OrderFilter.ORDER_TYPE_FILTER_SORT_DECREASING) {

                return Long.compare(obj2.getTime().getTime(), obj1.getTime().getTime()); // To compare integer values

            }

            // ## Ascending order
            //return obj1.firstName.compareToIgnoreCase(obj2.firstName); // To compare string values
            //return Integer.compare(obj1.getPriority(), obj2.getPriority()); // To compare integer values
            // ## Descending order
            // return obj2.firstName.compareToIgnoreCase(obj1.firstName); // To compare string values
            return Integer.compare(obj2.getId(), obj1.getId()); // To compare integer values

        });

        return orders;

    }//saveTasks


}//OrdersManager
