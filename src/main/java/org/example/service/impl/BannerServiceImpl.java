package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dao.BannerDAO;
import org.example.model.Banner;
import org.example.service.BannerService;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BannerServiceImpl implements BannerService {

    private final BannerDAO bannerDAO;

    @Override
    public Banner save(Banner banner) throws Exception {
        if (banner.getId() != null) {
            throw new Exception("Banner already exists");
        }
        return bannerDAO.save(banner);
    }

    @Override
    public Banner update(Banner banner) throws Exception {
        if (banner.getId() == null) {
            throw new Exception("Banner id not found");
        }
        return bannerDAO.save(banner);
    }

    @Override
    public Banner finById(Integer id) throws Exception {
        return bannerDAO.findById(id).orElseThrow(() -> new Exception("Banner not found"));
    }

    @Override
    public void delete(Banner banner) {
        bannerDAO.delete(banner);
    }
}
