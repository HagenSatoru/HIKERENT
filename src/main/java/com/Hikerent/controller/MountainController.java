package com.Hikerent.controller;

import com.Hikerent.dto.request.MountainRequest;
import com.Hikerent.dto.response.MountainResponse;
import com.Hikerent.service.MountainService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mountains")
@RequiredArgsConstructor
public class MountainController {

    private final MountainService mountainService;

    @PostMapping
    public ResponseEntity<MountainResponse> create(
            @RequestBody MountainRequest request) {

        return ResponseEntity.ok(
                mountainService.create(request)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<MountainResponse> update(
            @PathVariable Long id,
            @RequestBody MountainRequest request) {

        return ResponseEntity.ok(
                mountainService.update(id, request)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<MountainResponse> getById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                mountainService.getById(id)
        );
    }

    @GetMapping
    public ResponseEntity<List<MountainResponse>> getAll() {

        return ResponseEntity.ok(
                mountainService.getAll()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(
            @PathVariable Long id) {

        mountainService.delete(id);

        return ResponseEntity.ok("Gunung berhasil dihapus");
    }

}