package org.example.service;

import org.example.model.Photo;
import org.example.model.Text;

import java.util.List;

public interface TextService {

    Text save(Text text);

    Text update(Text text);

    Text findById(Integer id);

    List<Text> findAll();

    List<Text> findAllByNewsId(Integer newsId);

    List<Text> findAllByTrainingId(Integer trainingId);

    List<Text> findAllByInterviewId(Integer interviewId);

    void delete(Text text);
}
