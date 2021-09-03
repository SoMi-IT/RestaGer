package com.somi.restager.work.tables.filter;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Spinner;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;

import com.somi.restager.R;
import com.somi.restager.work.WorkActivity;
import com.somi.restager.work.tables.filter.data.TableFilter;


public class TablesFilterFragment extends Fragment implements ImageView.OnClickListener, AdapterView.OnItemSelectedListener {


    private WorkActivity activity;

    private TableFilterFragmentListener listener;

    private TableFilter tableFilter;

    private Spinner s_filterTypes;

    private ImageButton ib_sort;


    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        activity = (WorkActivity) getActivity();

        View rootView = inflater.inflate(R.layout.fragment_orders_filter, container, false);

        s_filterTypes = rootView.findViewById(R.id.s_orders_filter);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(activity, R.layout.spinner_custom, TableFilter.TABLE_FILTERS);
        s_filterTypes.setAdapter(adapter);
        s_filterTypes.setOnItemSelectedListener(this);

        ib_sort = rootView.findViewById(R.id.ib_orders_filter);
        ib_sort.setOnClickListener(this);

        initFilter();

        return rootView;

    }//onCreateView


    private void initFilter() {

        tableFilter = new TableFilter();
        tableFilter.setType(TableFilter.TABLE_TYPE_FILTER_NUMBER);
        tableFilter.setType(TableFilter.TABLE_TYPE_FILTER_SORT_INCREASING);

        updateFilter();
        updateSortFilter();

    }//initFilter

    private void updateSortFilter() {

        if (tableFilter.getSortType() == TableFilter.TABLE_TYPE_FILTER_SORT_INCREASING){
            ib_sort.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.ic_arrow_up));

        }else if (tableFilter.getSortType() == TableFilter.TABLE_TYPE_FILTER_SORT_DECREASING){
            ib_sort.setImageDrawable(ContextCompat.getDrawable(activity, R.drawable.ic_arrow_down));
        }

    }//updateSortFilter


    private void updateFilter() {

        s_filterTypes.setSelection(tableFilter.getType());

    }//updateSortFilter


    public void setListener(TableFilterFragmentListener _listener) {

        listener = _listener;

    }//setListener


    public void onClick(View v) {

        if (v == ib_sort && tableFilter.getSortType() == TableFilter.TABLE_TYPE_FILTER_SORT_INCREASING){
            tableFilter.setSortType(TableFilter.TABLE_TYPE_FILTER_SORT_DECREASING);

        }else if (v == ib_sort && tableFilter.getSortType() == TableFilter.TABLE_TYPE_FILTER_SORT_DECREASING){
            tableFilter.setSortType(TableFilter.TABLE_TYPE_FILTER_SORT_INCREASING);

        }
        updateSortFilter();
        if(listener != null) listener.OnNewFilter(tableFilter);

    }//onClick

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

        tableFilter.setType(position);
        if(listener != null) listener.OnNewFilter(tableFilter);

    }//onItemSelected


    public void onNothingSelected(AdapterView<?> parent) { }

}//TopBarFragment
