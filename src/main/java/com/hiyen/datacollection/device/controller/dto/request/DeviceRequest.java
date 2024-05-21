package com.hiyen.datacollection.device.controller.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class DeviceRequest {

    @NotBlank
    private String serialNumber;
    private long stationGroupId;

    public DeviceRequest() {
    }

    public DeviceRequest(final String serialNumber, final long stationGroupId) {
        this.serialNumber = serialNumber;
        this.stationGroupId = stationGroupId;
    }
}
