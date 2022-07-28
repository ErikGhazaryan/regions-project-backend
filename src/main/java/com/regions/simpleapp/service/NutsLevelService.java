package com.regions.simpleapp.service;

import com.regions.simpleapp.dao.NutsLevel0RegionRepository;
import com.regions.simpleapp.dao.NutsLevel1RegionRepository;
import com.regions.simpleapp.entity.MigrationTable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NutsLevelService {

    NutsLevel0RegionRepository nutsLevel0RegionRepository;

    NutsLevel1RegionRepository nutsLevel1RegionRepository;

    public NutsLevelService(NutsLevel0RegionRepository nutsLevel0RegionRepository, NutsLevel1RegionRepository nutsLevel1RegionRepository) {
        this.nutsLevel0RegionRepository = nutsLevel0RegionRepository;
        this.nutsLevel1RegionRepository = nutsLevel1RegionRepository;
    }

    public void prepareNutsLevel3Regions(List<MigrationTable> migrationTables){


    }
}
