package com.logistica.soaptracking.model;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(namespace = "http://logistica.com/ws/tracking")
public class TrackingError {

    private String errorCode;
    private String errorMessage;
    private String invalidField;

    @XmlElement(namespace = "http://logistica.com/ws/tracking")
    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    @XmlElement(namespace = "http://logistica.com/ws/tracking")
    public String getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(String errorMessage) {
        this.errorMessage = errorMessage;
    }

    @XmlElement(namespace = "http://logistica.com/ws/tracking")
    public String getInvalidField() {
        return invalidField;
    }

    public void setInvalidField(String invalidField) {
        this.invalidField = invalidField;
    }
}
