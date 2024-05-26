package com.hiyen.datacollection.device.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceJpaRepository extends JpaRepository<DeviceEntity, Long> {

}
