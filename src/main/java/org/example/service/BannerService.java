package org.example.service;

import org.example.model.Banner;

public interface BannerService {

    Banner save(Banner banner) throws Exception;

    Banner update(Banner banner) throws Exception;

    Banner finById(Integer id) throws Exception;

    void delete(Banner banner);
}
