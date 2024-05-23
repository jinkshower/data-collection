package com.hiyen.datacollection.stationgroup.controller.dto.response;

import com.hiyen.datacollection.stationgroup.domain.StationGroup;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class StationGroupResponse {

    private Long stationGroupId;
    private String serialNumber;
    private LocalDateTime createdAt;

    public StationGroupResponse() {
    }

    public StationGroupResponse(final Long stationGroupId, final String serialNumber,
        final LocalDateTime createdAt) {
        this.stationGroupId = stationGroupId;
        this.serialNumber = serialNumber;
        this.createdAt = createdAt;
    }

    public static StationGroupResponse from(final StationGroup stationGroup) {
        return new StationGroupResponse(
            stationGroup.getId(),
            stationGroup.getSerialNumber(),
            stationGroup.getCreatedAt()
        );
    }
}
