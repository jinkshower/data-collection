package com.hiyen.datacollection.data.infrastructure;

import com.hiyen.datacollection.data.domain.Data;
import com.hiyen.datacollection.data.service.port.DataRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class DataRepositoryImpl implements DataRepository {

    private final DataJpaRepository dataJpaRepository;

    @Override
    public List<Data> saveAll(final List<Data> datas) {
        List<DataEntity> entities = datas.stream()
            .map(DataEntity::fromModel)
            .toList();
        return dataJpaRepository.saveAll(entities).stream()
            .map(DataEntity::toModel)
            .toList();
    }
}
