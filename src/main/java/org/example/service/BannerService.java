package org.example.service;

import org.example.model.Banner;

public interface BannerService {

    Banner save(Banner banner);

    Banner update(Banner banner);

    Banner findById(Integer id);

    void delete(Banner banner);
}
