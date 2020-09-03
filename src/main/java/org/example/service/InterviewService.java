package org.example.service;

import org.example.model.Interview;

import java.util.List;

public interface InterviewService {

    Interview save(Interview interview);

    Interview update(Interview interview);

    Interview findById(Integer id);

    List<Interview> findAll();

    void delete(Interview interview);
}
