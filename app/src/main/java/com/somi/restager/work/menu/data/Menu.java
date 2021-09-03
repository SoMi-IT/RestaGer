package com.somi.restager.work.menu.data;

import java.util.ArrayList;

public class Menu {


    public final static String MENU_ID = "category_id";
    public final static String MENU_NAME = "category_name";
    public final static String MENU_PLATES = "category_plates";

    private int id;
    private String name;
    private ArrayList<Plate> plates;


    public int getId() { return id; }

    public String getName() { return name; }

    public ArrayList<Plate> getPlates() { return plates; }


    public void setId(int _id) { id = _id; }

    public void setName(String _name) { name = _name; }

    public void setPlates(ArrayList<Plate> _plates) { plates = _plates; }


}//Menu
