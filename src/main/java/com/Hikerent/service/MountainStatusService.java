package com.Hikerent.service;

import com.Hikerent.entity.MountainStatus;

import java.util.List;

public interface MountainStatusService {

    MountainStatus create(MountainStatus status);

    List<MountainStatus> getByMountain(Long mountainId);

}