package com.hiyen.datacollection.exception.notfound;

public class StationGroupNotFoundException extends NotFoundException {

    private static final String DEFAULT_MESSAGE = "스테이션 그룹을 찾을 수 없습니다.";

    public StationGroupNotFoundException() {
        super(DEFAULT_MESSAGE);
    }

    public StationGroupNotFoundException(final String message) {
        super(message);
    }
}
