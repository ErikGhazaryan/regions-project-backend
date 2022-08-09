package com.regions.nutsLevel.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
@Slf4j
@AllArgsConstructor
public class ApplicationStarterService {

    NutsLevelRegionMigrationTableService nutsLevelRegionMigrationTableService;
    PopulationDensityMigrationTableService populationDensityMigrationTableService;

    @PostConstruct
    public void createAllEntitiesAndRunApplication() {
        nutsLevelRegionMigrationTableService.deleteAllNutsLevelRegionEntities();
        nutsLevelRegionMigrationTableService.prepareAllNutsLevelRegionEntities();
        populationDensityMigrationTableService.preparePopulationDensity();
    }
}
