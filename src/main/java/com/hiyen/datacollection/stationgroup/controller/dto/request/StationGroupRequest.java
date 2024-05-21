package com.hiyen.datacollection.stationgroup.controller.dto.request;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class StationGroupRequest {

    @NotBlank
    private String serialNumber;

    public StationGroupRequest() {
    }

    public StationGroupRequest(final String serialNumber) {
        this.serialNumber = serialNumber;
    }
}
