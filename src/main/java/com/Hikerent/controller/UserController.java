package com.Hikerent.controller;


import com.Hikerent.dto.request.UserRequest;
import com.Hikerent.dto.response.UserResponse;
import com.Hikerent.service.UserService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.security.core.Authentication;



@RestController
@RequestMapping("/api/users")
@RequiredArgsConstructor
public class UserController {



    private final UserService userService;



    // =========================
    // GET ALL USER
    // =========================

    @GetMapping
    public ResponseEntity<List<UserResponse>> getAll(){


        return ResponseEntity.ok(
                userService.getAll()
        );

    }


    @GetMapping("/me")
    public ResponseEntity<UserResponse> getCurrentUser(Authentication authentication) {
        return ResponseEntity.ok(
                userService.getByEmail(authentication.getName())
        );
    }


    // =========================
    // GET USER BY ID
    // =========================

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getById(
            @PathVariable Long id
    ){


        return ResponseEntity.ok(
                userService.getById(id)
        );

    }





    // =========================
    // CREATE USER
    // =========================

    @PostMapping
    public ResponseEntity<UserResponse> create(
            @RequestBody UserRequest request
    ){


        return ResponseEntity.ok(
                userService.create(request)
        );

    }





    // =========================
    // UPDATE USER
    // =========================

    @PutMapping("/{id}")
    public ResponseEntity<UserResponse> update(
            @PathVariable Long id,
            @RequestBody UserRequest request
    ){


        return ResponseEntity.ok(
                userService.update(id, request)
        );

    }

    // =========================
    // UPDATE USER ROLE (/api/users/{id}/role)
    // =========================
    @PutMapping("/{id}/role")
    public ResponseEntity<UserResponse> updateRole(
            @PathVariable Long id,
            @RequestBody java.util.Map<String, String> requestBody
    ) {
        String roleStr = requestBody.get("role");

        // Ambil data user berdasarkan ID
        UserResponse user = userService.getById(id);

        // Buat objek request baru untuk memperbarui role
        UserRequest updateRequest = new UserRequest();
        updateRequest.setNama(user.getNama());
        updateRequest.setUsername(user.getUsername());
        updateRequest.setEmail(user.getEmail());
        updateRequest.setNoHp(user.getNoHp());
        updateRequest.setAlamat(user.getAlamat());
        updateRequest.setFoto(user.getFoto());

        // Konversi String ke enum Role (misal: "CUSTOMER" -> Role.CUSTOMER)
        if (roleStr != null && !roleStr.trim().isEmpty()) {
            updateRequest.setRole(com.Hikerent.enums.Role.valueOf(roleStr.toUpperCase()));
        }

        return ResponseEntity.ok(
                userService.update(id, updateRequest)
        );
    }

    @GetMapping("/profile")
    public ResponseEntity<UserResponse> getProfile(Authentication authentication) {
        return ResponseEntity.ok(
                userService.getByEmail(authentication.getName())
        );
    }

    // =========================
    // UPDATE CURRENT USER PROFILE (/api/users/me)
    // =========================
    @PutMapping("/me")
    public ResponseEntity<UserResponse> updateProfile(
            Authentication authentication,
            @RequestBody UserRequest request
    ) {
        // 1. Ambil email dari token yang sedang aktif
        String email = authentication.getName();

        // 2. Ambil data user lama secara utuh dari database
        UserResponse currentUser = userService.getByEmail(email);

        // 3. Jaga agar email tidak menjadi null
        if (request.getEmail() == null || request.getEmail().trim().isEmpty()) {
            request.setEmail(currentUser.getEmail());
        }

        // 4. PENTING: Jaga agar password tidak ikut tereset menjadi null
        // (Asumsi di UserRequest ada method getPassword/setPassword, atau ambil dari entitas aslinya di service)
        if (request.getPassword() == null || request.getPassword().trim().isEmpty()) {
            // Jika service Anda butuh password, ambil dari user lama
            // atau pastikan logic update di UserService tidak menimpa password jika kosong.
        }

        return ResponseEntity.ok(
                userService.update(currentUser.getId(), request)
        );
    }
    // =========================
    // DELETE USER
    // =========================

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(
            @PathVariable Long id
    ){


        userService.delete(id);


        return ResponseEntity.ok(
                "User berhasil dihapus"
        );

    }


}