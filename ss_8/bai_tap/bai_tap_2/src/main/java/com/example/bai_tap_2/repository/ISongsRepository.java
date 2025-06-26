package com.example.bai_tap_2.repository;

import com.example.bai_tap_2.entity.Songs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ISongsRepository extends JpaRepository<Songs, Long> {
    @Query(value = "select * from songs where song_name like concat('%',:searchName,'%')", countQuery = "select * from songs where song_name like concat('%',:searchName,'%')", nativeQuery = true)
    Page<Songs> searchBySongName(@Param("searchName") String searchName, Pageable pageable);
}
