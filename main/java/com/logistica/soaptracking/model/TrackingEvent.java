package com.logistica.soaptracking.model;

import java.util.Date;

public class TrackingEvent {
    private Date date;
    private String description;
    private String location;

    public Date getDate() { return date; }
    public void setDate(Date date) { this.date = date; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public String getLocation() { return location; }
    public void setLocation(String location) { this.location = location; }
}