package com.hiyen.datacollection.stationgroup.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.hiyen.datacollection.exception.badrequest.SerialNumberInvalidException;
import java.time.LocalDateTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class StationGroupTest {
    
    @DisplayName("StationGroup는")
    @Nested
    class StationGroupConstructor {
    
        @DisplayName("serialNumber로 생성할 수 있다")
        @Test
        void success_to_create() {
            //given
            final var serialNumber = "WX12345";
            final var createdAt = LocalDateTime.of(2013, 1, 1, 0, 0, 0);

            //when
            final var actual = new StationGroup(serialNumber, createdAt);

            //then
            assertThat(actual)
                .usingRecursiveComparison()
                .isEqualTo(new StationGroup(serialNumber, createdAt));
        }

        @DisplayName("serialNumber가 null이거나 비어있을 경우 예외가 발생한다")
        @NullAndEmptySource
        @ParameterizedTest
        void creating_station_group_with_null_or_empty_serial_number_should_fail(
            final String invalidSerialNumber) {
            //given
            final var serialNumber = invalidSerialNumber;
            final var createdAt = LocalDateTime.of(2013, 1, 1, 0, 0, 0);

            //when & then
            assertThatThrownBy(() -> {
                new StationGroup(serialNumber, createdAt);
            }).isInstanceOf(SerialNumberInvalidException.class);
        }
    }
}
