package com.hiyen.datacollection.device.domain;

import com.hiyen.datacollection.common.service.port.ClockHolder;
import com.hiyen.datacollection.exception.badrequest.SerialNumberInvalidException;
import java.time.LocalDateTime;
import org.springframework.util.StringUtils;

public class Device {

    private final Long id;
    private final String serialNumber;
    private final Long stationGroupId;
    private final LocalDateTime createdAt;

    public Device(final Long id, final String serialNumber, final Long stationGroupId,
        final LocalDateTime createdAt) {
        this.id = id;
        this.serialNumber = serialNumber;
        this.stationGroupId = stationGroupId;
        this.createdAt = createdAt;

        validateSerialNumber();
    }

    public Device(final String serialNumber, final Long stationGroupId,
        final LocalDateTime createdAt) {
        this(null, serialNumber, stationGroupId, createdAt);
    }

    public static Device from(final String serialNumber, final Long stationGroupId, final
    ClockHolder clockHolder) {
        return new Device(serialNumber, stationGroupId, clockHolder.now());
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

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}
