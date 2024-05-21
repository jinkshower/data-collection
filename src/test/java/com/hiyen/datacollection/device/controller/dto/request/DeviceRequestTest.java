package com.hiyen.datacollection.device.controller.dto.request;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class DeviceRequestTest {

    @DisplayName("DeviceRequest는")
    @Nested
    class DeviceRequestConstructor {

        @DisplayName("serialNumber와 stationGroupId를 받아 생성할 수 있다")
        @Test
        void success_to_create() {
            //given
            final var serialNumber = "WX12345";
            final var stationGroupId = 1L;

            //when
            final var actual = new DeviceRequest(serialNumber, stationGroupId);

            //then
            assertAll(
                () -> assertThat(actual.getSerialNumber()).isEqualTo(serialNumber),
                () -> assertThat(actual.getStationGroupId()).isEqualTo(stationGroupId)
            );
        }

        @DisplayName("serialNumber가 null이거나 비어있을 경우 예외가 발생한다")
        @NullAndEmptySource
        @ParameterizedTest
        void creating_device_request_with_null_or_empty_serial_number_should_fail(
            final String invalidSerialNumber) {
            //given
            final var serialNumber = invalidSerialNumber;
            final var stationGroupId = 1L;

            //when
            final var result = validate(new DeviceRequest(serialNumber, stationGroupId));

            //then
            assertThat(result.size()).isEqualTo(1);
        }
    }

    private Set<ConstraintViolation<DeviceRequest>> validate(DeviceRequest request) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        return validator.validate(request);
    }
}
