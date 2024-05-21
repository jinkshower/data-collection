package com.hiyen.datacollection.device.domain;

import com.hiyen.datacollection.exception.badrequest.SerialNumberInvalidException;
import org.springframework.util.StringUtils;

public class Device {

    private final Long id;
    private final String serialNumber;
    private final int stationGroupId;

    public Device(final Long id, final String serialNumber, final int stationGroupId) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.stationGroupId = stationGroupId;

        validateSerialNumber();
    }

    public Device(final String serialNumber, final int stationGroupId) {
        this(null, serialNumber, stationGroupId);
    }

    private void validateSerialNumber() {
        if (!StringUtils.hasText(this.serialNumber)) {
            throw new SerialNumberInvalidException(this.serialNumber);
        }
    }
}
