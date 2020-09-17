package org.example.dao;

import org.example.model.Photo;
import org.example.model.Text;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TextDAO extends JpaRepository<Text, Integer> {

    List<Text> findAll();

    List<Text> findAllByNewsId(Integer newsId);

    List<Text> findAllByTrainingId(Integer trainingId);

    List<Text> findAllByInterviewId(Integer interviewId);
}
