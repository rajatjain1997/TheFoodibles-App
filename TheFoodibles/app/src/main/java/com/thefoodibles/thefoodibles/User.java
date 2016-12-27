package com.thefoodibles.thefoodibles;

import android.media.Image;

import java.util.ArrayList;

/**
 * Created by Rajat on 17-10-2016.
 */
public class User {
    private String username, userid, email, password;
    private ArrayList<Order> pendingorders;
    private Address address1, address2;
    private Image profilepic;

    public User() {
        username = "Generic Username";
        userid = "Nothing much";
        email = "pop@gmail.com";
        address1 = new Address("12", "Nark");
        address2 = new Address("01", "Stark");
    }

    public Image getProfilepic() {
        return profilepic;
    }

    public void setProfilepic(Image profilepic) {
        this.profilepic = profilepic;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setUserid(String userid) {
        this.userid = userid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public ArrayList<Order> getPendingorders() {
        return pendingorders;
    }

    public void setPendingorders(ArrayList<Order> pendingorders) {
        this.pendingorders = pendingorders;
    }

    public String getAddress1() {
        return address1.toString();
    }

    public void setAddress1(Address address) {
        this.address1 = address;
    }

    public String getAddress2() {
        return address2.toString();
    }

    public void setAddress2(Address address) {
        this.address2 = address;
    }

    private class Address{
        private String houseno, sector;

        public Address(String houseno, String sector) {
            this.houseno = houseno;
            this.sector = sector;
        }

        public String getHouseno() {
            return houseno;
        }

        public String getSector() {
            return sector;
        }

        public void setHouseno(String houseno) {
            this.houseno = houseno;
        }

        public void setSector(String sector) {
            this.sector = sector;
        }

        public String toString() {
            return houseno + ", " + sector;
        }
    }
}

