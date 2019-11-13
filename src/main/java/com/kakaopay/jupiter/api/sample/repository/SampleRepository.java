package com.kakaopay.jupiter.api.sample.repository;

import com.kakaopay.jupiter.api.sample.domain.SampleUser;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface SampleRepository extends CrudRepository<SampleUser, Long> {

    List<SampleUser> findByName(@Param("name") String name);

    List<SampleUser> findByAge(int age);
}
