package org.example.service;

import org.example.model.Training;

import java.util.List;

public interface TrainingService {

    Training save(Training training);

    Training update(Training training);

    Training findById(Integer id);

    List<Training> findAll();

    void delete(Training training);
}
