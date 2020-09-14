package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dao.ActionLogDAO;
import org.example.dao.TrainingDAO;
import org.example.model.ActionLog;
import org.example.model.Training;
import org.example.service.TrainingService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.util.Optional.ofNullable;

@Service
@RequiredArgsConstructor
public class TrainingServiceImpl implements TrainingService {

    private final TrainingDAO trainingDAO;

    private final ActionLogDAO actionLogDAO;

    @Override
    public Training save(Training training){
        if (training.getId() != null) {
            try {
                throw new Exception("Training already exists");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return trainingDAO.save(training);
    }

    @Override
    public Training update(Training training){
        if (training.getId() == null) {
            try {
                throw new Exception("Training id not found");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return trainingDAO.save(training);
    }

    @Override
    public Training findById(Integer id){
        Optional<Training> training = ofNullable(trainingDAO.findById(id))
                .orElseThrow(() -> new RuntimeException());
        return training.get();
    }

    @Override
    public Page<Training> findAll(String pageLanguage, Integer page, Integer size) {
        if (page > 0){
            page--;
        }else {
            page = 0;
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "creationTime");
        PageRequest pageRequest = PageRequest.of(page, size, sort);
        return trainingDAO.findAllByPageLanguage(pageLanguage, pageRequest);
    }

    @Override
    public void delete(Training training) {
        trainingDAO.delete(training);
    }
}
