package com.hiyen.datacollection.device.service.port;

import com.hiyen.datacollection.device.domain.Device;

public interface DeviceRepository {

    Device save(Device device);
}
