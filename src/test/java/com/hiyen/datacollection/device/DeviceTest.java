package com.hiyen.datacollection.device;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import com.hiyen.datacollection.device.domain.Device;
import com.hiyen.datacollection.exception.badrequest.SerialNumberInvalidException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class DeviceTest {
    
    @DisplayName("Device는")
    @Nested
    class DeviceConstructor {

        @DisplayName("serialNumber, stationGroupId로 생성할 수 있다.")
        @Test
        void success_to_create() {
            //given
            final var serialNumber = "WX12345";
            final var stationGroupId = 1;

            //when
            final var actual = new Device(serialNumber, stationGroupId);

            //then
            assertThat(actual)
                .usingRecursiveComparison()
                .isEqualTo(new Device(serialNumber, stationGroupId));
        }

        @DisplayName("serialNumber가 null이거나 비어있을 경우 예외가 발생한다")
        @NullAndEmptySource
        @ParameterizedTest
        void creating_device_with_null_or_empty_serial_number_should_fail(
            final String invalidSerialNumber) {
            //given
            final var serialNumber = invalidSerialNumber;
            final var stationGroupId = 1;

            //when & then
            assertThatThrownBy(() -> new Device(serialNumber, stationGroupId))
                .isInstanceOf(SerialNumberInvalidException.class);
        }
    }

}
