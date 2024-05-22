package com.hiyen.datacollection.stationgroup.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import com.hiyen.datacollection.common.mock.TestClockHolder;
import com.hiyen.datacollection.stationgroup.controller.dto.request.StationGroupRequest;
import com.hiyen.datacollection.stationgroup.mock.FakeStationGroupRepository;
import java.time.LocalDateTime;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StationGroupServiceTest {

    private StationGroupService stationGroupService;
    private LocalDateTime testNow;

    @BeforeEach
    void setup() {
        testNow = LocalDateTime.of(2013, 1, 1, 16, 0, 0);
        stationGroupService = new StationGroupService(new FakeStationGroupRepository(),
            new TestClockHolder(testNow));
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
            () -> assertThat(actual.getSerialNumber()).isEqualTo(serialNumber),
            () -> assertThat(actual.getCreatedAt()).isEqualTo(testNow)
        );
    }
}
