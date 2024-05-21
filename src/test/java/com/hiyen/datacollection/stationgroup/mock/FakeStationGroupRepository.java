package com.hiyen.datacollection.stationgroup.mock;

import com.hiyen.datacollection.stationgroup.domain.StationGroup;
import com.hiyen.datacollection.stationgroup.service.port.StationGroupRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.test.util.ReflectionTestUtils;

public class FakeStationGroupRepository implements StationGroupRepository {

    private final List<StationGroup> store = new ArrayList<>();
    private Long sequence = 0L;

    @Override
    public StationGroup save(final StationGroup stationGroup) {
        StationGroup idAssigned = assignId(stationGroup);
        store.add(idAssigned);
        return idAssigned;
    }

    private StationGroup assignId(StationGroup stationGroup) {
        ReflectionTestUtils.setField(stationGroup, "id", ++sequence);
        return stationGroup;
    }
}
