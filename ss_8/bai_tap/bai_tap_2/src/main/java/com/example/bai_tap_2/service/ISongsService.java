package com.example.bai_tap_2.service;

import com.example.bai_tap_2.entity.Songs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ISongsService {
    List<Songs> findAll();

    void save(Songs song);

    Songs findById(Long id);

    void deleteById(Long id);
    Page<Songs> searchBySongName(@Param("searchName") String searchName, Pageable pageable);
}
