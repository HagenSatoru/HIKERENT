package com.Hikerent.service.impl;


import com.Hikerent.dto.request.OrganizerRequest;
import com.Hikerent.dto.response.OrganizerResponse;
import com.Hikerent.entity.Organizer;
import com.Hikerent.repository.OrganizerRepository;
import com.Hikerent.service.OrganizerService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
@RequiredArgsConstructor
public class OrganizerServiceImpl implements OrganizerService {


    private final OrganizerRepository organizerRepository;



    @Override
    public OrganizerResponse create(OrganizerRequest request){


        Organizer organizer =
                Organizer.builder()
                        .namaOrganizer(
                                request.getNamaOrganizer()
                        )
                        .deskripsi(
                                request.getDeskripsi()
                        )
                        .build();


        return mapToResponse(
                organizerRepository.save(organizer)
        );

    }



    @Override
    public OrganizerResponse getById(Long id){

        Organizer organizer =
                organizerRepository.findById(id)
                        .orElseThrow();


        return mapToResponse(organizer);

    }



    @Override
    public List<OrganizerResponse> getAll(){

        return organizerRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();

    }



    @Override
    public void delete(Long id){

        organizerRepository.deleteById(id);

    }



    @Override
    public OrganizerResponse update(Long id, OrganizerRequest request){

        Organizer organizer =
                organizerRepository.findById(id)
                        .orElseThrow();


        organizer.setNamaOrganizer(
                request.getNamaOrganizer()
        );


        return mapToResponse(
                organizerRepository.save(organizer)
        );

    }




    private OrganizerResponse mapToResponse(
            Organizer organizer
    ){

        OrganizerResponse response =
                new OrganizerResponse();

        response.setId(
                organizer.getId()
        );

        response.setNamaOrganizer(
                organizer.getNamaOrganizer()
        );


        return response;

    }

}