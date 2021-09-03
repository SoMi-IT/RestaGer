package com.somi.restager.work.menu.data;

public class Category {


    public final static String CATEGORY_ID = "category_id";
    public final static String CATEGORY_NAME = "category_name";
    public final static String CATEGORY_PRIORITY = "category_priority";

    private int id;
    private String name;
    private int priority;


    public int getId() { return id; }

    public String getName() { return name; }

    public int getPriority() { return priority; }


    public void setId(int _id) { id = _id; }

    public void setName(String _name) { name = _name; }

    public void setPriority(int _priority) { priority = _priority; }


}//Category
