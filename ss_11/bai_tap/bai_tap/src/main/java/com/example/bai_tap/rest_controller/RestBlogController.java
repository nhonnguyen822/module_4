package com.example.bai_tap.rest_controller;

import com.example.bai_tap.entity.Blogs;
import com.example.bai_tap.service.IBlogsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/blogs")
public class RestBlogController {
    @Autowired
    private IBlogsService blogsService;

    @GetMapping("")
    public ResponseEntity<Page<Blogs>> getAll(Pageable pageable) {
        Page<Blogs> blogsPage = blogsService.findAll(pageable);
        if (blogsPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogsPage, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blogs> findById(@PathVariable int id) {
        Blogs blog = blogsService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(blog, HttpStatus.OK);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<Blogs> save(@PathVariable int id, @RequestBody Blogs blogs) {
        Blogs blog = blogsService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blogsService.update(blogs);
        return new ResponseEntity<>(blog, HttpStatus.NO_CONTENT);
    }

    @PostMapping("")
    public ResponseEntity<Blogs> save(@RequestBody Blogs blogs) {

        blogsService.add(blogs);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Blogs> delete(@PathVariable int id) {
        Blogs blog = blogsService.findById(id);
        if (blog == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        blogsService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/searchName")
    public ResponseEntity<Page<Blogs>> search(@RequestParam("searchName") String searchName, Pageable pageable) {
        Page<Blogs> blogsPage = blogsService.searchByTitle(searchName, 0, pageable);
        if (blogsPage.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(blogsPage, HttpStatus.OK);
    }
}
