package com.somi.restager.work.tab;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import com.somi.restager.R;
import com.somi.restager.work.WorkActivity;
import com.somi.restager.work.WorkActivityListener;

public class TabFragment extends Fragment implements Button.OnClickListener, WorkActivityListener {


    public static int MENU_ORDERS = 0;
    public static int MENU_TABLES = 1;
    public static int MENU_WAITERS = 2;

    private WorkActivity activity;

    private TabFragmentListener listener;

    private Button b_orders;
    private Button b_tables;
    private Button b_waiters;



    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {


        activity = (WorkActivity) getActivity();

        View rootView = inflater.inflate(R.layout.fragment_tabs, container, false);

        b_orders = rootView.findViewById(R.id.ib_menu_sew);
        b_orders.setOnClickListener(this);

        b_tables = rootView.findViewById(R.id.ib_menu_knit);
        b_tables.setOnClickListener(this);

        b_waiters = rootView.findViewById(R.id.ib_menu_shop);
        b_waiters.setOnClickListener(this);

        activity.setMenuListener(this);

        b_orders.setBackgroundTintList(activity.getColorStateList(R.color.blue_700));

        return rootView;

    }//onCreateView


    private void changeSelectedTab(int position){

        if(b_orders == null) return;

        b_orders.setBackgroundTintList(activity.getColorStateList(R.color.white_300));
        b_tables.setBackgroundTintList(activity.getColorStateList(R.color.white_300));
        b_waiters.setBackgroundTintList(activity.getColorStateList(R.color.white_300));

        if(position == MENU_ORDERS) b_orders.setBackgroundTintList(activity.getColorStateList(R.color.blue_700));
        if(position == MENU_TABLES) b_tables.setBackgroundTintList(activity.getColorStateList(R.color.blue_700));
        if(position == MENU_WAITERS) b_waiters.setBackgroundTintList(activity.getColorStateList(R.color.blue_700));

    }//changeSelectedTab


    public void onClick(View v) {

        if (v == b_orders && listener!= null) listener.OnOrdersSelected();
        if (v == b_tables && listener!= null) listener.OnTablesSelected();
        if (v == b_waiters && listener!= null) listener.OnWaitersSelected();

    }//onClick


    public void setListener(TabFragmentListener _listener) {

        listener = _listener;

    }//setListener


    public void OnPageChanged(int page) {
        changeSelectedTab(page);

    }//OnPageChanged

    public void OnSheetsDateSelected() { }


}//MenuFragment
