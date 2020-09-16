package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dao.PhotoDAO;
import org.example.model.Photo;
import org.example.service.PhotoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Optional.ofNullable;

@Service
@RequiredArgsConstructor
public class PhotoServiceImpl implements PhotoService {

    private final PhotoDAO photoDAO;

    @Override
    public Photo save(Photo photo) {
        if (photo.getId() != null) {
            try {
                throw new Exception("Photo already exists");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return photoDAO.save(photo);
    }

    @Override
    public Photo update(Photo photo) {
        if (photo.getId() == null) {
            try {
                throw new Exception("Photo id not found");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return photoDAO.save(photo);
    }

    @Override
    public Photo findById(Integer id) {
        Optional<Photo> photo = ofNullable(photoDAO.findById(id))
                .orElseThrow(() -> new RuntimeException());
        return photo.get();
    }

    @Override
    public List<Photo> findAll() {
        Sort sort = Sort.by(Sort.Direction.DESC, "creationTimePhoto");
        List<Photo> list = photoDAO.findAll(sort);
        return photoDAO.findAll();
    }

    @Override
    public List<Photo> findAllByNewsId(Integer newsId) {
        return photoDAO.findAllByNewsId(newsId);
    }

    @Override
    public List<Photo> findAllByTrainingId(Integer trainingId) {
        return photoDAO.findAllByTrainingId(trainingId);
    }

    @Override
    public List<Photo> findAllByInterviewId(Integer interviewId) {
        return photoDAO.findAllByInterviewId(interviewId);
    }

    @Override
    public void delete(Photo photo) {
        photoDAO.delete(photo);
    }
}
