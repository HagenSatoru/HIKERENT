package com.Hikerent.service.impl;

import com.Hikerent.dto.request.JoinPartnerRequest;
import com.Hikerent.dto.response.JoinPartnerResponse;
import com.Hikerent.entity.JoinPartner;
import com.Hikerent.entity.User;
import com.Hikerent.enums.JoinPartnerStatus;
import com.Hikerent.repository.JoinPartnerRepository;
import com.Hikerent.repository.UserRepository;
import com.Hikerent.service.JoinPartnerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class JoinPartnerServiceImpl implements JoinPartnerService {

    private final JoinPartnerRepository joinPartnerRepository;
    private final UserRepository userRepository;

    @Override
    public JoinPartnerResponse register(JoinPartnerRequest request) {

        User user = userRepository.findById(request.getUserId())
                .orElseThrow(() ->
                        new RuntimeException("User tidak ditemukan"));

        JoinPartner partner = JoinPartner.builder()
                .user(user)
                .jenis(request.getTipePartner())
                .namaUsaha(request.getNamaUsaha())
                .alamat(request.getAlamat())
                .nomorWhatsapp(request.getNomorTelepon())
                .emailUsaha(request.getEmail())
                .deskripsi(request.getDeskripsi())
                .status(JoinPartnerStatus.MENUNGGU)
                .build();

        return mapToResponse(
                joinPartnerRepository.save(partner)
        );
    }

    @Override
    public JoinPartnerResponse getById(Long id) {

        JoinPartner partner = joinPartnerRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Data partner tidak ditemukan"));

        return mapToResponse(partner);
    }

    @Override
    public List<JoinPartnerResponse> getAll() {

        return joinPartnerRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();
    }

    @Override
    public void approve(Long id) {

        JoinPartner partner = joinPartnerRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Data partner tidak ditemukan"));

        partner.setStatus(JoinPartnerStatus.DITERIMA);

        joinPartnerRepository.save(partner);
    }

    @Override
    public void reject(Long id) {

        JoinPartner partner = joinPartnerRepository.findById(id)
                .orElseThrow(() ->
                        new RuntimeException("Data partner tidak ditemukan"));

        partner.setStatus(JoinPartnerStatus.DITOLAK);

        joinPartnerRepository.save(partner);
    }

    private JoinPartnerResponse mapToResponse(JoinPartner partner) {

        JoinPartnerResponse response = new JoinPartnerResponse();

        response.setId(partner.getId());

        if (partner.getUser() != null) {
            response.setUserId(partner.getUser().getId());
        }

        response.setTipePartner(partner.getJenis());
        response.setNamaUsaha(partner.getNamaUsaha());
        response.setAlamat(partner.getAlamat());
        response.setNomorTelepon(partner.getNomorWhatsapp());
        response.setEmail(partner.getEmailUsaha());
        response.setDeskripsi(partner.getDeskripsi());
        response.setStatus(JoinPartnerStatus.valueOf(String.valueOf(partner.getStatus())));

        return response;
    }
}