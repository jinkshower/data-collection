package com.hiyen.datacollection.device.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.hiyen.datacollection.common.mock.TestClockHolder;
import com.hiyen.datacollection.common.service.port.ClockHolder;
import com.hiyen.datacollection.device.controller.dto.request.DeviceRequest;
import com.hiyen.datacollection.device.mock.FakeDeviceRepository;
import com.hiyen.datacollection.device.service.port.DeviceRepository;
import com.hiyen.datacollection.stationgroup.domain.StationGroup;
import com.hiyen.datacollection.stationgroup.mock.FakeStationGroupRepository;
import com.hiyen.datacollection.stationgroup.service.port.StationGroupRepository;
import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DeviceServiceTest {

    private DeviceService deviceService;
    private LocalDateTime testNow;

    @BeforeEach
    void setup() {
        StationGroupRepository stationGroupRepository = new FakeStationGroupRepository();
        DeviceRepository deviceRepository = new FakeDeviceRepository();
        testNow = LocalDateTime.of(2013, 1, 1, 16, 0, 0);
        ClockHolder clockHolder = new TestClockHolder(testNow);
        deviceService = new DeviceService(deviceRepository, stationGroupRepository, clockHolder);

        StationGroup stationGroup = new StationGroup("serial", testNow);
        stationGroupRepository.save(stationGroup);
    }

    @DisplayName("Device를 생성할 수 있다")
    @Test
    void create() {
        //given
        final var serialNumber = "WX12345";
        final var stationGroupId = 1L;
        final var request = new DeviceRequest(serialNumber, stationGroupId);

        //when
        final var actual = deviceService.create(request);

        //then
        assertAll(
            () -> assertThat(actual.getSerialNumber()).isEqualTo(serialNumber),
            () -> assertThat(actual.getStationGroup().getStationGroupId()).isEqualTo(stationGroupId),
            () -> assertThat(actual.getCreatedAt()).isEqualTo(testNow)
        );
    }
}
