package com.client.Models;

public class Room {
    private int id;
    private int capacity;
    private int doorNum;
    private String imageURL;
    private float pricePerDay;


    public Room(int capacity, int doorNum, String imageURL, float pricePerDay) {
        this.capacity = capacity;
        this.doorNum = doorNum;
        this.imageURL = imageURL;
        this.pricePerDay = pricePerDay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getDoorNum() {
        return doorNum;
    }

    public void setDoorNum(int doorNum) {
        this.doorNum = doorNum;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public float getPricePerDay() {
        return pricePerDay;
    }

    public void setPricePerDay(float pricePerDay) {
        this.pricePerDay = pricePerDay;
    }
}
