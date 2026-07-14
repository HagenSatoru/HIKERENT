package com.Hikerent.service.impl;


import com.Hikerent.dto.request.OpenTripRequest;
import com.Hikerent.dto.response.OpenTripResponse;
import com.Hikerent.entity.Mountain;
import com.Hikerent.entity.OpenTrip;
import com.Hikerent.entity.Organizer;
import com.Hikerent.repository.MountainRepository;
import com.Hikerent.repository.OpenTripRepository;
import com.Hikerent.repository.OrganizerRepository;
import com.Hikerent.service.OpenTripService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;



@Service
@RequiredArgsConstructor
public class OpenTripServiceImpl implements OpenTripService {



    private final OpenTripRepository openTripRepository;

    private final OrganizerRepository organizerRepository;

    private final MountainRepository mountainRepository;




    @Override
    public OpenTripResponse create(OpenTripRequest request) {


        Organizer organizer =
                organizerRepository.findById(request.getOrganizerId())
                        .orElseThrow(() ->
                                new RuntimeException("Organizer tidak ditemukan")
                        );


        Mountain mountain =
                mountainRepository.findById(request.getMountainId())
                        .orElseThrow(() ->
                                new RuntimeException("Gunung tidak ditemukan")
                        );



        OpenTrip trip = OpenTrip.builder()
                .namaTrip(request.getNamaTrip())
                .deskripsi(request.getDeskripsi())
                .harga(request.getHarga())
                .kuota(request.getKuota())
                .tanggalBerangkat(request.getTanggalBerangkat())
                .tanggalPulang(request.getTanggalPulang())
                .meetingPoint(request.getMeetingPoint())
                .gambar(request.getGambar())
                .organizer(organizer)
                .mountain(mountain)
                .build();



        return mapToResponse(
                openTripRepository.save(trip)
        );

    }





    @Override
    public OpenTripResponse update(Long id, OpenTripRequest request) {


        OpenTrip trip =
                openTripRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Open Trip tidak ditemukan")
                        );


        trip.setNamaTrip(request.getNamaTrip());
        trip.setDeskripsi(request.getDeskripsi());
        trip.setHarga(request.getHarga());
        trip.setKuota(request.getKuota());
        trip.setTanggalBerangkat(request.getTanggalBerangkat());
        trip.setTanggalPulang(request.getTanggalPulang());
        trip.setMeetingPoint(request.getMeetingPoint());
        trip.setGambar(request.getGambar());


        return mapToResponse(
                openTripRepository.save(trip)
        );

    }




    @Override
    public OpenTripResponse getById(Long id) {


        OpenTrip trip =
                openTripRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Open Trip tidak ditemukan")
                        );


        return mapToResponse(trip);

    }





    @Override
    public List<OpenTripResponse> getAll() {


        return openTripRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();

    }





    @Override
    public void delete(Long id) {

        openTripRepository.deleteById(id);

    }






    private OpenTripResponse mapToResponse(OpenTrip trip){

        OpenTripResponse response =
                new OpenTripResponse();


        response.setId(trip.getId());
        response.setNamaTrip(trip.getNamaTrip());
        response.setDeskripsi(trip.getDeskripsi());
        response.setHarga(trip.getHarga());
        response.setKuota(trip.getKuota());
        response.setTanggalBerangkat(trip.getTanggalBerangkat());
        response.setTanggalPulang(trip.getTanggalPulang());
        response.setMeetingPoint(trip.getMeetingPoint());
        response.setGambar(trip.getGambar());


        return response;

    }


}