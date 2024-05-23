package com.hiyen.datacollection.acceptance;

import static com.hiyen.datacollection.acceptance.DataCollectionFixtures.스테이션_그룹_URL;
import static org.junit.jupiter.api.Assertions.assertAll;

import com.hiyen.datacollection.common.controller.dto.CommonResponse;
import com.hiyen.datacollection.stationgroup.controller.dto.request.StationGroupRequest;
import com.hiyen.datacollection.stationgroup.controller.dto.response.StationGroupResponse;
import io.restassured.common.mapper.TypeRef;
import org.junit.jupiter.api.Test;
import org.springframework.http.HttpStatus;

public class StationGroupAcceptanceTest extends AcceptanceTest {

    @Test
    void 스테이션_그룹을_생성할_수_있다() {
        // given
        final var 그룹_시리얼넘버 = "SG1";
        final var 요청_객체 = new StationGroupRequest(그룹_시리얼넘버);

        // when
        final var 스테이션_그룹_생성응답 = 생성요청(스테이션_그룹_URL, 요청_객체);
        final var 응답_객체 = 스테이션_그룹_생성응답.body().as(
            new TypeRef<CommonResponse<StationGroupResponse>>() {
            });
        final var 생성된_스테이션_그룹 = 응답_객체.getData();
        // then
        assertAll(
            응답일치(스테이션_그룹_생성응답, HttpStatus.CREATED),
            단일_데이터_검증(응답_객체.getMsg(), "success"),
            단일_데이터_검증(생성된_스테이션_그룹.getSerialNumber(), 그룹_시리얼넘버)
        );
    }
}
