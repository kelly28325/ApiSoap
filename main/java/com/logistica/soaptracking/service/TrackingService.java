package com.logistica.soaptracking.service;

import com.logistica.soaptracking.model.Package;
import com.logistica.soaptracking.model.TrackingEvent;
import org.springframework.stereotype.Service;
import java.util.ArrayList;


import java.util.*;

@Service
public class TrackingService {
    private final Map<String, Package> data = new HashMap<>();

    public TrackingService() {
        TrackingEvent event1 = new TrackingEvent();
        event1.setDate(new Date());
        event1.setDescription("Paquete recibido en bodega central");
        event1.setLocation("Lima");

        Package pkg = new Package();
        pkg.setTrackingNumber("PE1234567890");
        pkg.setSenderName("Juan");
        pkg.setReceiverName("Maria");
        pkg.setOrigin("Quito");
        pkg.setDestination("Lima");
        pkg.setWeight(2.5);
        pkg.setDimensions("10x10x20");
        pkg.setStatus("En tránsito");
        pkg.setCurrentLocation("Lima - Perú");
        pkg.setEstimatedDeliveryDate(new GregorianCalendar(2025, Calendar.APRIL, 15).getTime());
        List<TrackingEvent> events = new ArrayList<>();
        events.add(event1);
        pkg.setHistory(events);


        data.put(pkg.getTrackingNumber(), pkg);
    }

    public Package getPackageByTrackingNumber(String trackingNumber) {
        return data.get(trackingNumber);
    }
}