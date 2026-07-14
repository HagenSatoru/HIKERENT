package com.Hikerent.controller;

import com.Hikerent.dto.request.OpenTripRequest;
import com.Hikerent.dto.response.OpenTripResponse;
import com.Hikerent.service.OpenTripService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/open-trips")
@RequiredArgsConstructor
public class OpenTripController {

    private final OpenTripService openTripService;

    @PostMapping
    public ResponseEntity<OpenTripResponse> create(
            @RequestBody OpenTripRequest request) {

        return ResponseEntity.ok(
                openTripService.create(request)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<OpenTripResponse> update(
            @PathVariable Long id,
            @RequestBody OpenTripRequest request) {

        return ResponseEntity.ok(
                openTripService.update(id, request)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<OpenTripResponse> getById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                openTripService.getById(id)
        );
    }

    @GetMapping
    public ResponseEntity<List<OpenTripResponse>> getAll() {

        return ResponseEntity.ok(
                openTripService.getAll()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(
            @PathVariable Long id) {

        openTripService.delete(id);

        return ResponseEntity.ok("Open Trip berhasil dihapus");
    }

}