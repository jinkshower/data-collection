package com.hiyen.datacollection.data.service.port;

import com.hiyen.datacollection.data.domain.Data;
import java.util.List;

public interface DataRepository {

    List<Data> saveAll(List<Data> datas);
}
