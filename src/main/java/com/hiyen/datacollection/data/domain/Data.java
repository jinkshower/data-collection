package com.hiyen.datacollection.data.domain;

import com.hiyen.datacollection.exception.badrequest.SerialNumberInvalidException;
import com.hiyen.datacollection.exception.badrequest.TimeInvalidException;
import com.hiyen.datacollection.exception.badrequest.ValueInvalidException;
import java.time.LocalDateTime;
import java.util.Objects;
import org.springframework.util.StringUtils;

public class Data {

    private Long id;
    private String deviceSerialNumber;
    private Integer value;
    private LocalDateTime time;

    protected Data() {
    }

    public Data(final Long id, final String deviceSerialNumber, final Integer value,
        final LocalDateTime time) {
        this.id = id;
        this.deviceSerialNumber = deviceSerialNumber;
        this.value = value;
        this.time = time;

        validateSerialNumber();
        validateValue();
        validateTime();
    }

    public Data(final String deviceSerialNumber, final Integer value,
        final LocalDateTime time) {
        this(null, deviceSerialNumber, value, time);
    }

    private void validateSerialNumber() {
        if (!StringUtils.hasText(this.deviceSerialNumber)) {
            throw new SerialNumberInvalidException(this.deviceSerialNumber);
        }
    }

    private void validateValue() {
        if (Objects.isNull(this.value)) {
            throw new ValueInvalidException(this.value);
        }
    }

    private void validateTime() {
        if (Objects.isNull(this.time)) {
            throw new TimeInvalidException(this.time);
        }
    }
}
