package com.Hikerent.controller;

import com.Hikerent.dto.request.NewsRequest;
import com.Hikerent.dto.response.NewsResponse;
import com.Hikerent.service.NewsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/news")
@RequiredArgsConstructor
public class NewsController {

    private final NewsService newsService;

    @PostMapping
    public ResponseEntity<NewsResponse> create(
            @RequestBody NewsRequest request){

        return ResponseEntity.ok(
                newsService.create(request)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<NewsResponse> update(
            @PathVariable Long id,
            @RequestBody NewsRequest request){

        return ResponseEntity.ok(
                newsService.update(id, request)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<NewsResponse> getById(
            @PathVariable Long id){

        return ResponseEntity.ok(
                newsService.getById(id)
        );
    }

    @GetMapping
    public ResponseEntity<List<NewsResponse>> getAll(){

        return ResponseEntity.ok(
                newsService.getAll()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(
            @PathVariable Long id){

        newsService.delete(id);

        return ResponseEntity.ok("Berita berhasil dihapus");
    }

}