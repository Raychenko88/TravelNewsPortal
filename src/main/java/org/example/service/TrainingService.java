package org.example.service;

import org.example.model.Training;
import org.springframework.data.domain.Page;

public interface TrainingService {

    Training save(Training training);

    Training update(Training training);

    Training findById(Integer id);

    Page<Training> findAll(String pageLanguage, Integer page, Integer size);

    void delete(Training training);
}
