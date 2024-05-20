package com.hiyen.datacollection.exception.badrequest;

import java.time.LocalDateTime;

public class TimeInvalidException extends BadRequestException {

    private static final String DEFAULT_MESSAGE = "시간이 유효하지 않습니다.";
    private static final String MESSAGE_FORMAT = "시간이 유효하지 않습니다 : %s";

    public TimeInvalidException() {
        super(DEFAULT_MESSAGE);
    }

    public TimeInvalidException(final LocalDateTime time) {
        super(String.format(MESSAGE_FORMAT, time));
    }
}
