package com.Hikerent.controller;

import com.Hikerent.dto.request.OrganizerRequest;
import com.Hikerent.dto.response.OrganizerResponse;
import com.Hikerent.service.OrganizerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/organizers")
@RequiredArgsConstructor
public class OrganizerController {

    private final OrganizerService organizerService;

    @PostMapping
    public ResponseEntity<OrganizerResponse> create(
            @RequestBody OrganizerRequest request) {

        return ResponseEntity.ok(
                organizerService.create(request)
        );
    }

    @PutMapping("/{id}")
    public ResponseEntity<OrganizerResponse> update(
            @PathVariable Long id,
            @RequestBody OrganizerRequest request) {

        return ResponseEntity.ok(
                organizerService.update(id, request)
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrganizerResponse> getById(
            @PathVariable Long id) {

        return ResponseEntity.ok(
                organizerService.getById(id)
        );
    }

    @GetMapping
    public ResponseEntity<List<OrganizerResponse>> getAll() {

        return ResponseEntity.ok(
                organizerService.getAll()
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(
            @PathVariable Long id) {

        organizerService.delete(id);

        return ResponseEntity.ok("Organizer berhasil dihapus");
    }

}