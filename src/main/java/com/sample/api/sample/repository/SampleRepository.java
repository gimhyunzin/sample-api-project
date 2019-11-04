package com.sample.api.sample.repository;

import com.sample.api.sample.domain.Sample;
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
