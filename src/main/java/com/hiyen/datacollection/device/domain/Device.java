package com.hiyen.datacollection.device.domain;

import com.hiyen.datacollection.exception.badrequest.SerialNumberInvalidException;
import org.springframework.util.StringUtils;

public class Device {

    private final Long id;
    private final String serialNumber;
    private final Long stationGroupId;

    public Device(final Long id, final String serialNumber, final Long stationGroupId) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.stationGroupId = stationGroupId;

        validateSerialNumber();
    }

    public Device(final String serialNumber, final Long stationGroupId) {
        this(null, serialNumber, stationGroupId);
    }

    private void validateSerialNumber() {
        if (!StringUtils.hasText(this.serialNumber)) {
            throw new SerialNumberInvalidException(this.serialNumber);
        }
    }

    public Long getId() {
        return id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public Long getStationGroupId() {
        return stationGroupId;
    }
}
