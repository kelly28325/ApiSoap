package com.logistica.soaptracking.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "GetTrackingStatusRequest", namespace = "http://logistica.com/ws/tracking")
public class GetTrackingStatusRequest {
    private String trackingNumber;

    @XmlElement(namespace = "http://logistica.com/ws/tracking")
    public String getTrackingNumber() {
        return trackingNumber;
    }

    public void setTrackingNumber(String trackingNumber) {
        this.trackingNumber = trackingNumber;
    }
}
