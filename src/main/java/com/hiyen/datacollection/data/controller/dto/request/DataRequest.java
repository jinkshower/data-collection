package com.hiyen.datacollection.data.controller.dto.request;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.Getter;

@Getter
public class DataRequest {

    @NotBlank
    private String serialNumber;
    @Min(1)
    private int interval;
    @NotBlank
    @Pattern(regexp = "^(?=[0-9A-Z]*$)(?:.{4})*$")
    private String dataSet;
    @NotBlank
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}$")
    private String recordedAt;

    public DataRequest() {
    }

    public DataRequest(final String serialNumber, final int interval, final String dataSet,
        final String recordedAt) {
        this.serialNumber = serialNumber;
        this.interval = interval;
        this.dataSet = dataSet;
        this.recordedAt = recordedAt;
    }
}
