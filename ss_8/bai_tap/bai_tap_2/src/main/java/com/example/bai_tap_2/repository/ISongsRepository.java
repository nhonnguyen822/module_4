package com.example.bai_tap_2.repository;

import com.example.bai_tap_2.entity.Songs;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISongsRepository  extends JpaRepository<Songs,Long> {

}
