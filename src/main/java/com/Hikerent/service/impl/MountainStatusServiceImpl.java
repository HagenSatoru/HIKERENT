package com.Hikerent.service.impl;


import com.Hikerent.entity.Mountain;
import com.Hikerent.entity.MountainStatus;
import com.Hikerent.repository.MountainRepository;
import com.Hikerent.repository.MountainStatusRepository;
import com.Hikerent.service.MountainStatusService;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;


import java.util.List;



@Service
@RequiredArgsConstructor
public class MountainStatusServiceImpl implements MountainStatusService {


    private final MountainStatusRepository mountainStatusRepository;

    private final MountainRepository mountainRepository;



    @Override
    public MountainStatus create(MountainStatus status) {


        return mountainStatusRepository.save(status);

    }



    @Override
    public List<MountainStatus> getByMountain(Long mountainId) {


        Mountain mountain =
                mountainRepository.findById(mountainId)
                        .orElseThrow(() ->
                                new RuntimeException("Gunung tidak ditemukan")
                        );


        return mountainStatusRepository
                .findByMountain(mountain);

    }


}