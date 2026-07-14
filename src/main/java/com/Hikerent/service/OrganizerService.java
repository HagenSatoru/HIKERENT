package com.Hikerent.service;

import com.Hikerent.dto.request.OrganizerRequest;
import com.Hikerent.dto.response.OrganizerResponse;

import java.util.List;

public interface OrganizerService {

    OrganizerResponse create(OrganizerRequest request);

    OrganizerResponse update(Long id, OrganizerRequest request);

    OrganizerResponse getById(Long id);

    List<OrganizerResponse> getAll();

    void delete(Long id);

}