package com.Hikerent.service;

import com.Hikerent.dto.request.MountainRequest;
import com.Hikerent.dto.response.MountainResponse;

import java.util.List;

public interface MountainService {

    MountainResponse create(MountainRequest request);

    MountainResponse update(Long id, MountainRequest request);

    MountainResponse getById(Long id);

    List<MountainResponse> getAll();

    void delete(Long id);

}