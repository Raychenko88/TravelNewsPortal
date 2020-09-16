package org.example.service;

import org.example.model.Photo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface PhotoService {

    Photo save(Photo photo);

    Photo update(Photo photo);

    Photo findById(Integer id);

    List<Photo> findAll();

    List<Photo> findAllByNewsId(Integer newsId);

    List<Photo> findAllByTrainingId(Integer trainingId);

    List<Photo> findAllByInterviewId(Integer interviewId);

    void delete(Photo photo);
}
