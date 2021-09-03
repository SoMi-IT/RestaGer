package com.somi.restager.work.tables.filter.data;

public class TableFilter {


    public final static String TABLE_FILTER_NUMBER = "Number";
    public final static int TABLE_TYPE_FILTER_NUMBER = 0;

    public final static String TABLE_FILTER_IS_INSIDE = "Inside-Out";
    public final static int TABLE_TYPE_FILTER_IS_INSIDE = 1;

    public final static String TABLE_FILTER_IS_FREE = "Is Free";
    public final static int TABLE_TYPE_FILTER_IS_FREE = 2;

    public final static String TABLE_FILTER_ROOM = "Room";
    public final static int TABLE_TYPE_FILTER_ROOM = 3;

    public final static String TABLE_FILTER_SEATS = "Seats";
    public final static int TABLE_TYPE_FILTER_SEATS = 4;

    public final static String[] TABLE_FILTERS = {TABLE_FILTER_NUMBER, TABLE_FILTER_IS_INSIDE, TABLE_FILTER_IS_FREE, TABLE_FILTER_ROOM, TABLE_FILTER_SEATS};

    public final static int TABLE_TYPE_FILTER_SORT_INCREASING = 0;
    public final static int TABLE_TYPE_FILTER_SORT_DECREASING = 1;

    private int type;
    private int sortType;


    public int getType() { return type; }

    public int getSortType() { return sortType; }


    public void setType(int _type) { type = _type; }

    public void setSortType(int _sortType) { sortType = _sortType; }


}//TableFilter
