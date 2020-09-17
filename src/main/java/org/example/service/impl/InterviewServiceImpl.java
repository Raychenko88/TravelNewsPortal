package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dao.InterviewDAO;
import org.example.model.Interview;
import org.example.model.Photo;
import org.example.model.Text;
import org.example.model.Video;
import org.example.service.InterviewService;
import org.example.service.PhotoService;
import org.example.service.TextService;
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
public class InterviewServiceImpl implements InterviewService {

    private final InterviewDAO interviewDAO;

    private final PhotoService photoService;

    private final VideoService videoService;

    private final TextService textService;

    @Override
    public Interview save(Interview interview) {
        if (interview.getId() != null) {
            try {
                throw new Exception("Interview already exists");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return interviewDAO.save(interview);
    }

    @Override
    public Interview update(Interview interview) {
        if (interview.getId() == null) {
            try {
                throw new Exception("Interview id not found");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return interviewDAO.save(interview);
    }

    @Override
    public Interview findById(Integer id) {
        Optional<Interview> interview = ofNullable(interviewDAO.findById(id))
                .orElseThrow(() -> new RuntimeException());
        Interview interviewSet = interview.get();
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
        interviewSet.setListPhotos(listPhotos);
        interviewSet.setListPhotos(listVideo);
        interviewSet.setListTexts(listTexts);
        return interviewSet;
    }

    @Override
    public Page<Interview> findAll(String pageLanguage, Integer page, Integer size) {
        if (page > 0) {
            page--;
        } else {
            page = 0;
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "creationTime");
        PageRequest pageRequest = PageRequest.of(page, size, sort);
        return interviewDAO.findAllByPageLanguage(pageLanguage, pageRequest);
    }

    @Override
    public void delete(Interview interview) {
        interviewDAO.delete(interview);
    }
}
