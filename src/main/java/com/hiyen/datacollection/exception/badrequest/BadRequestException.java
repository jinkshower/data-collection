package com.hiyen.datacollection.exception.badrequest;

import com.hiyen.datacollection.exception.DataCollectionException;

public class BadRequestException extends DataCollectionException {

    private static final String DEFAULT_MESSAGE = "잘못된 요청입니다.";

    public BadRequestException() {
        super(DEFAULT_MESSAGE);
    }

    public BadRequestException(final String message) {
        super(message);
    }

    @Override
    public int getStatusCode() {
        return 400;
    }
}
