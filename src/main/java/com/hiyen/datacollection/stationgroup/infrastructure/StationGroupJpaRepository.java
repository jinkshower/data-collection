package com.hiyen.datacollection.stationgroup.infrastructure;

import com.hiyen.datacollection.stationgroup.domain.StationGroup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StationGroupJpaRepository extends JpaRepository<StationGroupEntity, Long> {

}
