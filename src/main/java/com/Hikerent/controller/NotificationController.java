package com.Hikerent.controller;

import com.Hikerent.dto.response.NotificationResponse;
import com.Hikerent.service.NotificationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/notifications")
@RequiredArgsConstructor
public class NotificationController {

    private final NotificationService notificationService;

    @GetMapping("/user/{userId}")
    public ResponseEntity<List<NotificationResponse>> getByUser(
            @PathVariable Long userId){

        return ResponseEntity.ok(
                notificationService.getByUser(userId)
        );
    }

    @PutMapping("/{id}/read")
    public ResponseEntity<String> readNotification(
            @PathVariable Long id){

        notificationService.readNotification(id);

        return ResponseEntity.ok("Notifikasi telah dibaca");
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(
            @PathVariable Long id){

        notificationService.delete(id);

        return ResponseEntity.ok("Notifikasi berhasil dihapus");
    }

}