package com.somi.restager.work.orders.data;


import com.somi.restager.work.menu.data.Plate;

import java.util.ArrayList;
import java.util.Date;


public class Order {


    public final static String ORDER_ID = "order_id";
    public final static String ORDER_PLATES = "order_plates";
    public final static String ORDER_TIME = "order_time";
    public final static String ORDER_TABLE = "order_table";
    public final static String ORDER_STATUS = "order_status";
    public final static String ORDER_NOTES = "order_notes";

    public final static String ORDER_STATUS_STARTED = "Started";
    public final static String ORDER_STATUS_PREPARATION = "Preparation";
    public final static String ORDER_STATUS_READY = "Ready";
    public final static String ORDER_STATUS_INCOMING = "Incoming";
    public final static String ORDER_STATUS_DELIVERED = "Deliverd";
    public final static String ORDER_STATUS_DISMISSED = "Aborted";

    public final static String[] ORDER_STATUS_STATUS = {ORDER_STATUS_STARTED, ORDER_STATUS_PREPARATION, ORDER_STATUS_READY, ORDER_STATUS_INCOMING, ORDER_STATUS_DELIVERED, ORDER_STATUS_DISMISSED};

    private int id;
    private ArrayList<Plate> orderedPlates;
    private Date time;
    private int tableId;
    private String status;
    private String notes;


    public int getId() { return id; }

    public ArrayList<Plate> getOrderedPlates() { return orderedPlates; }

    public Date getTime() { return time; }

    public int getTableId() { return tableId; }

    public String getStatus() { return status; }

    public String getNotes() { return notes; }


    public void setId(int _id) { id = _id; }

    public void setOrderedPlates(ArrayList<Plate> _orderedPlates) { orderedPlates = _orderedPlates; }

    public void setTime(Date _time) { time = _time; }

    public void setTableId(int _tableId) { tableId = _tableId; }

    public void setStatus(String _status) { status = _status; }

    public void setNotes(String _notes) { notes = _notes; }


}//Order
