package com.logistica.soaptracking.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.Date;
import java.util.List;

@XmlRootElement(name = "GetTrackingStatusResponse", namespace = "http://logistica.com/ws/tracking")
public class GetTrackingStatusResponse {

    private String status;
    private String currentLocation;
    private Date estimatedDeliveryDate;
    private List<TrackingEventDTO> history;
    private TrackingError error; // ✅ mover aquí el error

    @XmlElement(namespace = "http://logistica.com/ws/tracking")
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @XmlElement(namespace = "http://logistica.com/ws/tracking")
    public String getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(String currentLocation) {
        this.currentLocation = currentLocation;
    }

    @XmlElement(namespace = "http://logistica.com/ws/tracking")
    public Date getEstimatedDeliveryDate() {
        return estimatedDeliveryDate;
    }

    public void setEstimatedDeliveryDate(Date estimatedDeliveryDate) {
        this.estimatedDeliveryDate = estimatedDeliveryDate;
    }

    @XmlElement(namespace = "http://logistica.com/ws/tracking")
    public List<TrackingEventDTO> getHistory() {
        return history;
    }

    public void setHistory(List<TrackingEventDTO> history) {
        this.history = history;
    }

    @XmlElement(namespace = "http://logistica.com/ws/tracking")
    public TrackingError getError() {
        return error;
    }

    public void setError(TrackingError error) {
        this.error = error;
    }

    public static class TrackingEventDTO {
        private Date date;
        private String description;
        private String location;

        @XmlElement(namespace = "http://logistica.com/ws/tracking")
        public Date getDate() {
            return date;
        }

        public void setDate(Date date) {
            this.date = date;
        }

        @XmlElement(namespace = "http://logistica.com/ws/tracking")
        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        @XmlElement(namespace = "http://logistica.com/ws/tracking")
        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }
    }
}
