package com.regions.nutsLevel.service;

import com.regions.nutsLevel.dao.*;
import com.regions.nutsLevel.nutsRegionlevel.persistence.internal.entity.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class NutsLevelRegionMigrationTableService {

    NutsLevel0RegionRepository nutsLevel0RegionRepository;
    NutsLevel1RegionRepository nutsLevel1RegionRepository;
    NutsLevel2RegionRepository nutsLevel2RegionRepository;
    NutsLevel3RegionRepository nutsLevel3RegionRepository;
    NutsLevelRegionMigrationTableRepository nutsLevelRegionMigrationTableRepository;

    public List<NutsLevelRegionMigrationTable> getMigrationTables() {
    return this.nutsLevelRegionMigrationTableRepository.findAll();
    };



    public List<NutsLevelRegionMigrationTable> prepareRegionByNutsLevel(Integer nutsLevel) {
        return this.nutsLevelRegionMigrationTableRepository.findByNutsLevel(nutsLevel);
    }

    public void prepareNutsLevelRegionMigrationTable(List<String> listOfValues){

        NutsLevelRegionMigrationTable nutsLevelRegionMigrationTable =
                NutsLevelRegionMigrationTable.builder()
                        .territoryCode(listOfValues.get(0))
                        .nutsLevel(Integer.valueOf(listOfValues.get(1)))
                        .countryOrder(Integer.valueOf(listOfValues.get(2)))
                        .regionOrder(Integer.valueOf(listOfValues.get(3))).build();

        nutsLevelRegionMigrationTableRepository.save(nutsLevelRegionMigrationTable);
    }

    public void deleteAllNutsLevelRegionEntities() {
        log.info("deleting nutsLevel0Region entities");
        nutsLevel0RegionRepository.deleteAll();

        log.info("deleting nutsLevel1Region entities");
        nutsLevel1RegionRepository.deleteAll();

        log.info("deleting nutsLevel2Region entities");
        nutsLevel2RegionRepository.deleteAll();

        log.info("deleting nutsLevel3Region entities");
        nutsLevel3RegionRepository.deleteAll();
    }

    public void prepareAllNutsLevelRegionEntities() {
        log.info("creating nutsLevel0Region");
        List<NutsLevelRegionMigrationTable> nutsLevel0RegionsMigrationTable = prepareRegionByNutsLevel(0);
        nutsLevel0RegionsMigrationTable.forEach(migrationTable -> nutsLevel0RegionRepository.save(NutsLevel0Region.builder().territoryCode(migrationTable.getTerritoryCode()).build()));

        log.info("creating nutsLevel1Region");
        List<NutsLevelRegionMigrationTable> nutsLevel1RegionsMigrationTable = prepareRegionByNutsLevel(1);
        List<NutsLevel0Region> nutsLevel0RegionList = nutsLevel0RegionRepository.findAll();
        nutsLevel1RegionsMigrationTable.forEach(migrationTable1 -> nutsLevel1RegionRepository.save(NutsLevel1Region.builder()
                .territoryCode(migrationTable1.getTerritoryCode())
                .nutsLevel0Region(nutsLevel0RegionList.stream().filter(extractedNutsLevel0Region -> extractedNutsLevel0Region.getTerritoryCode()
                                .equals(migrationTable1.getTerritoryCode().substring(0,2))).findFirst()
                        .get()).build()));


        List<NutsLevelRegionMigrationTable> nutsLevel2RegionsMigrationTable = prepareRegionByNutsLevel(2);
        List<NutsLevel1Region> nutsLevel1RegionList = nutsLevel1RegionRepository.findAll();

        log.info("creating nutsLevel2Region");
        nutsLevel2RegionsMigrationTable.forEach(migrationTable2 -> nutsLevel2RegionRepository.save(NutsLevel2Region.builder()
                .territoryCode(migrationTable2.getTerritoryCode())
                .nutsLevel1Region(nutsLevel1RegionList.stream().filter(extractedNutsLevel1Region -> extractedNutsLevel1Region.getTerritoryCode()
                                .equals(migrationTable2.getTerritoryCode().substring(0,3))).findFirst()
                        .get()).build()));
        log.info("finished with nutsLevel2Region");


        List<NutsLevelRegionMigrationTable> nutsLevel3Regions = prepareRegionByNutsLevel(3);
        List<NutsLevel2Region> nutsLevel2RegionList = nutsLevel2RegionRepository.findAll();

        log.info("creating nutsLevel3Region");
        nutsLevel3Regions.forEach(migrationTable3 -> nutsLevel3RegionRepository.save(
                NutsLevel3Region.builder().territoryCode(migrationTable3.getTerritoryCode()).nutsLevel2Region(nutsLevel2RegionList.stream().filter(extractedNutsLevel2Region -> extractedNutsLevel2Region.getTerritoryCode().equals(migrationTable3.getTerritoryCode().substring(0,4))).findFirst()
                        .get()).build()));
        log.info("finished with nutsLevel3Region");
    }
}
