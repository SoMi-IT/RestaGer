package com.somi.restager.work.menu;

public class Plate {


    public final static String PLATE_ID = "plate_id";
    public final static String PLATE_NAME = "plate_name";
    public final static String PLATE_CATEGORY = "plate_category";
    public final static String PLATE_DESCRIPTION = "plate_description";
    public final static String PLATE_ALLERGENS = "plate_allergens";
    public final static String PLATE_FROZEN = "plate_frozen";
    public final static String PLATE_PRICE = "plate_price";
    public final static String PLATE_NOTES = "plate_notes";

    private int id;
    private String name;
    private Category category;
    private String description;
    private String allergens;
    private String frozen;
    private String price;
    private String notes;

    public int getId() { return id; }

    public String getName() { return name; }

    public String getDescription() { return description; }

    public Category getCategory() { return category; }

    public String getAllergens() { return allergens; }

    public String getFrozen() { return frozen; }

    public String getPrice() { return price; }

    public String getNotes() { return notes; }


    public void setId(int _id) { id = _id; }

    public void setName(String _name) { name = _name; }

    public void setDescription(String _description) { description = _description; }

    public void setCategory(Category _category) { category = _category; }

    public void setAllergens(String _allergens) { allergens = _allergens; }

    public void setFrozen(String _frozen) { frozen = _frozen; }

    public void setPrice(String _price) { price = _price; }

    public void setNotes(String _notes) { notes = _notes; }


}//Plate
