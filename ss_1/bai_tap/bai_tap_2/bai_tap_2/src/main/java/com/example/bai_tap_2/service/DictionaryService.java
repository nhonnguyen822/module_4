package com.example.bai_tap_2.service;

import com.example.bai_tap_2.repository.IDictionaryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class DictionaryService implements IDictionaryService {
    @Autowired
    private IDictionaryRepository dictionaryRepository;

    @Override
    public String findByWord(String word) {
        return dictionaryRepository.findByWord(word);
    }

    @Override
    public Map<String, String> findAll() {
        return dictionaryRepository.findAll();
    }
}
