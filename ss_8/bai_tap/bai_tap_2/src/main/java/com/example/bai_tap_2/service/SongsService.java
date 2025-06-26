package com.example.bai_tap_2.service;

import com.example.bai_tap_2.entity.Songs;
import com.example.bai_tap_2.repository.ISongsRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SongsService implements ISongsService {

    private final ISongsRepository songsRepository;

    public SongsService(ISongsRepository songsRepository) {
        this.songsRepository = songsRepository;
    }

    @Override
    public List<Songs> findAll() {
        return songsRepository.findAll();
    }

    @Override
    public void save(Songs song) {
        songsRepository.save(song);
    }

    @Override
    public Songs findById(Long id) {
        return songsRepository.findById(id).orElse(null);
    }

    @Override
    public void deleteById(Long id) {
        songsRepository.deleteById(id);
    }

    @Override
    public Page<Songs> searchBySongName(String searchName, Pageable pageable) {
        return songsRepository.searchBySongName(searchName, pageable);
    }
}
