package com.somi.restager.work.orders;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.somi.restager.R;
import com.somi.restager.work.WorkActivity;
import com.somi.restager.work.orders.adapter.OrdersListAdapter;
import com.somi.restager.work.orders.adapter.OrdersListAdapterListener;
import com.somi.restager.work.orders.data.Order;
import com.somi.restager.work.orders.data.OrderedPlate;
import com.somi.restager.work.topbar.TopBarFragment;

import java.util.ArrayList;
import java.util.Arrays;

public class OrdersFragment extends Fragment implements View.OnClickListener, OrdersListAdapterListener {


    private WorkActivity activity;
    private FragmentManager mainFragmentManager;

    private OrdersListAdapter ordersListAdapter;

    private FloatingActionButton fb_add;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        activity = (WorkActivity) getActivity();

        View rootView = inflater.inflate(R.layout.fragment_orders, container, false);

        RecyclerView rv_orders = rootView.findViewById(R.id.rv_orders);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(activity);
        rv_orders.setLayoutManager(layoutManager);

        fb_add = rootView.findViewById(R.id.fb_orders_add);
        fb_add.setOnClickListener(this);

        ordersListAdapter = new OrdersListAdapter(activity, getFakeOrders());
        ordersListAdapter.setListener(this);
        rv_orders.setAdapter(ordersListAdapter);

        initFilterBar(new OrdersFilterFragment());

        return rootView;

    }//onCreateView


    public void initFilterBar(OrdersFilterFragment _fragment) {

        mainFragmentManager = activity.getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = mainFragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.fl_orders_filter, _fragment);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);

        fragmentTransaction.commit();

    }//initMenuFragment


    public ArrayList<Order> getFakeOrders() {

        ArrayList<Order> orders = new ArrayList<>();

        Order order1 = new Order();
        order1.setId(5677);
        order1.setTableId(45);
        order1.setTime("21:23");
        order1.setOrderedPlates(new ArrayList<OrderedPlate>(Arrays.asList(new OrderedPlate(),new OrderedPlate())));
        order1.setStatus(Order.ORDER_STATUS_STARTED);

        Order order2 = new Order();
        order2.setId(5678);
        order2.setTableId(45);
        order2.setTime("21:24");
        order2.setOrderedPlates(new ArrayList<OrderedPlate>(Arrays.asList(new OrderedPlate(),new OrderedPlate(),new OrderedPlate())));
        order2.setStatus(Order.ORDER_STATUS_PREPARATION);

        Order order3 = new Order();
        order3.setId(5679);
        order3.setTableId(46);
        order3.setTime("21:26");
        order3.setOrderedPlates(new ArrayList<OrderedPlate>(Arrays.asList(new OrderedPlate())));
        order3.setStatus(Order.ORDER_STATUS_READY);

        Order order4 = new Order();
        order4.setId(5680);
        order4.setTableId(47);
        order4.setTime("21:27");
        order4.setOrderedPlates(new ArrayList<OrderedPlate>(Arrays.asList(new OrderedPlate(),new OrderedPlate())));
        order4.setStatus(Order.ORDER_STATUS_INCOMING);

        Order order5 = new Order();
        order5.setId(5680);
        order5.setTableId(47);
        order5.setTime("21:27");
        order5.setOrderedPlates(new ArrayList<OrderedPlate>(Arrays.asList(new OrderedPlate(),new OrderedPlate())));
        order5.setStatus(Order.ORDER_STATUS_DELIVERED);

        Order order6 = new Order();
        order6.setId(5680);
        order6.setTableId(47);
        order6.setTime("21:27");
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

    }//getFakeOrders


    public void onItemClicked(Order order) {

    }

    @Override
    public void onItemNotesClicked(Order order) {

    }

    @Override
    public void onItemLocationClicked(Order order) {

    }

    public void onClick(View v) {

        if (v == fb_add) {

            //orderAddDialog orderAddDialog = new orderAddDialog(activity);
            //orderAddDialog.show();
        }
    }

}//OrdersFragment
