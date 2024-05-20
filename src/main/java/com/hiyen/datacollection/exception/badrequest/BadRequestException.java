package com.hiyen.datacollection.exception.badrequest;

public class BadRequestException extends DataCollectionException {

    private static final String DEFAULT_MESSAGE = "잘못된 요청입니다.";

    public BadRequestException() {
        super(DEFAULT_MESSAGE);
    }

    public BadRequestException(final String message) {
        super(message);
    }
}
