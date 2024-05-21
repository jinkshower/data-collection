package com.hiyen.datacollection.data.mock;

import com.hiyen.datacollection.data.domain.Data;
import com.hiyen.datacollection.data.service.port.DataRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.test.util.ReflectionTestUtils;

public class FakeDataRepository implements DataRepository {

    private final List<Data> store = new ArrayList<>();
    private Long sequence = 0L;

    @Override
    public List<Data> saveAll(final List<Data> datas) {
        List<Data> idAssigned = new ArrayList<>();
        datas.stream().map(this::assignId).forEach(idAssigned::add);
        store.addAll(idAssigned);
        return idAssigned;
    }

    private Data assignId(Data data) {
        ReflectionTestUtils.setField(data, "id", ++sequence);
        return data;
    }
}
