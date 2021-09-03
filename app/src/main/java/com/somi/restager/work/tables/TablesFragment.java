package com.somi.restager.work.tables;


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
import com.somi.restager.work.orders.data.Order;
import com.somi.restager.work.orders.filter.OrderFilterFragmentListener;
import com.somi.restager.work.orders.filter.OrdersFilterFragment;
import com.somi.restager.work.orders.filter.data.OrderFilter;
import com.somi.restager.work.orders.manager.OrdersManager;
import com.somi.restager.work.tables.adapter.TablesListAdapter;
import com.somi.restager.work.tables.adapter.TablesListAdapterListener;
import com.somi.restager.work.tables.data.Table;
import com.somi.restager.work.tables.filter.TableFilterFragmentListener;
import com.somi.restager.work.tables.filter.TablesFilterFragment;
import com.somi.restager.work.tables.filter.data.TableFilter;
import com.somi.restager.work.tables.manager.TablesManager;

import java.util.ArrayList;

public class TablesFragment extends Fragment implements TablesListAdapterListener, View.OnClickListener,  TableFilterFragmentListener {


    private WorkActivity activity;

    private FragmentManager mainFragmentManager;

    private TablesListAdapter tablesListAdapter;

    private ArrayList<Table> currentTables;

    private FloatingActionButton fb_add;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        activity = (WorkActivity) getActivity();

        View rootView = inflater.inflate(R.layout.fragment_tables, container, false);

        RecyclerView rv_orders = rootView.findViewById(R.id.rv_tables);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(activity, 2);
        rv_orders.setLayoutManager(layoutManager);

        fb_add = rootView.findViewById(R.id.fb_tables_add);
        fb_add.setOnClickListener(this);

        currentTables = TablesManager.getFakeData();
        tablesListAdapter = new TablesListAdapter(activity, currentTables);
        tablesListAdapter.setListener(this);
        rv_orders.setAdapter(tablesListAdapter);

        initFilterBar(new TablesFilterFragment());

        return rootView;

    }//onCreateView

    public void initFilterBar(TablesFilterFragment _fragment) {

        mainFragmentManager = activity.getSupportFragmentManager();

        FragmentTransaction fragmentTransaction = mainFragmentManager.beginTransaction();

        fragmentTransaction.replace(R.id.fl_tables_filter, _fragment);
        fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);

        fragmentTransaction.commit();
        _fragment.setListener(this);

    }//initMenuFragment



    //------------------TablesListAdapterListener

    public void onItemClicked(Table table) {

    }


    public void onItemNotesClicked(Table table) {

    }


    public void onItemLocationClicked(Table table) {

    }


    public void onClick(View v) {

        if (v == fb_add) {

            //orderAddDialog orderAddDialog = new orderAddDialog(activity);
            //orderAddDialog.show();
        }
    }

    //------------------OrderFilterFragmentListener

    public void OnNewFilter(TableFilter tableFilter) {

        currentTables = TablesManager.getSortedOrders(currentTables, tableFilter.getType(), tableFilter.getSortType());
        tablesListAdapter.updateOrders(currentTables);

    }


}//OrdersFragment
