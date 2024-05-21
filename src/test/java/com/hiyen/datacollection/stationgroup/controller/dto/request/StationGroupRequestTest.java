package com.hiyen.datacollection.stationgroup.controller.dto.request;

import static org.assertj.core.api.Assertions.assertThat;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class StationGroupRequestTest {

    @DisplayName("StationGroupRequest는")
    @Nested
    class StationGroupRequestConstructor {

        @DisplayName("serialNumber로 생성할 수 있다.")
        @Test
        void success_to_create() {
            //given
            final var serialNumber = "WX12345";

            //when
            final var actual = new StationGroupRequest(serialNumber);

            //then
            assertThat(actual)
                .usingRecursiveComparison()
                .isEqualTo(new StationGroupRequest(serialNumber));
        }

        @DisplayName("serialNumber가 null이거나 비어있을 경우 예외가 발생한다")
        @Test
        void creating_station_group_request_with_null_or_empty_serial_number_should_fail() {
            //given
            final String serialNumber = null;

            //when
            final var result = validate(new StationGroupRequest(serialNumber));

            //then
            assertThat(result.size()).isEqualTo(1);
        }
    }

    private Set<ConstraintViolation<StationGroupRequest>> validate(StationGroupRequest request) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        return validator.validate(request);
    }
}
