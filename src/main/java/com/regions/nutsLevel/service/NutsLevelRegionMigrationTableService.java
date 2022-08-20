package com.regions.nutsLevel.service;

import com.regions.nutsLevel.migration.persistence.dao.NutsLevelRegionMigrationTableDao;
import com.regions.nutsLevel.migration.persistence.internal.entity.NutsLevelRegionMigrationTable;
import com.regions.nutsLevel.migration.persistence.internal.repository.NutsLevelRegionMigrationTableRepository;
import com.regions.nutsLevel.nutsRegionlevel.persistence.dao.NutsLevel0RegionDao;
import com.regions.nutsLevel.nutsRegionlevel.persistence.dao.NutsLevel1RegionDao;
import com.regions.nutsLevel.nutsRegionlevel.persistence.dao.NutsLevel2RegionDao;
import com.regions.nutsLevel.nutsRegionlevel.persistence.dao.NutsLevel3RegionDao;
import com.regions.nutsLevel.nutsRegionlevel.persistence.internal.entity.*;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
@Slf4j
public class NutsLevelRegionMigrationTableService {

    NutsLevel0RegionDao nutsLevel0RegionDao;
    NutsLevel1RegionDao nutsLevel1RegionDao;
    NutsLevel2RegionDao nutsLevel2RegionDao;
    NutsLevel3RegionDao nutsLevel3RegionDao;
    NutsLevelRegionMigrationTableDao nutsLevelRegionMIgrationTableDao;



    public List<NutsLevelRegionMigrationTable> getMigrationTables() {
    return this.nutsLevelRegionMIgrationTableDao.findAll();
    };



    public List<NutsLevelRegionMigrationTable> prepareRegionByNutsLevel(Integer nutsLevel) {
        return this.nutsLevelRegionMIgrationTableDao.findByNutsLevel(nutsLevel);
    }

    public void prepareNutsLevelRegionMigrationTable(List<String> listOfValues){

        NutsLevelRegionMigrationTable nutsLevelRegionMigrationTable =
                NutsLevelRegionMigrationTable.builder()
                        .territoryCode(listOfValues.get(0))
                        .nutsLevel(Integer.valueOf(listOfValues.get(1)))
                        .countryOrder(Integer.valueOf(listOfValues.get(2)))
                        .regionOrder(Integer.valueOf(listOfValues.get(3))).build();

        nutsLevelRegionMIgrationTableDao.save(nutsLevelRegionMigrationTable);
    }

    public void deleteAllNutsLevelRegionEntities() {
        log.info("deleting nutsLevel0Region entities");
        nutsLevel0RegionDao.deleteAll();

        log.info("deleting nutsLevel1Region entities");
        nutsLevel1RegionDao.deleteAll();

        log.info("deleting nutsLevel2Region entities");
        nutsLevel2RegionDao.deleteAll();

        log.info("deleting nutsLevel3Region entities");
        nutsLevel3RegionDao.deleteAll();
    }

    public void prepareAllNutsLevelRegionEntities() {
        log.info("creating nutsLevel0Region");
        List<NutsLevelRegionMigrationTable> nutsLevel0RegionsMigrationTable = prepareRegionByNutsLevel(0);
        nutsLevel0RegionsMigrationTable.forEach(migrationTable -> nutsLevel0RegionDao.save(NutsLevel0Region.builder().territoryCode(migrationTable.getTerritoryCode()).build()));

        log.info("creating nutsLevel1Region");
        List<NutsLevelRegionMigrationTable> nutsLevel1RegionsMigrationTable = prepareRegionByNutsLevel(1);
        List<NutsLevel0Region> nutsLevel0RegionList = nutsLevel0RegionDao.findAll();
        nutsLevel1RegionsMigrationTable.forEach(migrationTable1 -> nutsLevel1RegionDao.save(NutsLevel1Region.builder()
                .territoryCode(migrationTable1.getTerritoryCode())
                .nutsLevel0Region(nutsLevel0RegionList.stream().filter(extractedNutsLevel0Region -> extractedNutsLevel0Region.getTerritoryCode()
                                .equals(migrationTable1.getTerritoryCode().substring(0,2))).findFirst()
                        .get()).build()));


        List<NutsLevelRegionMigrationTable> nutsLevel2RegionsMigrationTable = prepareRegionByNutsLevel(2);
        List<NutsLevel1Region> nutsLevel1RegionList = nutsLevel1RegionDao.findAll();

        log.info("creating nutsLevel2Region");
        nutsLevel2RegionsMigrationTable.forEach(migrationTable2 -> nutsLevel2RegionDao.save(NutsLevel2Region.builder()
                .territoryCode(migrationTable2.getTerritoryCode())
                .nutsLevel1Region(nutsLevel1RegionList.stream().filter(extractedNutsLevel1Region -> extractedNutsLevel1Region.getTerritoryCode()
                                .equals(migrationTable2.getTerritoryCode().substring(0,3))).findFirst()
                        .get()).build()));
        log.info("finished with nutsLevel2Region");


        List<NutsLevelRegionMigrationTable> nutsLevel3Regions = prepareRegionByNutsLevel(3);
        List<NutsLevel2Region> nutsLevel2RegionList = nutsLevel2RegionDao.findAll();

        log.info("creating nutsLevel3Region");
        nutsLevel3Regions.forEach(migrationTable3 -> nutsLevel3RegionDao.save(
                NutsLevel3Region.builder().territoryCode(migrationTable3.getTerritoryCode()).nutsLevel2Region(nutsLevel2RegionList.stream().filter(extractedNutsLevel2Region -> extractedNutsLevel2Region.getTerritoryCode().equals(migrationTable3.getTerritoryCode().substring(0,4))).findFirst()
                        .get()).build()));
        log.info("finished with nutsLevel3Region");
    }
}
