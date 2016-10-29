package com.managerdream.managerdream_mobile.entities;

/**
 * Created by Home on 25/10/2016.
 */

public class Expense {
    private int id;
    private int price;
    private String description;
    private String category;


    public int getId() { return id; }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory(){return category;}

    public  void setCategory(String category){this.category = category;}
}
