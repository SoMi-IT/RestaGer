package com.somi.restager.work.orders.filter;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import com.somi.restager.R;
import com.somi.restager.work.WorkActivity;
import com.somi.restager.work.orders.filter.data.OrderFilter;


public class OrdersFilterFragment extends Fragment implements ImageView.OnClickListener, AdapterView.OnItemSelectedListener {


    private WorkActivity activity;

    private OrderFilterFragmentListener listener;

    private OrderFilter orderFilter;

    ArrayAdapter<String> adapter;

    private TextView tv_amount;
    private Spinner s_filterTypes;
    private ImageButton ib_sort;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        activity = (WorkActivity) getActivity();

        View rootView = inflater.inflate(R.layout.fragment_orders_filter, container, false);

        tv_amount = rootView.findViewById(R.id.tv_orders_filter_amount);

        s_filterTypes = rootView.findViewById(R.id.s_orders_filter);
        adapter = new ArrayAdapter<String>(activity, R.layout.spinner_custom, OrderFilter.ORDER_FILTERS);
        s_filterTypes.setAdapter(adapter);
        s_filterTypes.setOnItemSelectedListener(this);

        ib_sort = rootView.findViewById(R.id.ib_orders_filter);
        ib_sort.setOnClickListener(this);

        initFilter();

        return rootView;

    }//onCreateView


    private void updateAmount() {

        tv_amount.setText("");

    }//initFilter


    private void initFilter() {

        orderFilter = new OrderFilter();
        orderFilter.setType(OrderFilter.ORDER_FILTER_ID);
        orderFilter.setSortType(OrderFilter.ORDER_TYPE_FILTER_SORT_INCREASING);

        updateFilter();
        updateSortFilter();

    }//initFilter


    private void updateSortFilter() {

        if (orderFilter.getSortType() == OrderFilter.ORDER_TYPE_FILTER_SORT_INCREASING){
            ib_sort.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.ic_arrow_up));

        }else if (orderFilter.getSortType() == OrderFilter.ORDER_TYPE_FILTER_SORT_DECREASING){
            ib_sort.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.ic_arrow_down));
        }

    }//updateSortFilter


    private void updateFilter() {

        s_filterTypes.setSelection(adapter.getPosition(orderFilter.getType()));

    }//updateSortFilter


    public void setListener(OrderFilterFragmentListener _listener) {

        listener = _listener;

    }//setListener


    public void onClick(View v) {

        if (v == ib_sort && orderFilter.getSortType() == OrderFilter.ORDER_TYPE_FILTER_SORT_INCREASING){
            orderFilter.setSortType(OrderFilter.ORDER_TYPE_FILTER_SORT_DECREASING);

        }else if (v == ib_sort && orderFilter.getSortType() == OrderFilter.ORDER_TYPE_FILTER_SORT_DECREASING){
            orderFilter.setSortType(OrderFilter.ORDER_TYPE_FILTER_SORT_INCREASING);

        }
        updateSortFilter();
        if(listener != null) listener.OnNewFilter(orderFilter);

    }//onClick

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        orderFilter.setType(OrderFilter.ORDER_FILTERS[position]);
        if(listener != null) listener.OnNewFilter(orderFilter);

    }//onItemSelected


    public void onNothingSelected(AdapterView<?> parent) { }

}//TopBarFragment
