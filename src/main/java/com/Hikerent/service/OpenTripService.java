package com.Hikerent.service;

import com.Hikerent.dto.request.OpenTripRequest;
import com.Hikerent.dto.response.OpenTripResponse;

import java.util.List;

public interface OpenTripService {

    OpenTripResponse create(OpenTripRequest request);

    OpenTripResponse update(Long id, OpenTripRequest request);

    OpenTripResponse getById(Long id);

    List<OpenTripResponse> getAll();

    void delete(Long id);

}