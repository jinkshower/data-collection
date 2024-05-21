package com.hiyen.datacollection.device.infrastructure;

import com.hiyen.datacollection.device.domain.Device;
import com.hiyen.datacollection.device.service.port.DeviceRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class DeviceRepositoryImpl implements DeviceRepository {

    private final DeviceJpaRepository deviceJpaRepository;

    @Override
    public Device save(final Device device) {
        return deviceJpaRepository.save(DeviceEntity.fromModel(device)).toModel();
    }
}
