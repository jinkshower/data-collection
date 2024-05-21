package com.hiyen.datacollection.device.infrastructure;

import com.hiyen.datacollection.device.domain.Device;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "device")
public class DeviceEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "serial_number")
    private String serialNumber;
    @Column(name = "station_group_id")
    private Long stationGroupId;

    protected DeviceEntity() {
    }

    public static DeviceEntity fromModel(final Device device) {
        DeviceEntity deviceEntity = new DeviceEntity();
        deviceEntity.id = device.getId();
        deviceEntity.serialNumber = device.getSerialNumber();
        deviceEntity.stationGroupId = device.getStationGroupId();
        return deviceEntity;
    }

    public Device toModel() {
        return new Device(id, serialNumber, stationGroupId);
    }
}
