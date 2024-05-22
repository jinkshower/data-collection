package com.hiyen.datacollection.common.infrastructure;

import com.hiyen.datacollection.common.service.port.ClockHolder;
import java.time.LocalDateTime;
import org.springframework.stereotype.Component;

@Component
public class SystemClockHolder implements ClockHolder {

    @Override
    public LocalDateTime now() {
        return LocalDateTime.now();
    }
}
