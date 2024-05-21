package com.hiyen.datacollection.device.service;

import com.hiyen.datacollection.device.controller.dto.request.DeviceRequest;
import com.hiyen.datacollection.device.domain.Device;
import com.hiyen.datacollection.device.service.port.DeviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeviceService {

    private final DeviceRepository deviceRepository;

    public Device create(final DeviceRequest request) {
        Device device = new Device(request.getSerialNumber(), request.getStationGroupId());
        return deviceRepository.save(device);
    }
}
