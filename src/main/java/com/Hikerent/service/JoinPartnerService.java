package com.Hikerent.service;

import com.Hikerent.dto.request.JoinPartnerRequest;
import com.Hikerent.dto.response.JoinPartnerResponse;

import java.util.List;

public interface JoinPartnerService {

    JoinPartnerResponse register(JoinPartnerRequest request);

    JoinPartnerResponse getById(Long id);

    List<JoinPartnerResponse> getAll();

    void approve(Long id);

    void reject(Long id);

}