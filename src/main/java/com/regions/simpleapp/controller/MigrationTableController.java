package com.regions.simpleapp.controller;

import com.regions.simpleapp.dao.NutsLevel0RegionRepository;
import com.regions.simpleapp.dao.NutsLevel1RegionRepository;
import com.regions.simpleapp.dao.NutsLevel2RegionRepository;
import com.regions.simpleapp.dao.NutsLevel3RegionRepository;
import com.regions.simpleapp.entity.*;
import com.regions.simpleapp.service.MigrationTableService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class MigrationTableController {


    NutsLevel0RegionRepository nutsLevel0RegionRepository;
    NutsLevel1RegionRepository nutsLevel1RegionRepository;
    NutsLevel2RegionRepository nutsLevel2RegionRepository;
    NutsLevel3RegionRepository nutsLevel3RegionRepository;

    MigrationTableService migrationTableService;


    @GetMapping("/api/preparenutslevelregions2")
    public void prepareRegionByNutsLevel2() {

        nutsLevel0RegionRepository.deleteAll();
        nutsLevel1RegionRepository.deleteAll();
        nutsLevel2RegionRepository.deleteAll();
        nutsLevel3RegionRepository.deleteAll();
        List<MigrationTable> nutsLevel0Regions = migrationTableService.prepareRegionByNutsLevel(0);
        nutsLevel0Regions.forEach(migrationTable -> nutsLevel0RegionRepository.save(new NutsLevel0Region().withTerritoryCode(migrationTable.getTerritoryCode())));

        List<MigrationTable> nutsLevel1Regions = migrationTableService.prepareRegionByNutsLevel(1);
        nutsLevel1Regions.forEach(migrationTable1 -> nutsLevel1RegionRepository.save(new NutsLevel1Region().withTerritoryCode(migrationTable1.getTerritoryCode()).withNutsLevel0Region(nutsLevel0RegionRepository.findByTerritoryCode(migrationTable1.getTerritoryCode().substring(0,2)))));

        List<MigrationTable> nutsLevel2Regions = migrationTableService.prepareRegionByNutsLevel(2);
        nutsLevel2Regions.forEach(migrationTable2 -> nutsLevel2RegionRepository.save(new NutsLevel2Region().withTerritoryCode(migrationTable2.getTerritoryCode()).withNutsLevel1Region(nutsLevel1RegionRepository.findByTerritoryCode(migrationTable2.getTerritoryCode().substring(0,3)))));

        List<MigrationTable> nutsLevel3Regions = migrationTableService.prepareRegionByNutsLevel(3);
        nutsLevel3Regions.forEach(migrationTable3 -> nutsLevel3RegionRepository.save(new NutsLevel3Region().withTerritoryCode(migrationTable3.getTerritoryCode()).withNutsLevel2Region(nutsLevel2RegionRepository.findByTerritoryCode(migrationTable3.getTerritoryCode().substring(0,4)))));
    };


    public MigrationTableController(NutsLevel0RegionRepository nutsLevel0RegionRepository,
                                    NutsLevel1RegionRepository nutsLevel1RegionRepository,
                                    NutsLevel2RegionRepository nutsLevel2RegionRepository,
                                    NutsLevel3RegionRepository nutsLevel3RegionRepository,
                                    MigrationTableService migrationTableService) {
        this.nutsLevel0RegionRepository = nutsLevel0RegionRepository;
        this.nutsLevel1RegionRepository = nutsLevel1RegionRepository;
        this.nutsLevel2RegionRepository = nutsLevel2RegionRepository;
        this.nutsLevel3RegionRepository = nutsLevel3RegionRepository;
        this.migrationTableService = migrationTableService;
    }
}

