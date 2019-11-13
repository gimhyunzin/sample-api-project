package com.kakaopay.jupiter.api.sample.service;

import com.kakaopay.jupiter.api.sample.domain.SampleParams;
import com.kakaopay.jupiter.api.sample.domain.SampleUser;
import com.kakaopay.jupiter.api.sample.repository.SampleRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class SampleService {

    @Autowired
    private SampleRepository sampleRepository;

    public List<SampleUser> getUserListByName(SampleParams params) {
        return sampleRepository.findByName(params.getName());
    }

    public List<SampleUser> getUserListByAge(SampleParams params) {
        return sampleRepository.findByAge(params.getAge());
    }

    public SampleUser saveUser(SampleUser user) {
        return sampleRepository.save(user);
    }

    public SampleUser getUserById(long id) {
        return sampleRepository.findById(id).orElse(new SampleUser());
    }
}
