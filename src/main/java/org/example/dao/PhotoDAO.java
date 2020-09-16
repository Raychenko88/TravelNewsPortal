package org.example.dao;

import org.example.model.Photo;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PhotoDAO extends JpaRepository<Photo, Integer> {

    List<Photo> findAll();

    List<Photo> findAllByNewsId(Integer newsId);

    List<Photo> findAllByTrainingId(Integer trainingId);

    List<Photo> findAllByInterviewId(Integer interviewId);
}
