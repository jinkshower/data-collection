package com.hiyen.datacollection.data.domain;

import com.hiyen.datacollection.exception.badrequest.SerialNumberInvalidException;
import com.hiyen.datacollection.exception.badrequest.TimeInvalidException;
import com.hiyen.datacollection.exception.badrequest.ValueInvalidException;
import java.util.Objects;
import org.springframework.util.StringUtils;

public class Data {

    private final Long id;
    private final String deviceSerialNumber;
    private final Integer dataValue;
    private final String time;

    public Data(final Long id, final String deviceSerialNumber, final Integer dataValue,
        final String time) {
        this.id = id;
        this.deviceSerialNumber = deviceSerialNumber;
        this.dataValue = dataValue;
        this.time = time;

        validateSerialNumber();
        validateValue();
        validateTime();
    }

    public Data(final String deviceSerialNumber, final Integer dataValue,
        final String time) {
        this(null, deviceSerialNumber, dataValue, time);
    }

    private void validateSerialNumber() {
        if (!StringUtils.hasText(this.deviceSerialNumber)) {
            throw new SerialNumberInvalidException(this.deviceSerialNumber);
        }
    }

    private void validateValue() {
        if (Objects.isNull(this.dataValue)) {
            throw new ValueInvalidException(this.dataValue);
        }
    }

    private void validateTime() {
        if (!StringUtils.hasText(this.time)) {
            throw new TimeInvalidException(this.time);
        }
    }

    public Long getId() {
        return id;
    }

    public String getDeviceSerialNumber() {
        return deviceSerialNumber;
    }

    public Integer getDataValue() {
        return dataValue;
    }

    public String getTime() {
        return time;
    }
}
