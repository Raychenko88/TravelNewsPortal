package org.example.service;

import org.example.model.Training;
import org.springframework.data.domain.Page;

public interface TrainingService {

    Training save(Training training) throws Exception;

    Training update(Training training) throws Exception;

    Training findById(Integer id) throws Exception;

    Page<Training> findAll(Integer page, Integer size);

    void delete(Training training);
}
