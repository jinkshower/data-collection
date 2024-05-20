package com.hiyen.datacollection.exception.badrequest;

public class ValueInvalidException extends BadRequestException {

    private static final String DEFAULT_MESSAGE = "데이터가 유효하지 않습니다.";
    private static final String MESSAGE_FORMAT = "데이터가 유효하지 않습니다 : %s";

    public ValueInvalidException() {
        super(DEFAULT_MESSAGE);
    }

    public ValueInvalidException(final Integer value) {
        super(String.format(MESSAGE_FORMAT, value));
    }
}
