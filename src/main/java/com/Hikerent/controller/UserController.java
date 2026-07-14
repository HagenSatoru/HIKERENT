package com.Hikerent.controller;


import com.Hikerent.dto.request.UserRequest;
import com.Hikerent.dto.response.UserResponse;
import com.Hikerent.service.UserService;

import lombok.RequiredArgsConstructor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;



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