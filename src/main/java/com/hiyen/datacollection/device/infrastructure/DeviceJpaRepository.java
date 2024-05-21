package com.hiyen.datacollection.device.infrastructure;

import com.hiyen.datacollection.device.domain.Device;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeviceJpaRepository extends JpaRepository<DeviceEntity, Long> {

}
