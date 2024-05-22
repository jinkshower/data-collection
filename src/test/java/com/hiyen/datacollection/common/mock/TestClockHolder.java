package com.hiyen.datacollection.common.mock;

import com.hiyen.datacollection.common.service.port.ClockHolder;
import java.time.LocalDateTime;

public class TestClockHolder implements ClockHolder {

    private final LocalDateTime now;

    public TestClockHolder(final LocalDateTime now) {
        this.now = now;
    }

    @Override
    public LocalDateTime now() {
        return now;
    }
}
