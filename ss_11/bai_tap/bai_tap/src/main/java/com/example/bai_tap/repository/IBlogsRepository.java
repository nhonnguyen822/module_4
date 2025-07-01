package com.example.bai_tap.repository;

import com.example.bai_tap.entity.Blogs;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface IBlogsRepository extends JpaRepository<Blogs, Integer> {
    @Query(value = "select * from blogs where title like concat('%',:searchName,'%')and category= :categoryId",
            countQuery = "select * from blogs where title like concat('%',:searchName,'%')and category= :categoryId", nativeQuery = true)
    Page<Blogs> searchByTitle(@Param("searchName") String searchName, @Param("categoryId") int categoryId, Pageable pageable);

    @Query(value = "select * from blogs where title like concat('%',:searchName,'%')",
            countQuery = "select * from blogs where title like concat('%',:searchName,'%')", nativeQuery = true)
    Page<Blogs> searchByTitle(@Param("searchName") String searchName,Pageable pageable);
    long countByCategory_Id(int categoryId);
}
