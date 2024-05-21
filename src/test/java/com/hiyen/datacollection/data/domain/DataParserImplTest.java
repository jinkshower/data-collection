package com.hiyen.datacollection.data.domain;

import static org.assertj.core.api.Assertions.assertThat;

import com.hiyen.datacollection.data.service.port.DataParser;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class DataParserImplTest {

    private DataParser dataParser;

    @BeforeEach
    void setUp() {
        dataParser = new DataParserImpl();
    }

    @Test
    void parse_성공() {
        //given
        final var serialNumber = "WX12345";
        final var interval = 30;
        final var dataSet = "000AFFFC0007FFF7";
        final var recordedAt = "2023-01-01 16:00:00";

        //when
        final var actual = dataParser.parse(serialNumber, interval, dataSet, recordedAt);

        //then
        assertThat(actual.size()).isEqualTo(4);
        assertThat(actual.get(0).getDeviceSerialNumber()).isEqualTo("WX12345");
        assertThat(actual.get(0).getDataValue()).isEqualTo(10);
        assertThat(actual.get(0).getTime()).isEqualTo("2023-01-01 16:30:00");
    }
}
