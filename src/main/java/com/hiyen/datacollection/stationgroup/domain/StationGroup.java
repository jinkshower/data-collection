package com.hiyen.datacollection.stationgroup.domain;

import com.hiyen.datacollection.common.service.port.ClockHolder;
import com.hiyen.datacollection.exception.badrequest.SerialNumberInvalidException;
import java.time.LocalDateTime;
import org.springframework.util.StringUtils;

public class StationGroup {

    private final Long id;
    private final String serialNumber;
    private final LocalDateTime createdAt;

    public StationGroup(final Long id, final String serialNumber, final LocalDateTime createdAt) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.createdAt = createdAt;

        validateSerialNumber();
    }

    public StationGroup(final String serialNumber, final LocalDateTime createdAt) {
        this(null, serialNumber, createdAt);
    }

    public static StationGroup from(final String serialNumber, final ClockHolder clockHolder) {
        return new StationGroup(serialNumber, clockHolder.now());
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
