package org.example.service;

import org.example.model.Video;

import java.util.List;

public interface VideoService {

    Video save(Video video);

    Video update(Video video);

    Video findById(Integer id);

    List<Video> findAll();

    List<Video> findAllByNewsId(Integer newsId);

    List<Video> findAllByTrainingId(Integer trainingId);

    List<Video> findAllByInterviewId(Integer interviewId);

    void delete(Video video);
}
