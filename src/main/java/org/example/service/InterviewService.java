package org.example.service;

import org.example.model.Interview;
import org.springframework.data.domain.Page;

public interface InterviewService {

    Interview save(Interview interview);

    Interview update(Interview interview);

    Interview findById(Integer id);

    Page<Interview> findAll(Integer page, Integer size);

    void delete(Interview interview);
}
