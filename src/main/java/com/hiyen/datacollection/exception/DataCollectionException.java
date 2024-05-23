package com.hiyen.datacollection.exception;

public abstract class DataCollectionException extends RuntimeException {

    public DataCollectionException(final String message) {
        super(message);
    }

    public DataCollectionException(final String message, final Exception e) {
        super(message, e);
    }

    public abstract int getStatusCode();
}
