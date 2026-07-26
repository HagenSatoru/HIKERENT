package com.Hikerent.service.impl;

import com.Hikerent.dto.request.UserRequest;
import com.Hikerent.dto.response.UserResponse;
import com.Hikerent.entity.User;
import com.Hikerent.repository.UserRepository;
import com.Hikerent.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public UserResponse create(UserRequest request) {
        User user = User.builder()
                .nama(request.getNama())
                .username(request.getUsername())
                .email(request.getEmail())
                .password(request.getPassword())
                .noHp(request.getNoHp())
                .alamat(request.getAlamat())
                .role(request.getRole())
                .build();

        return mapToResponse(userRepository.save(user));
    }

    @Override
    public UserResponse update(Long id, UserRequest request) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User tidak ditemukan"));

        // Update field yang dikirim dari request (jika tidak null/kosong, perbarui; jika kosong, pertahankan data lama)
        if (request.getNama() != null) {
            user.setNama(request.getNama());
        }
        if (request.getUsername() != null) {
            user.setUsername(request.getUsername());
        }
        if (request.getEmail() != null && !request.getEmail().trim().isEmpty()) {
            user.setEmail(request.getEmail());
        }
        if (request.getPassword() != null && !request.getPassword().trim().isEmpty()) {
            user.setPassword(request.getPassword());
        }
        if (request.getNoHp() != null) {
            user.setNoHp(request.getNoHp());
        }
        if (request.getAlamat() != null) {
            user.setAlamat(request.getAlamat());
        }
        if (request.getRole() != null) {
            user.setRole(request.getRole());
        }

        return mapToResponse(userRepository.save(user));
    }

    @Override
    public UserResponse getById(Long id) {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User tidak ditemukan"));

        return mapToResponse(user);
    }

    @Override
    public UserResponse getByEmail(String email) {
        User user = userRepository.findByEmail(email)
                .orElseThrow(() -> new RuntimeException("User tidak ditemukan"));

        return mapToResponse(user);
    }

    @Override
    public List<UserResponse> getAll() {
        return userRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public void delete(Long id) {
        userRepository.deleteById(id);
    }

    private UserResponse mapToResponse(User user) {
        UserResponse response = new UserResponse();

        response.setId(user.getId());
        response.setNama(user.getNama());
        response.setUsername(user.getUsername());
        response.setEmail(user.getEmail());
        response.setNoHp(user.getNoHp());
        response.setAlamat(user.getAlamat());
        response.setFoto(user.getFoto());
        response.setRole(user.getRole());
        return response;
    }
}