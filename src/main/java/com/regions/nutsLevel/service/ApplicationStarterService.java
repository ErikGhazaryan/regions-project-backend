package com.regions.nutsLevel.service;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
@AllArgsConstructor
@Profile("create")
public class ApplicationStarterService {

    NutsLevelRegionMigrationTableService nutsLevelRegionMigrationTableService;
    PopulationDensityMigrationTableService populationDensityMigrationTableService;

    @PostConstruct
    public void createAllEntitiesAndRunApplication() {
        prepareNetsLevelRegionMigrationTable();
        preparePopulationDensityMigrationTable();
        nutsLevelRegionMigrationTableService.deleteAllNutsLevelRegionEntities();
        nutsLevelRegionMigrationTableService.prepareAllNutsLevelRegionEntities();
        populationDensityMigrationTableService.preparePopulationDensity();
    }

    private void prepareNetsLevelRegionMigrationTable() {
        String userDirectory = System.getProperty("user.dir");
        try (BufferedReader br = new BufferedReader(new FileReader(userDirectory+"\\regions-project-backend\\src\\main\\resources\\migration_database_tables\\net_level_region_migration_data.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                List<String> values = Arrays.stream(line.split(",")).collect(Collectors.toList());
                nutsLevelRegionMigrationTableService.prepareNutsLevelRegionMigrationTable(values);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void preparePopulationDensityMigrationTable() {
        String userDirectory = System.getProperty("user.dir");
        try (BufferedReader br = new BufferedReader(new FileReader(userDirectory+"\\regions-project-backend\\src\\main\\resources\\migration_database_tables\\population_density_migration_data.csv"))) {
            String line;
            while ((line = br.readLine()) != null) {
                List<String> values = Arrays.stream(line.split(",")).collect(Collectors.toList());
                populationDensityMigrationTableService.preparePopulationDensityMigrationTable(values);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
