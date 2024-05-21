package com.hiyen.datacollection.stationgroup.infrastructure;

import com.hiyen.datacollection.stationgroup.domain.StationGroup;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "station_group")
public class StationGroupEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "serial_number")
    private String serialNumber;

    protected StationGroupEntity() {
    }

    public static StationGroupEntity fromModel(final StationGroup stationGroup) {
        StationGroupEntity stationGroupEntity = new StationGroupEntity();
        stationGroupEntity.id = stationGroup.getId();
        stationGroupEntity.serialNumber = stationGroup.getSerialNumber();
        return stationGroupEntity;
    }

    public StationGroup toModel() {
        return new StationGroup(id, serialNumber);
    }
}
