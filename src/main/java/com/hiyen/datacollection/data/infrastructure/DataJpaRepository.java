package com.hiyen.datacollection.data.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DataJpaRepository extends JpaRepository<DataEntity, Long> {

}
