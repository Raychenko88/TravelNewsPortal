package org.example.dao;

import org.example.model.Banner;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BannerDAO extends JpaRepository<Banner, Integer> {
}
