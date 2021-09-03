package com.somi.restager.work.tables.adapter;


import com.somi.restager.work.orders.data.Order;
import com.somi.restager.work.tables.data.Table;


public interface TablesListAdapterListener {

    void onItemClicked(Table table);
    void onItemNotesClicked(Table table);
    void onItemLocationClicked(Table table);

}//TablesListAdapterListener
