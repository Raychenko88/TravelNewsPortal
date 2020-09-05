package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dao.NewsDAO;
import org.example.model.News;
import org.example.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class NewsServiceImpl implements NewsService {

    private final NewsDAO newsDAO;

    @Override
    public News save(News news) throws Exception {
        if (news.getId() != null) {
            throw new Exception("News already exists");
        }
        return newsDAO.save(news);
    }

    @Override
    public News update(News news) throws Exception {
        if (news.getId() == null) {
            throw new Exception("News id not found");
        }
        return newsDAO.save(news);
    }

    @Override
    public News findById(Integer id) throws Exception {
        return newsDAO.findById(id).orElseThrow(() -> new Exception("News not found"));
    }


    @Override
    public Page<News> findAll(Integer page, Integer size) {
        Sort sort = Sort.by(Sort.Direction.DESC, "creationTime");
        PageRequest pageRequest = PageRequest.of(page, size, sort); 
        return newsDAO.findAll(pageRequest);
    }

    @Override
    public Page<News> findAllByCountry(String country, Pageable pageable) {
        return newsDAO.findAllByCountry(country, pageable);
    }

    @Override
    public void delete(News news) {
        newsDAO.delete(news);
    }
}