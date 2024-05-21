package com.hiyen.datacollection.data.service;

import com.hiyen.datacollection.data.controller.dto.request.DataRequest;
import com.hiyen.datacollection.data.domain.Data;
import com.hiyen.datacollection.data.service.port.DataParser;
import com.hiyen.datacollection.data.service.port.DataRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class DataService {

    private final DataParser dataParser;
    private final DataRepository dataRepository;

    public List<Data> create(final DataRequest dataRequest) {
        List<Data> datas = dataParser.parse(dataRequest.getSerialNumber(),
            dataRequest.getInterval(), dataRequest.getDataSet(), dataRequest.getRecordedAt());
        return dataRepository.saveAll(datas);
    }
}
