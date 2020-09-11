package org.example.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.dao.BannerDAO;
import org.example.model.Banner;
import org.example.model.Training;
import org.example.service.BannerService;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static java.util.Optional.ofNullable;

@Service
@RequiredArgsConstructor
public class BannerServiceImpl implements BannerService {

    private final BannerDAO bannerDAO;

    @Override
    public Banner save(Banner banner){
        if (banner.getId() != null) {
            try {
                throw new Exception("Banner already exists");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return bannerDAO.save(banner);
    }

    @Override
    public Banner update(Banner banner){
        if (banner.getId() == null) {
            try {
                throw new Exception("Banner id not found");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return bannerDAO.save(banner);
    }

    @Override
    public Banner findById(Integer id){
        Optional<Banner> banner =  ofNullable(bannerDAO.findById(id))
                .orElseThrow(() -> new RuntimeException());
        return banner.get();
    }

    @Override
    public void delete(Banner banner) {
        bannerDAO.delete(banner);
    }
}
