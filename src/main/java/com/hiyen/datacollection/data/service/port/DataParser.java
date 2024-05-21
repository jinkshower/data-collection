package com.hiyen.datacollection.data.service.port;

import com.hiyen.datacollection.data.domain.Data;
import java.util.List;

public interface DataParser {

    List<Data> parse(String serialNumber, int interval, String dataSet, String recordedAt);
}
