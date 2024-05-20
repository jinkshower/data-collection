package com.hiyen.datacollection.data.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.hiyen.datacollection.data.domain.Data;
import com.hiyen.datacollection.exception.badrequest.SerialNumberInvalidException;
import com.hiyen.datacollection.exception.badrequest.TimeInvalidException;
import com.hiyen.datacollection.exception.badrequest.ValueInvalidException;
import java.time.LocalDateTime;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class DataTest {

    @DisplayName("Data는")
    @Nested
    class DataConstructor {
        
        @DisplayName("serialNumber, value, time으로 생성할 수 있다.")
        @Test 
        void success_to_create() {
            //given
            final var serialNumber = "WX12345";
            final var value = 10;
            final var time = LocalDateTime.of(2023, 1, 1, 16, 0, 0);

            //when
            final var actual = new Data(serialNumber, value, time);

            //then
            assertThat(actual)
                .usingRecursiveComparison()
                .isEqualTo(new Data(serialNumber, value, time));
        }
        
        @DisplayName("serialNumber가 null이거나 비어있을 경우 예외가 발생한다")
        @NullAndEmptySource
        @ParameterizedTest
        void creating_data_with_null_or_empty_serial_number_should_fail(final String invalidSerialNumber) {
            //given
            final var serialNumber = invalidSerialNumber;
            final var value = 10;
            final var time = LocalDateTime.of(2023, 1, 1, 16, 0, 0);

            //when & then
            assertThatThrownBy(() -> new Data(serialNumber, value, time))
                .isInstanceOf(SerialNumberInvalidException.class);
        }

        @DisplayName("value가 null이거나 비어있을 경우 예외가 발생한다")
        @Test
        void creating_data_with_null_or_empty_value_should_fail() {
            //given
            final var serialNumber = "WX12345";
            final Integer value = null;
            final var time = LocalDateTime.of(2023, 1, 1, 16, 0, 0);

            //when & then
            assertThatThrownBy(() -> new Data(serialNumber, value, time))
                .isInstanceOf(ValueInvalidException.class);
        }

        @DisplayName("time이 null이거나 비어있을 경우 예외가 발생한다")
        @Test
        void creating_data_with_null_or_empty_time_should_fail() {
            //given
            final var serialNumber = "WX12345";
            final var value = 10;
            final LocalDateTime time = null;

            //when & then
            assertThatThrownBy(() -> new Data(serialNumber, value, time))
                .isInstanceOf(TimeInvalidException.class);
        }
    }

}
