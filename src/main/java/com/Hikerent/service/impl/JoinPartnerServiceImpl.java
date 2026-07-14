package com.Hikerent.service.impl;


import com.Hikerent.dto.request.JoinPartnerRequest;
import com.Hikerent.dto.response.JoinPartnerResponse;
import com.Hikerent.entity.JoinPartner;
import com.Hikerent.repository.JoinPartnerRepository;
import com.Hikerent.service.JoinPartnerService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class JoinPartnerServiceImpl implements JoinPartnerService {


    private final JoinPartnerRepository joinPartnerRepository;



    @Override
    public JoinPartnerResponse create(JoinPartnerRequest request) {


        JoinPartner partner = JoinPartner.builder()

                .nama(
                        request.getNama()
                )

                .email(
                        request.getEmail()
                )

                .nomorTelepon(
                        request.getNomorTelepon()
                )

                .jenisPartner(
                        request.getJenisPartner()
                )

                .pesan(
                        request.getPesan()
                )

                .build();



        return mapToResponse(
                joinPartnerRepository.save(partner)
        );

    }





    @Override
    public List<JoinPartnerResponse> getAll() {


        return joinPartnerRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();

    }





    @Override
    public JoinPartnerResponse getById(Long id) {


        JoinPartner partner =
                joinPartnerRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException(
                                        "Data partner tidak ditemukan"
                                )
                        );


        return mapToResponse(partner);

    }





    @Override
    public void delete(Long id) {

        joinPartnerRepository.deleteById(id);

    }





    private JoinPartnerResponse mapToResponse(
            JoinPartner partner
    ){

        JoinPartnerResponse response =
                new JoinPartnerResponse();


        response.setId(
                partner.getId()
        );


        response.setNama(
                partner.getNama()
        );


        response.setEmail(
                partner.getEmail()
        );


        response.setJenisPartner(
                partner.getJenisPartner()
        );


        return response;

    }

}