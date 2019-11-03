package com.sample.api.composite.orderlist.sample.repository;

import com.sample.api.composite.orderlist.sample.domain.Sample;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by hjk
 */
public interface SampleRepository extends CrudRepository<Sample, Long> {

    List<Sample> findByLastName(@Param("lastname") String lastname);

    List<Sample> findByFirstName(@Param("firstname") String firstname);
}
