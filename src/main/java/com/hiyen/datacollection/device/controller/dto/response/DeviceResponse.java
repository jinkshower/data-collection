package com.hiyen.datacollection.device.controller.dto.response;

import com.hiyen.datacollection.device.domain.Device;
import com.hiyen.datacollection.stationgroup.controller.dto.response.StationGroupResponse;
import java.time.LocalDateTime;
import lombok.Getter;

@Getter
public class DeviceResponse {

    private Long deviceId;
    private String serialNumber;
    private StationGroupResponse stationGroup;
    private LocalDateTime createdAt;

    public DeviceResponse() {
    }

    public DeviceResponse(final Long deviceId, final String serialNumber,
        final StationGroupResponse stationGroup,
        final LocalDateTime createdAt) {
        this.deviceId = deviceId;
        this.serialNumber = serialNumber;
        this.stationGroup = stationGroup;
        this.createdAt = createdAt;
    }

    public static DeviceResponse from(final Device device,
        final StationGroupResponse stationGroupResponse) {
        return new DeviceResponse(
            device.getId(),
            device.getSerialNumber(),
            stationGroupResponse,
            device.getCreatedAt()
        );
    }
}
