package com.somi.restager.work.orders.data;


import java.util.ArrayList;
import java.util.Date;


public class Order {


    public final static String ORDER_ID = "order_id";
    public final static String ORDER_PLATES = "order_plates";
    public final static String ORDER_TIME = "order_time";
    public final static String ORDER_TABLE = "order_table";
    public final static String ORDER_STATUS = "order_status";
    public final static String ORDER_NOTES = "order_notes";

    public final static int ORDER_STATUS_STARTED = 0;
    public final static int ORDER_STATUS_PREPARATION = 1;
    public final static int ORDER_STATUS_READY = 2;
    public final static int ORDER_STATUS_INCOMING = 3;
    public final static int ORDER_STATUS_DELIVERED = 4;
    public final static int ORDER_STATUS_DISMISSED = 5;

    private int id;
    private ArrayList<OrderedPlate> orderedPlates;
    private Date time;
    private int tableId;
    private int status;
    private String notes;


    public int getId() { return id; }

    public ArrayList<OrderedPlate> getOrderedPlates() { return orderedPlates; }

    public Date getTime() { return time; }

    public int getTableId() { return tableId; }

    public int getStatus() { return status; }

    public String getNotes() { return notes; }


    public void setId(int _id) { id = _id; }

    public void setOrderedPlates(ArrayList<OrderedPlate> _orderedPlates) { orderedPlates = _orderedPlates; }

    public void setTime(Date _time) { time = _time; }

    public void setTableId(int _tableId) { tableId = _tableId; }

    public void setStatus(int _status) { status = _status; }

    public void setNotes(String _notes) { notes = _notes; }


}//Order
