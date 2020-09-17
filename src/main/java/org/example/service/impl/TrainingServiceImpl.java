package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dao.ActionLogDAO;
import org.example.dao.TrainingDAO;
import org.example.model.*;
import org.example.service.PhotoService;
import org.example.service.TextService;
import org.example.service.TrainingService;
import org.example.service.VideoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;

@Service
@RequiredArgsConstructor
public class TrainingServiceImpl implements TrainingService {

    private final TrainingDAO trainingDAO;

    private final PhotoService photoService;

    private final VideoService videoService;

    private final TextService textService;

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
        Training trainingSet = training.get();
        List<String> listPhotos = new ArrayList<>();
        List<String> listVideo = new ArrayList<>();
        List<String> listTexts = new ArrayList<>();
        for (Photo photo : photoService.findAllByNewsId(id)) {
            listPhotos.add(photo.getLink());
        }
        for (Video video: videoService.findAllByNewsId(id)) {
            listVideo.add(video.getLink());
        }
        for (Text text: textService.findAllByNewsId(id)) {
            listTexts.add(text.getText());
        }
        trainingSet.setListPhotos(listPhotos);
        trainingSet.setListPhotos(listVideo);
        trainingSet.setListTexts(listTexts);
        return trainingSet;
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
