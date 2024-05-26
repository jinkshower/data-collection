package com.hiyen.datacollection.device.controller.dto;

import com.hiyen.datacollection.common.controller.dto.CommonResponse;
import com.hiyen.datacollection.device.controller.dto.request.DeviceRequest;
import com.hiyen.datacollection.device.controller.dto.response.DeviceResponse;
import com.hiyen.datacollection.device.service.DeviceService;
import jakarta.validation.Valid;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/devices")
@RequiredArgsConstructor
public class DeviceController {

    private final DeviceService deviceService;

    @PostMapping
    public ResponseEntity<CommonResponse<DeviceResponse>> create(
        @Valid @RequestBody DeviceRequest request) {
        DeviceResponse response = deviceService.create(request);
        URI uri = URI.create("/api/devices/" + response.getDeviceId());

        return ResponseEntity.created(uri)
            .body(CommonResponse.from("success", response));
    }
}
