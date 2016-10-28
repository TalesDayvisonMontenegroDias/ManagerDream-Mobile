package com.managerdream.managerdream_mobile.entities;

/**
 * Created by Home on 25/10/2016.
 */

public class Expense {
    private int id;
    private int price;
    private String description;
    private int paymentDay;

    public Expense(int id,int price, String description, int paymentDay){
        this.id = id;
        this.price = price;
        this.description = description;
        this.paymentDay = paymentDay;
    }

    public int getId() {
        return id;
    }

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

    public int getPaymentDay() {
        return paymentDay;
    }

    public void setPaymentDay(int paymentDay) {
        this.paymentDay = paymentDay;
    }
}
