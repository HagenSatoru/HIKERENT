package com.Hikerent.service.impl;

import com.Hikerent.dto.request.MountainRequest;
import com.Hikerent.dto.response.MountainResponse;
import com.Hikerent.entity.Mountain;
import com.Hikerent.repository.MountainRepository;
import com.Hikerent.service.MountainService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@RequiredArgsConstructor
public class MountainServiceImpl implements MountainService {


    private final MountainRepository mountainRepository;


    @Override
    public MountainResponse create(MountainRequest request) {


        Mountain mountain = Mountain.builder()
                .namaGunung(request.getNamaGunung())
                .provinsi(request.getProvinsi())
                .kabupaten(request.getKabupaten())
                .ketinggian(request.getKetinggian())
                .deskripsi(request.getDeskripsi())
                .gambar(request.getGambar())
                .build();


        return mapToResponse(
                mountainRepository.save(mountain)
        );

    }



    @Override
    public MountainResponse update(Long id, MountainRequest request) {


        Mountain mountain =
                mountainRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Gunung tidak ditemukan")
                        );


        mountain.setNamaGunung(request.getNamaGunung());
        mountain.setProvinsi(request.getProvinsi());
        mountain.setKabupaten(request.getKabupaten());
        mountain.setKetinggian(request.getKetinggian());
        mountain.setDeskripsi(request.getDeskripsi());
        mountain.setGambar(request.getGambar());


        return mapToResponse(
                mountainRepository.save(mountain)
        );

    }



    @Override
    public MountainResponse getById(Long id) {


        Mountain mountain =
                mountainRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Gunung tidak ditemukan")
                        );


        return mapToResponse(mountain);

    }



    @Override
    public List<MountainResponse> getAll() {


        return mountainRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();

    }



    @Override
    public void delete(Long id) {

        mountainRepository.deleteById(id);

    }



    private MountainResponse mapToResponse(Mountain mountain){


        MountainResponse response =
                new MountainResponse();


        response.setId(mountain.getId());
        response.setNamaGunung(mountain.getNamaGunung());
        response.setProvinsi(mountain.getProvinsi());
        response.setKabupaten(mountain.getKabupaten());
        response.setKetinggian(mountain.getKetinggian());
        response.setDeskripsi(mountain.getDeskripsi());
        response.setGambar(mountain.getGambar());


        return response;

    }

}