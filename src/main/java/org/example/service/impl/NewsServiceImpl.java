package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dao.NewsDAO;
import org.example.model.News;
import org.example.model.Photo;
import org.example.model.Text;
import org.example.model.Video;
import org.example.service.NewsService;
import org.example.service.PhotoService;
import org.example.service.TextService;
import org.example.service.VideoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static java.util.Optional.ofNullable;

@Service
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService {

    private final NewsDAO newsDAO;

    private final PhotoService photoService;

    private final VideoService videoService;

    private final TextService textService;

    @Override
    public News save(News news) {
        if (news.getId() != null) {
            try {
                throw new Exception("News already exists");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return newsDAO.save(news);
    }

    @Override
    public News update(News news) {
        if (news.getId() == null) {
            try {
                throw new Exception("News id not found");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return newsDAO.save(news);
    }

    @Override
    public News findById(Integer id) {
        Optional<News> news = ofNullable(newsDAO.findById(id))
                .orElseThrow(() -> new RuntimeException());
        News newsSet = news.get();
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
        newsSet.setListPhotos(listPhotos);
        newsSet.setListPhotos(listVideo);
        newsSet.setListTexts(listTexts);
        return newsSet;
    }


    @Override
    public Page<News> findAll(String pageLanguage, Integer page, Integer size) {
        if (page > 0) {
            page--;
        } else {
            page = 0;
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "creationTime");
        PageRequest pageRequest = PageRequest.of(page, size, sort);
        return newsDAO.findAllByPageLanguage(pageLanguage, pageRequest);
    }

    @Override
    public Page<News> findAllByCountry(String country, String pageLanguage, Integer page, Integer size) {
        if (page > 0) {
            page--;
        } else {
            page = 0;
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "creationTime");
        PageRequest pageRequest = PageRequest.of(page, size, sort);
        return newsDAO.findAllByCountryAndPageLanguage(country, pageLanguage, pageRequest);
    }

    @Override
    public Page<News> findAllByCountryIsNot(String pageLanguage, String country, Integer page, Integer size) {
        if (page > 0) {
            page--;
        } else {
            page = 0;
        }
        Sort sort = Sort.by(Sort.Direction.DESC, "creationTime");
        PageRequest pageRequest = PageRequest.of(page, size, sort);
        return newsDAO.findAllByCountryIsNotAndPageLanguage(pageLanguage, country, pageRequest);
    }

    @Override
    public void delete(News news) {
        newsDAO.delete(news);
    }
}
