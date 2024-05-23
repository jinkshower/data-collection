package com.hiyen.datacollection.stationgroup.controller;

import com.hiyen.datacollection.common.controller.dto.CommonResponse;
import com.hiyen.datacollection.stationgroup.controller.dto.request.StationGroupRequest;
import com.hiyen.datacollection.stationgroup.controller.dto.response.StationGroupResponse;
import com.hiyen.datacollection.stationgroup.domain.StationGroup;
import com.hiyen.datacollection.stationgroup.service.StationGroupService;
import jakarta.validation.Valid;
import java.net.URI;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/station-groups")
@RequiredArgsConstructor
public class StationGroupController {

    private final StationGroupService stationGroupService;

    @PostMapping
    public ResponseEntity<CommonResponse<StationGroupResponse>> create(
        @Valid @RequestBody StationGroupRequest request) {
        StationGroup created = stationGroupService.create(request);
        StationGroupResponse stationGroupResponse = StationGroupResponse.from(created);
        URI uri = URI.create("/api/station-groups/" + created.getId());

        return ResponseEntity.created(uri)
            .body(CommonResponse.from("success", stationGroupResponse));
    }
}
