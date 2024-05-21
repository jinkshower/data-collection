package com.hiyen.datacollection.data.controller.dto.request;

import static org.assertj.core.api.Assertions.assertThat;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class DataRequestTest {

    @DisplayName("DataRequest는")
    @Nested
    class DataRequestConstructor {

        @DisplayName("serialNumber, interval, dataSet, recordedAt으로 생성할 수 있다.")
        @Test
        void success_to_create() {
            //given
            final var serialNumber = "WX12345";
            final var interval = 30;
            final var dataSet = "000AFFFC0007FFF7";
            final var recordedAt = "2023-01-01 16:00:00";

            //when
            final var actual = new DataRequest(serialNumber, interval, dataSet, recordedAt);
            System.out.println(actual.getRecordedAt());

            //then
            assertThat(actual)
                .usingRecursiveComparison()
                .isEqualTo(new DataRequest(serialNumber, interval, dataSet, recordedAt));
        }

        @DisplayName("serialNumber가 null이거나 비어있을 경우 예외가 발생한다")
        @NullAndEmptySource
        @ParameterizedTest
        void creating_data_request_with_null_or_empty_serial_number_should_fail(
            String invalidSerialNumber) {
            //given
            final String serialNumber = invalidSerialNumber;
            final var interval = 30;
            final var dataSet = "000AFFFC0007FFF7";
            final var recordedAt = "2023-01-01 16:00:00";

            //when
            final var result = validate(
                new DataRequest(serialNumber, interval, dataSet, recordedAt));

            //then
            assertThat(result.size()).isEqualTo(1);
        }

        @DisplayName("interval이 1보다 작을 경우 예외가 발생한다")
        @ParameterizedTest
        @CsvSource({"0", "-1"})
        void creating_data_request_with_negative_interval_should_fail(int invalidInterval) {
            //given
            final var serialNumber = "WX12345";
            final var interval = invalidInterval;
            final var dataSet = "000AFFFC0007FFF7";
            final var recordedAt = "2023-01-01 16:00:00";

            //when
            final var result = validate(
                new DataRequest(serialNumber, interval, dataSet, recordedAt));

            //then
            assertThat(result.size()).isEqualTo(1);
        }

        @DisplayName("dataSet이 null이거나 비어있을 경우 예외가 발생한다")
        @NullAndEmptySource
        @ParameterizedTest
        void creating_data_request_with_null_or_empty_data_set_should_fail(String invalidDataSet) {
            //given
            final var serialNumber = "WX12345";
            final var interval = 30;
            final String dataSet = invalidDataSet;
            final var recordedAt = "2023-01-01 16:00:00";

            //when
            final var result = validate(
                new DataRequest(serialNumber, interval, dataSet, recordedAt));

            //then
            assertThat(result.size()).isEqualTo(1);
        }

        @DisplayName("recordedAt이 yyyy-MM-dd HH:mm:ss형식이 아닐 경우 예외가 발생한다")
        @Test
        void creating_data_request_with_inappropriate_should_fail() {
            //given
            final var serialNumber = "WX12345";
            final var interval = 30;
            final var dataSet = "000AFFFC0007FFF7";
            final var recordedAt = "2023-01-0116:00:00";

            //when
            final var result = validate(
                new DataRequest(serialNumber, interval, dataSet, recordedAt));

            //then
            assertThat(result.size()).isEqualTo(1);
        }
        
        @DisplayName("dataSet이 16진수가 아니거나 4의 배수 자리가 아니면 예외가 발생한다.")
        @ParameterizedTest
        @CsvSource({"@@#$", "0f2z", "00"})
        void creating_data_request_with_invalid_data_set_should_fail(String invalidDataSet) {
            //given
            final var serialNumber = "WX12345";
            final var interval = 30;
            final String dataSet = invalidDataSet;
            final var recordedAt = "2023-01-01 16:00:00";

            //when
            final var result = validate(
                new DataRequest(serialNumber, interval, dataSet, recordedAt));

            //then
            assertThat(result.size()).isEqualTo(1);
        }
    }

    private Set<ConstraintViolation<DataRequest>> validate(DataRequest request) {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        Validator validator = factory.getValidator();
        return validator.validate(request);
    }
}
