package com.somi.restager.work.orders;

public class Table {


    public final static String TABLE_ID = "table_id";
    public final static String TABLE_IS_INSIDE = "table_is_inside";
    public final static String TABLE_ROOM = "table_room";
    public final static String TABLE_NUMBER = "table_number";
    public final static String TABLE_SEATS = "table_seats";
    public final static String TABLE_DESCRIPTION = "table_description";

    private int id;
    private boolean isInside;
    private String room;
    private int number;
    private int seats;
    private String description;


    public int getId() { return id; }

    public boolean isInside() { return isInside; }

    public String getRoom() { return room; }

    public int getNumber() { return number; }

    public int getSeats() { return seats; }

    public String getDescription() { return description; }


    public void setId(int _id) { id = _id; }

    public void setInside(boolean _isInside) { isInside = _isInside; }

    public void setRoom(String _room) { room = _room; }

    public void setNumber(int _number) { number = _number; }

    public void setSeats(int _seats) { seats = _seats; }

    public void setDescription(String _description) { description = _description; }


}//Table
