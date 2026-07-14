package com.Hikerent.controller;

import com.Hikerent.entity.MountainStatus;
import com.Hikerent.service.MountainStatusService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/mountain-status")
@RequiredArgsConstructor
public class MountainStatusController {

    private final MountainStatusService mountainStatusService;

    @PostMapping
    public ResponseEntity<MountainStatus> create(
            @RequestBody MountainStatus status) {

        return ResponseEntity.ok(
                mountainStatusService.create(status)
        );
    }

    @GetMapping("/{mountainId}")
    public ResponseEntity<List<MountainStatus>> getByMountain(
            @PathVariable Long mountainId) {

        return ResponseEntity.ok(
                mountainStatusService.getByMountain(mountainId)
        );
    }

}