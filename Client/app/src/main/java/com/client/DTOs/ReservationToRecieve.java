package com.client.DTOs;

public class ReservationToRecieve {
    private int userId;
    private int guestsCount;
    private int roomId;
    private String dateFrom;
    private String dateTo;


    public ReservationToRecieve(int userId, int guestsCount, int roomId, String dateFrom, String dateTo) {
        this.userId = userId;
        this.guestsCount = guestsCount;
        this.roomId = roomId;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
    }


    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getGuestsCount() {
        return guestsCount;
    }

    public void setGuestsCount(int guestsCount) {
        this.guestsCount = guestsCount;
    }

    public int getRoomId() {
        return roomId;
    }

    public void setRoomId(int roomId) {
        this.roomId = roomId;
    }

    public String getDateFrom() {
        return dateFrom;
    }

    public void setDateFrom(String dateFrom) {
        this.dateFrom = dateFrom;
    }

    public String getDateTo() {
        return dateTo;
    }

    public void setDateTo(String dateTo) {
        this.dateTo = dateTo;
    }
}
