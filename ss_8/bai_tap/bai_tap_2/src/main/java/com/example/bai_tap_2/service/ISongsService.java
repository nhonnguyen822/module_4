package com.example.bai_tap_2.service;

import com.example.bai_tap_2.entity.Songs;

import java.util.List;

public interface ISongsService {
    List<Songs> findAll();

    void save(Songs song);

    Songs findById(Long id);

    void deleteById(Long id);
}
