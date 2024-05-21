package com.hiyen.datacollection.stationgroup.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.hiyen.datacollection.stationgroup.controller.dto.request.StationGroupRequest;
import com.hiyen.datacollection.stationgroup.mock.FakeStationGroupRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StationGroupServiceTest {

    private StationGroupService stationGroupService;

    @BeforeEach
    void setup() {
        stationGroupService = new StationGroupService(new FakeStationGroupRepository());
    }

    @DisplayName("StationGroup을 생성할 수 있다")
    @Test
    void create() {
        //given
        final var serialNumber = "WX12345";
        final var request = new StationGroupRequest(serialNumber);

        //when
        final var actual = stationGroupService.create(request);

        //then
        assertAll(
            () -> assertThat(actual.getId()).isEqualTo(1L),
            () -> assertThat(actual.getSerialNumber()).isEqualTo(serialNumber)
        );
    }
}
