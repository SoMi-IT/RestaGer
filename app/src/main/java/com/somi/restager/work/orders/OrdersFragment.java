package com.somi.restager.work.orders;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.somi.restager.R;
import com.somi.restager.work.WorkActivity;
import com.somi.restager.work.orders.adapter.OrdersListAdapter;
import com.somi.restager.work.orders.adapter.OrdersListAdapterListener;
import com.somi.restager.work.orders.data.Order;
import com.somi.restager.work.orders.dialog.OrderEditDialog;
import com.somi.restager.work.orders.filter.data.OrderFilter;
import com.somi.restager.work.orders.filter.OrderFilterFragmentListener;
import com.somi.restager.work.orders.filter.OrdersFilterFragment;
import com.somi.restager.work.orders.manager.OrdersManager;
import com.somi.restager.work.orders.manager.OrdersManagerListener;
import com.somi.restager.work.util.dialog.InfoDialog;

import java.util.ArrayList;

public class OrdersFragment extends Fragment implements View.OnClickListener, OrdersListAdapterListener, OrderFilterFragmentListener, OrdersManagerListener {


    private WorkActivity activity;

    private FragmentManager mainFragmentManager;

    private OrdersListAdapter ordersListAdapter;

    private ArrayList<Order> currentOrders;

    private FloatingActionButton fb_add;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        activity = (WorkActivity) getActivity();

        View rootView = inflater.inflate(R.layout.fragment_orders, container, false);

        RecyclerView rv_orders = rootView.findViewById(R.id.rv_orders);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(activity);
        rv_orders.setLayoutManager(layoutManager);

        fb_add = rootView.findViewById(R.id.fb_orders_add);
        fb_add.setOnClickListener(this);

        currentOrders = OrdersManager.getFakeData();
        ordersListAdapter = new OrdersListAdapter(activity, currentOrders);
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
        _fragment.setListener(this);

    }//initMenuFragment



    //------------------OrdersListAdapterListener
    public void onItemClicked(Order order) {

        new OrderEditDialog(activity, order).show();

    }

    public void onItemNotesClicked(Order order) {

        if(order.getNotes().equals("")) new InfoDialog(activity, "No notes", "", "", "").show();
        else new InfoDialog(activity, order.getNotes(), "", "", "").show();

    }//onItemNotesClicked


    public void onClick(View v) {

        if (v == fb_add) {

            //orderAddDialog orderAddDialog = new orderAddDialog(activity);
            //orderAddDialog.show();
        }
    }

    //------------------OrderFilterFragmentListener

    public void OnNewFilter(OrderFilter orderFilter) {

        currentOrders = OrdersManager.getSortedOrders(currentOrders, orderFilter.getType(), orderFilter.getSortType());
        ordersListAdapter.updateAllOrders(currentOrders);

    }//OnNewFilter

    //------------------OrdersManagerListener

    public void OnDataUpdated(ArrayList<Order> orders, int position) {

        ordersListAdapter.updateOrder(orders, position);

    }//OnDataUpdated


    public void OnAllDataUpdated(ArrayList<Order> orders) {

        ordersListAdapter.updateAllOrders(orders);

    }//OnAllDataUpdated

}//OrdersFragment
