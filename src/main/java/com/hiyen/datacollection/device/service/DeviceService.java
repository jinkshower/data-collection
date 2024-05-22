package com.hiyen.datacollection.device.service;

import com.hiyen.datacollection.common.service.port.ClockHolder;
import com.hiyen.datacollection.device.controller.dto.request.DeviceRequest;
import com.hiyen.datacollection.device.domain.Device;
import com.hiyen.datacollection.device.service.port.DeviceRepository;
import com.hiyen.datacollection.stationgroup.domain.StationGroup;
import com.hiyen.datacollection.stationgroup.service.port.StationGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeviceService {

    private final DeviceRepository deviceRepository;
    private final StationGroupRepository stationGroupRepository;
    private final ClockHolder clockHolder;

    public Device create(final DeviceRequest request) {
        StationGroup stationGroup = stationGroupRepository.getById(request.getStationGroupId());
        Device device = Device.from(request.getSerialNumber(), stationGroup.getId(), clockHolder);
        return deviceRepository.save(device);
    }
}
