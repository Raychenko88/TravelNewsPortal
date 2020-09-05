package org.example.service;

import org.example.model.Interview;
import org.springframework.data.domain.Page;

public interface InterviewService {

    Interview save(Interview interview) throws Exception;

    Interview update(Interview interview) throws Exception;

    Interview findById(Integer id) throws Exception;

    Page<Interview> findAll(Integer page, Integer size);

    void delete(Interview interview);
}
