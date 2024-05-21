package com.hiyen.datacollection.data.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

import com.hiyen.datacollection.data.controller.dto.request.DataRequest;
import com.hiyen.datacollection.data.domain.DataParserImpl;
import com.hiyen.datacollection.data.mock.FakeDataRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DataServiceTest {

    private DataService dataService;

    @BeforeEach
    void setUp() {
        dataService = new DataService(new DataParserImpl(), new FakeDataRepository());
    }

    @DisplayName("데이터를 생성할 수 있다")
    @Test
    void create() {
        //given
        final var serialNumber = "WX12345";
        final var interval = 30;
        final var dataSet = "000AFFFC0007FFF7";
        final var recordedAt = "2023-01-01 16:00:00";
        final var dataRequest = new DataRequest(serialNumber, interval, dataSet, recordedAt);

        //when
        final var actual = dataService.create(dataRequest);

        //then
        assertAll(
            () -> assertThat(actual.size()).isEqualTo(4),
            () -> assertThat(actual.get(0).getDeviceSerialNumber()).isEqualTo(serialNumber),
            () -> assertThat(actual.get(0).getDataValue()).isEqualTo(10),
            () -> assertThat(actual.get(0).getTime()).isEqualTo("2023-01-01 16:30:00")
        );
    }
}
