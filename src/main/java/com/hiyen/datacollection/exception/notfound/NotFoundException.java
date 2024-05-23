package com.hiyen.datacollection.exception.notfound;

import com.hiyen.datacollection.exception.DataCollectionException;

public class NotFoundException extends DataCollectionException {

    private static final String DEFAULT_MESSAGE = "찾을 수 없습니다.";

    public NotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    public NotFoundException(final String message) {
        super(message);
    }

    @Override
    public int getStatusCode() {
        return 404;
    }
}
