package com.thefoodibles.thefoodibles;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Rajat on 17-10-2016.
 */
public class Order {
    private Item item;
    private Date delivery_date;
    private double amount;
    private int quantity;
    public static ArrayList<Order> orders = new ArrayList<Order>();
    public static ArrayList<Order> pendingorders = new ArrayList<Order>();
    public static double net_cost;

    public Order(Item item, int qty) {
        this.item = item;
        delivery_date = makedate();
        amount = item.getCost()*qty;
        net_cost = amount;
        quantity = qty;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public Date getDelivery_date() {
        return delivery_date;
    }

    public void setDelivery_date(Date delivery_date) {
        this.delivery_date = delivery_date;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Date makedate() {
        Date date = new Date();
        if(change(item.getDay())!=date.getDay()) {
            int diff = change(item.getDay()) - date.getDay();
            date.setDate(date.getDate()+diff);
        } else if(date.getHours()>=8&&item.getTime()=="Breakfast") {
            date.setDate(date.getDate()+7);
        } else if(date.getHours()>=11&&item.getTime()=="Lunch") {
            date.setDate(date.getDate()+7);
        } else if(date.getHours()>=17&&item.getTime()=="Dinner") {
            date.setDate(date.getDate()+7);
        } else {
            int diff = date.getDay()-Calendar.MONDAY;
            if(diff>0) {
                date.setDate(date.getDate()+7-diff);
            } else {
                date.setDate(date.getDate()+1);
            }
        }
        return date;
    }

    private int change(String date) {
        switch (date) {
            case "Monday": return 1;
            case "Tuesday": return 2;
            case "Wednesday": return 3;
            case "Thursday": return 4;
            case "Friday": return 5;
            case "Saturday": return 6;
            case "Sunday": return 0;
            default: return -1;
        }
    }
}