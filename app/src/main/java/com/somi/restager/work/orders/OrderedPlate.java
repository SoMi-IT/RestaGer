package com.somi.restager.work.orders;


public class OrderedPlate {


    public final static String ORDERED_PLATE_ID = "ordered_plate_id";
    public final static String ORDERED_PLATE_NOTES = "ordered_plate_notes";

    private int plateId;
    private String notes;

    public int getId() { return plateId; }

    public String getNotes() { return notes; }


    public void setId(int _plateId) { plateId = plateId; }

    public void setNotes(String _notes) { notes = _notes; }


}//OrderedPlate
