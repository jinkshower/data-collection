package com.hiyen.datacollection.stationgroup;

import com.hiyen.datacollection.exception.badrequest.SerialNumberInvalidException;
import org.springframework.util.StringUtils;

public class StationGroup {

    private final String serialNumber;

    public StationGroup(final String serialNumber) {
        this.serialNumber = serialNumber;

        validateSerialNumber();
    }

    private void validateSerialNumber() {
        if (!StringUtils.hasText(this.serialNumber)) {
            throw new SerialNumberInvalidException(this.serialNumber);
        }
    }
}
