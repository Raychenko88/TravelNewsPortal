package org.example.dao;

import org.example.model.Photo;
import org.example.model.Video;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VideoDAO extends JpaRepository<Video, Integer> {

    List<Video> findAll();

    List<Video> findAllByNewsId(Integer newsId);

    List<Video> findAllByTrainingId(Integer trainingId);

    List<Video> findAllByInterviewId(Integer interviewId);
}
