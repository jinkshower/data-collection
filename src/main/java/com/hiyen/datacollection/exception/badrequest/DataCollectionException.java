package com.hiyen.datacollection.exception.badrequest;

public class DataCollectionException extends RuntimeException {

    private static final String DEFAULT_MESSAGE = "잘못된 요청입니다.";

    public DataCollectionException() {
        super(DEFAULT_MESSAGE);
    }

    public DataCollectionException(final String message) {
        super(message);
    }

    public DataCollectionException(final String message, final Exception e) {
        super(message, e);
    }
}
