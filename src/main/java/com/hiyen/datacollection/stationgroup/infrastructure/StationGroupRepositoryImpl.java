package com.hiyen.datacollection.stationgroup.infrastructure;

import com.hiyen.datacollection.stationgroup.domain.StationGroup;
import com.hiyen.datacollection.stationgroup.service.port.StationGroupRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class StationGroupRepositoryImpl implements StationGroupRepository {

    private final StationGroupJpaRepository stationGroupJpaRepository;

    @Override
    public StationGroup save(final StationGroup stationGroup) {
        return stationGroupJpaRepository.save(StationGroupEntity.fromModel(stationGroup))
            .toModel();
    }
}
