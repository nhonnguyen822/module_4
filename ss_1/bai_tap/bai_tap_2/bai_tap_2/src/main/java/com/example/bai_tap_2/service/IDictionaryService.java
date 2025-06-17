package com.example.bai_tap_2.service;

import java.util.Map;

public interface IDictionaryService {
    String findByWord(String word);

    Map<String, String> findAll();
}
