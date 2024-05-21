package com.hiyen.datacollection.stationgroup.domain;

import com.hiyen.datacollection.exception.badrequest.SerialNumberInvalidException;
import org.springframework.util.StringUtils;

public class StationGroup {

    private final Long id;
    private final String serialNumber;

    public StationGroup(final Long id, final String serialNumber) {
        this.id = id;
        this.serialNumber = serialNumber;

        validateSerialNumber();
    }

    public StationGroup(final String serialNumber) {
        this(null, serialNumber);
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
}
