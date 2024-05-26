package com.hiyen.datacollection.acceptance;

import static com.hiyen.datacollection.acceptance.DataCollectionFixtures.디바이스_URL;
import static com.hiyen.datacollection.acceptance.DataCollectionFixtures.스테이션_그룹_URL;
import static com.hiyen.datacollection.acceptance.DataCollectionFixtures.스테이션_그룹_생성요청;
import static org.junit.jupiter.api.Assertions.assertAll;

import com.hiyen.datacollection.common.controller.dto.CommonResponse;
import com.hiyen.datacollection.device.controller.dto.request.DeviceRequest;
import com.hiyen.datacollection.device.controller.dto.response.DeviceResponse;
import com.hiyen.datacollection.stationgroup.controller.dto.response.StationGroupResponse;
import io.restassured.common.mapper.TypeRef;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public class DeviceAcceptanceTest extends AcceptanceTest {

    private CommonResponse<StationGroupResponse> 생성된_스테이션_그룹;

    @BeforeEach
    void setUpStationGroup() {
        생성된_스테이션_그룹 = 생성요청(스테이션_그룹_URL, 스테이션_그룹_생성요청).body().as(new TypeRef<>() {
        });
    }

    @Test
    void 디바이스를_생성할_수_있다() {
        // given
        final var 디바이스_시리얼넘버 = "D1";
        final var 스테이션_그룹_ID = 1L;

        final var 요청_객체 = new DeviceRequest(디바이스_시리얼넘버, 스테이션_그룹_ID);

        // when
        final var 디바이스_생성응답 = 생성요청(디바이스_URL, 요청_객체);
        final var 응답_객체 = 디바이스_생성응답.body().as(
            new TypeRef<CommonResponse<DeviceResponse>>() {
            });
        final var 생성된_디바이스 = 응답_객체.getData();
        // then
        assertAll(
            응답일치(디바이스_생성응답, HttpStatus.CREATED),
            단일_데이터_검증(응답_객체.getMsg(), "success"),
            단일_데이터_검증(생성된_디바이스.getDeviceId(), 1L),
            단일_데이터_검증(생성된_디바이스.getSerialNumber(), 디바이스_시리얼넘버),
            단일_데이터_검증(생성된_디바이스.getStationGroup().getStationGroupId(), 스테이션_그룹_ID)
        );
    }
}
