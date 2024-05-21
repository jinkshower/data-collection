package com.hiyen.datacollection.device.mock;

import com.hiyen.datacollection.device.domain.Device;
import com.hiyen.datacollection.device.service.port.DeviceRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.test.util.ReflectionTestUtils;

public class FakeDeviceRepository implements DeviceRepository {

    private final List<Device> store = new ArrayList<>();
    private Long sequence = 0L;

    @Override
    public Device save(final Device device) {
        Device idAssigned = assignId(device);
        store.add(idAssigned);
        return idAssigned;
    }

    private Device assignId(final Device device) {
        ReflectionTestUtils.setField(device, "id", ++sequence);
        return device;
    }
}
