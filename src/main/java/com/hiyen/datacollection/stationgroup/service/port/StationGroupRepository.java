package com.hiyen.datacollection.stationgroup.service.port;

import com.hiyen.datacollection.stationgroup.domain.StationGroup;

public interface StationGroupRepository {

    StationGroup save(StationGroup stationGroup);

    StationGroup getById(long stationGroupId);
}
