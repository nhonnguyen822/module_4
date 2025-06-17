package com.example.bai_tap_2.repository;

import java.util.List;
import java.util.Map;

public interface IDictionaryRepository {
    String findByWord(String word);

    Map<String, String> findAll();
}
