package com.Hikerent.service.impl;


import com.Hikerent.dto.request.SellerRequest;
import com.Hikerent.dto.response.SellerResponse;
import com.Hikerent.entity.Seller;
import com.Hikerent.repository.SellerRepository;
import com.Hikerent.service.SellerService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;



@Service
@RequiredArgsConstructor
public class SellerServiceImpl implements SellerService {


    private final SellerRepository sellerRepository;



    @Override
    public SellerResponse create(SellerRequest request) {


        Seller seller = Seller.builder()

                .namaToko(
                        request.getNamaToko()
                )

                .alamat(
                        request.getAlamatToko()
                )

                .nomorTelepon(
                        request.getNomorTelepon()
                )

                .build();


        return mapToResponse(
                sellerRepository.save(seller)
        );

    }





    @Override
    public SellerResponse getById(Long id) {


        Seller seller =
                sellerRepository.findById(id)
                        .orElseThrow(() ->
                                new RuntimeException("Seller tidak ditemukan")
                        );


        return mapToResponse(seller);

    }





    @Override
    public List<SellerResponse> getAll() {


        return sellerRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .toList();

    }





    @Override
    public void delete(Long id) {

        sellerRepository.deleteById(id);

    }





    @Override
    public SellerResponse update(Long id, SellerRequest request) {


        Seller seller =
                sellerRepository.findById(id)
                        .orElseThrow();


        seller.setNamaToko(
                request.getNamaToko()
        );


        return mapToResponse(
                sellerRepository.save(seller)
        );

    }





    private SellerResponse mapToResponse(Seller seller){


        SellerResponse response =
                new SellerResponse();


        response.setId(seller.getId());

        response.setNamaToko(
                seller.getNamaToko()
        );


        return response;

    }


}