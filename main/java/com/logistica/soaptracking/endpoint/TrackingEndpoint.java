package com.logistica.soaptracking.endpoint;

import com.logistica.soaptracking.model.GetTrackingStatusRequest;
import com.logistica.soaptracking.model.GetTrackingStatusResponse;
import com.logistica.soaptracking.model.Package;
import com.logistica.soaptracking.model.GetTrackingStatusResponse.TrackingEventDTO;
import com.logistica.soaptracking.service.TrackingService;
import com.logistica.soaptracking.model.TrackingError;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

import java.util.List;
import java.util.stream.Collectors;
@Endpoint
public class TrackingEndpoint {

    private static final String NAMESPACE_URI = "http://logistica.com/ws/tracking";

    private final TrackingService trackingService;

    public TrackingEndpoint(TrackingService trackingService) {
        this.trackingService = trackingService;
    }

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "GetTrackingStatusRequest")
    @ResponsePayload
    public GetTrackingStatusResponse getTrackingStatus(@RequestPayload GetTrackingStatusRequest request) {

        Package pkg = trackingService.getPackageByTrackingNumber(request.getTrackingNumber());
        GetTrackingStatusResponse response = new GetTrackingStatusResponse();

        if (pkg != null) {
            response.setStatus(pkg.getStatus());
            response.setCurrentLocation(pkg.getCurrentLocation());
            response.setEstimatedDeliveryDate(pkg.getEstimatedDeliveryDate());

            List<TrackingEventDTO> history = pkg.getHistory().stream().map(event -> {
                TrackingEventDTO dto = new TrackingEventDTO();
                dto.setDate(event.getDate());
                dto.setDescription(event.getDescription());
                dto.setLocation(event.getLocation());
                return dto;
            }).collect(Collectors.toList());

            response.setHistory(history);
        } else {
            TrackingError error = new TrackingError();
            error.setErrorCode("404");
            error.setErrorMessage("Paquete no encontrado");
            error.setInvalidField(" tracking no encontrado");

            response.setError(error);
            response.setStatus("NOT_FOUND");
            response.setCurrentLocation(" campos invalidos");
            response.setEstimatedDeliveryDate(null);
            response.setHistory(List.of());
        }

        return response;
    }
}
