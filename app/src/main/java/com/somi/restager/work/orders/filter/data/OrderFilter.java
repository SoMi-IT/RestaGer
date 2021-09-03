package com.somi.restager.work.orders.filter.data;

import java.util.ArrayList;

public class OrderFilter {


    public final static String ORDER_FILTER_ID = "Id";
    public final static int ORDER_TYPE_FILTER_ID = 0;

    public final static String ORDER_FILTER_STATUS = "Status";
    public final static int ORDER_TYPE_FILTER_STATUS = 1;

    public final static String ORDER_FILTER_TABLE = "Table";
    public final static int ORDER_TYPE_FILTER_TABLE = 2;

    public final static String ORDER_FILTER_TIME = "Time";
    public final static int ORDER_TYPE_FILTER_TIME = 3;

    public final static String[] ORDER_FILTERS = {ORDER_FILTER_ID, ORDER_FILTER_STATUS, ORDER_FILTER_TABLE, ORDER_FILTER_TIME};

    public final static int ORDER_TYPE_FILTER_SORT_INCREASING = 0;
    public final static int ORDER_TYPE_FILTER_SORT_DECREASING = 1;

    private int type;
    private int sortType;


    public int getType() { return type; }

    public int getSortType() { return sortType; }


    public void setType(int _type) { type = _type; }

    public void setSortType(int _sortType) { sortType = _sortType; }


}//OrderFilter
