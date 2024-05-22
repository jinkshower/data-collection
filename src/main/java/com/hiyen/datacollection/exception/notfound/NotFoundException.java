package com.hiyen.datacollection.exception.notfound;

import com.hiyen.datacollection.exception.badrequest.DataCollectionException;

public class NotFoundException extends DataCollectionException {

    private static final String DEFAULT_MESSAGE = "찾을 수 없습니다.";

    public NotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    public NotFoundException(final String message) {
        super(message);
    }
}
