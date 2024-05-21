package com.hiyen.datacollection.stationgroup.service;

import com.hiyen.datacollection.stationgroup.controller.dto.request.StationGroupRequest;
import com.hiyen.datacollection.stationgroup.domain.StationGroup;
import com.hiyen.datacollection.stationgroup.service.port.StationGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class StationGroupService {

    private final StationGroupRepository stationGroupRepository;

    public StationGroup create(final StationGroupRequest request) {
        StationGroup stationGroup = new StationGroup(request.getSerialNumber());
        return stationGroupRepository.save(stationGroup);
    }
}
