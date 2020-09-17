package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dao.VideoDAO;
import org.example.model.Photo;
import org.example.model.Video;
import org.example.service.VideoService;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;

@Service
@RequiredArgsConstructor
public class VideoServiceImpl implements VideoService {

    private final VideoDAO videoDAO;

    @Override
    public Video save(Video video) {
        if (video.getId() != null) {
            try {
                throw new Exception("Video already exists");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return videoDAO.save(video);
    }

    @Override
    public Video update(Video video) {
        if (video.getId() == null) {
            try {
                throw new Exception("Video id not found");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return videoDAO.save(video);
    }

    @Override
    public Video findById(Integer id) {
        Optional<Video> video = ofNullable(videoDAO.findById(id))
                .orElseThrow(() -> new RuntimeException());
        return video.get();
    }

    @Override
    public List<Video> findAll() {
        Sort sort = Sort.by(Sort.Direction.DESC, "creationTimeVideo");
        return videoDAO.findAll(sort);
    }

    @Override
    public List<Video> findAllByNewsId(Integer newsId) {
        return videoDAO.findAllByNewsId(newsId);
    }

    @Override
    public List<Video> findAllByTrainingId(Integer trainingId) {
        return videoDAO.findAllByTrainingId(trainingId);
    }

    @Override
    public List<Video> findAllByInterviewId(Integer interviewId) {
        return videoDAO.findAllByInterviewId(interviewId);
    }

    @Override
    public void delete(Video video) {
        videoDAO.delete(video);
    }
}
