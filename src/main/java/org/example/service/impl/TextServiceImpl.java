package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dao.TextDAO;
import org.example.model.Photo;
import org.example.model.Text;
import org.example.service.TextService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;

@Service
@RequiredArgsConstructor
public class TextServiceImpl implements TextService {

    private final TextDAO textDAO;

    @Override
    public Text save(Text text) {
        if (text.getId() != null) {
            try {
                throw new Exception("Text already exists");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return textDAO.save(text);
    }

    @Override
    public Text update(Text text) {
        if (text.getId() == null) {
            try {
                throw new Exception("Text id not found");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return textDAO.save(text);
    }

    @Override
    public Text findById(Integer id) {
        Optional<Text> text = ofNullable(textDAO.findById(id))
                .orElseThrow(() -> new RuntimeException());
        return text.get();
    }

    @Override
    public List<Text> findAll() {
        Sort sort = Sort.by(Sort.Direction.DESC, "creationTimeText");
        return  textDAO.findAll(sort);
    }

    @Override
    public List<Text> findAllByNewsId(Integer newsId) {
        return textDAO.findAllByNewsId(newsId);
    }

    @Override
    public List<Text> findAllByTrainingId(Integer trainingId) {
        return textDAO.findAllByTrainingId(trainingId);
    }

    @Override
    public List<Text> findAllByInterviewId(Integer interviewId) {
        return textDAO.findAllByInterviewId(interviewId);
    }

    @Override
    public void delete(Text text) {
        textDAO.delete(text);
    }
}
