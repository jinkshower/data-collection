package com.hiyen.datacollection.data.infrastructure;

import com.hiyen.datacollection.data.domain.Data;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "datas")
public class DataEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "device_serial_number")
    private String deviceSerialNumber;
    @Column(name = "data_value")
    private Integer dataValue;
    @Column(name = "time")
    private String time;

    protected DataEntity() {
    }

    public static DataEntity fromModel(final Data data) {
        DataEntity dataEntity = new DataEntity();
        dataEntity.id = data.getId();
        dataEntity.deviceSerialNumber = data.getDeviceSerialNumber();
        dataEntity.dataValue = data.getDataValue();
        dataEntity.time = data.getTime();
        return dataEntity;
    }

    public Data toModel() {
        return new Data(id, deviceSerialNumber, dataValue, time);
    }
}
