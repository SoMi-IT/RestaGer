package com.somi.restager.work.orders;


import java.util.ArrayList;


public class Order {


    public final static String ORDER_ID = "order_id";
    public final static String ORDER_PLATES = "order_plates";
    public final static String ORDER_TIME = "order_time";
    public final static String ORDER_TABLE = "order_table";
    public final static String ORDER_STATUS = "order_status";
    public final static String ORDER_NOTES = "order_notes";

    public final static int ORDER_STATUS_STARTED = 0;
    public final static int ORDER_STATUS_PREPARATION = 1;
    public final static int ORDER_STATUS_INCOMING = 2;
    public final static int ORDER_STATUS_DELIVERED = 3;
    public final static int ORDER_STATUS_DISMISSED = 4;

    private int id;
    private ArrayList<OrderedPlate> orderedPlates;
    private String time;
    private int tableId;
    private int status;
    private String notes;


    public int getId() { return id; }

    public ArrayList<OrderedPlate> getName() { return orderedPlates; }

    public String getTime() { return time; }

    public int getTableId() { return tableId; }

    public int getStatus() { return status; }

    public String getNotes() { return notes; }


    public void setId(int _id) { id = _id; }

    public void setName(ArrayList<OrderedPlate> _orderedPlates) { orderedPlates = _orderedPlates; }

    public void setTime(String _time) { time = _time; }

    public void setTableId(int _tableId) { tableId = _tableId; }

    public void setStatus(int _status) { status = _status; }

    public void setNotes(String _notes) { notes = _notes; }


}//Order
