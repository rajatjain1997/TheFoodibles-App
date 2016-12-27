package com.thefoodibles.thefoodibles;

import android.media.Image;

import java.util.ArrayList;

/**
 * Created by Rajat on 20-10-2016.
 */
public class Item {
    private String name;
    private String day;
    private double cost;
    private String image;
    private String category;
    private String time;
    public final static ArrayList<Item> breakfast = new ArrayList<>();
    public final static ArrayList<Item> lunch = new ArrayList<>();
    public final static ArrayList<Item> dinner = new ArrayList<>();
    public final static ArrayList<Item> bulk = new ArrayList<>();

    public Item() {
        name = "Rajma Chawal";
        day = "Sunday";
        cost = 23.05;
        category = "M";
        time = "Lunch";
        image = "https://encrypted-tbn3.gstatic.com/images?q=tbn:ANd9GcRhowfgwfi5_mDycD4tVmS4jJ5wmsOYGYAgl_-6_6BUIocNctI";
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
