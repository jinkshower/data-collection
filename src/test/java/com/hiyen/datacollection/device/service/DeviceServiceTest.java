package com.hiyen.datacollection.device.service;

import static org.junit.jupiter.api.Assertions.*;

import com.hiyen.datacollection.device.controller.dto.request.DeviceRequest;
import com.hiyen.datacollection.device.mock.FakeDeviceRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DeviceServiceTest {

    private DeviceService deviceService;

    @BeforeEach
    void setup() {
        deviceService = new DeviceService(new FakeDeviceRepository());
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
            () -> assertNotNull(actual.getId()),
            () -> assertEquals(serialNumber, actual.getSerialNumber())
        );
    }
}
