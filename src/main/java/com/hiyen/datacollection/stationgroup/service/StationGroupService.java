package com.hiyen.datacollection.stationgroup.service;

import com.hiyen.datacollection.common.service.port.ClockHolder;
import com.hiyen.datacollection.stationgroup.controller.dto.request.StationGroupRequest;
import com.hiyen.datacollection.stationgroup.domain.StationGroup;
import com.hiyen.datacollection.stationgroup.service.port.StationGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StationGroupService {

    private final StationGroupRepository stationGroupRepository;
    private final ClockHolder clockHolder;

    public StationGroup create(final StationGroupRequest request) {
        StationGroup stationGroup = StationGroup.from(request.getSerialNumber(), clockHolder);
        return stationGroupRepository.save(stationGroup);
    }
}
