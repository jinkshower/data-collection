package com.hiyen.datacollection.acceptance;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.hiyen.datacollection.stationgroup.controller.dto.request.StationGroupRequest;

public class DataCollectionFixtures {

    public static final ObjectMapper objectMapper;

    static {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
    }

    public static final String 스테이션_그룹_URL = "/api/station-groups";
    public static final String 디바이스_URL = "/api/devices";

    public static final StationGroupRequest 스테이션_그룹_생성요청 = new StationGroupRequest("SG1");
}
