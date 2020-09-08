package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dao.TrainingDAO;
import org.example.model.Training;
import org.example.service.TrainingService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class TrainingServiceImpl implements TrainingService {

    private final TrainingDAO trainingDAO;

    @Override
    public Training save(Training training) throws Exception {
        if (training.getId() != null) {
            throw new Exception("Training already exists");
        }
        return trainingDAO.save(training);
    }

    @Override
    public Training update(Training training) throws Exception {
        if (training.getId() == null) {
            throw new Exception("Training id not found");
        }
        return trainingDAO.save(training);
    }

    @Override
    public Training findById(Integer id) throws Exception {
        return trainingDAO.findById(id).orElseThrow(() -> new Exception("Training not found"));
    }

    @Override
    public Page<Training> findAll(Integer page, Integer size) {
        if (page > 0){
            page--;
        }else {
            page = 0;
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "creationTime");
        PageRequest pageRequest = PageRequest.of(page, size, sort);
        return trainingDAO.findAll(pageRequest);
    }

    @Override
    public void delete(Training training) {
        trainingDAO.delete(training);
    }
}
