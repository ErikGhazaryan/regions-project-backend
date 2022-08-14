package com.regions.nutsLevel.service;

import com.regions.nutsLevel.dao.NutsLevel3RegionRepository;
import com.regions.nutsLevel.dao.PopulationDensityMigrationTableRepository;
import com.regions.nutsLevel.dao.PopulationDensityRepository;
import com.regions.nutsLevel.dao.YearPeriodRepository;
import com.regions.nutsLevel.nutsRegionlevel.persistence.internal.entity.NutsLevel3Region;
import com.regions.nutsLevel.nutsRegionlevel.persistence.internal.entity.PopulationDensity;
import com.regions.nutsLevel.nutsRegionlevel.persistence.internal.entity.PopulationDensityMigrationTable;
import com.regions.nutsLevel.nutsRegionlevel.persistence.internal.entity.YearPeriod;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Slf4j
@Service
@AllArgsConstructor
public class PopulationDensityMigrationTableService {

    PopulationDensityMigrationTableRepository populationDensityMigrationTableRepository;

    YearPeriodRepository yearPeriodRepository;

    PopulationDensityRepository populationDensityRepository;

    NutsLevel3RegionRepository nutsLevel3RegionRepository;


    public void preparePopulationDensity() {

        createYearPeriods();
        log.info("deleting populationDensity entities");
        populationDensityRepository.deleteAll();

        Set<PopulationDensityMigrationTable> refinedList = populationDensityMigrationTableRepository.findAll().stream().filter(pd -> pd.getTerritoryCode().length()==5).collect(Collectors.toSet());
        Set<NutsLevel3Region> nutsLevel3RegionSet = nutsLevel3RegionRepository.findAll().stream().collect(Collectors.toSet());
        Set<String> nutsLevel3RegionAsString = nutsLevel3RegionSet.stream().map(extracted -> extracted.getTerritoryCode()).collect(Collectors.toSet());

        for(PopulationDensityMigrationTable populationDensityMigrationTable : refinedList) {
            Set<Integer> yearPeriodsSet = yearPeriodRepository.findAll().stream().map(yearPeriod -> yearPeriod.getCalendarYear()).collect(Collectors.toSet());
            yearPeriodsSet.forEach(calendarYearInteger -> createPopulationDensity(populationDensityMigrationTable,nutsLevel3RegionAsString, calendarYearInteger));
        }

    }

    private void createPopulationDensity(PopulationDensityMigrationTable populationDensityMigrationTable, Set<String> nutsLevel3RegionAsString, int calendarYear) {
        if(nutsLevel3RegionAsString.contains(populationDensityMigrationTable.getTerritoryCode())) {
            System.out.println("creating populationDensity");
            PopulationDensity populationDensity = PopulationDensity.builder()
                    .yearPeriod(yearPeriodRepository.findByCalendarYear(calendarYear).get())
                    .populationDensityPsk(getTheRightYear(populationDensityMigrationTable, calendarYear))
                    .nutsLevel3Region(nutsLevel3RegionRepository.findByTerritoryCode(populationDensityMigrationTable.getTerritoryCode()).get()).build();

            populationDensityRepository.save(populationDensity);
        } else {
            log.info(String.format("The territory code %s does not exist in nutsLevel3Regions",populationDensityMigrationTable.getTerritoryCode()));
        }
    }

    private String getTheRightYear(PopulationDensityMigrationTable populationDensityMigrationTable, int calendarYear) {
        switch (calendarYear) {
            case 2015:
                return populationDensityMigrationTable.getYear2015();
            case 2016:
                return populationDensityMigrationTable.getYear2016();
            case 2017:
                return populationDensityMigrationTable.getYear2017();
            case 2018:
                return populationDensityMigrationTable.getYear2018();
            case 2019:
                return populationDensityMigrationTable.getYear2019();
            default :
                throw new RuntimeException("there shouldn't be default option in getTerritory code function");
        }
    }
    private void createYearPeriods() {
        log.info("deleting year Periods");
        yearPeriodRepository.deleteAll();

        log.info("deleting year Population Density entities");
        populationDensityRepository.deleteAll();
        log.info("creating the year periods");


        List<Integer> actualYears = List.of(2015,2016,2017,2018,2019);
        actualYears.forEach(actualYear -> createYearPeriod(actualYear));
    }

        private void createYearPeriod(int calendarYear){
            yearPeriodRepository.save(YearPeriod.builder().calendarYear(calendarYear).build());
        }


    public void preparePopulationDensityMigrationTable(List<String> listOfValues) {
        PopulationDensityMigrationTable populationDensityMigrationTable =
                PopulationDensityMigrationTable.builder()
                        .territoryCode(listOfValues.get(0))
                        .nutsLevelName(listOfValues.get(1))
                        .year2015(listOfValues.get(2))
                        .year2016(listOfValues.get(3))
                        .year2017(listOfValues.get(4))
                        .year2018(listOfValues.get(5))
                        .year2019(listOfValues.get(6)).build();
        populationDensityMigrationTableRepository.save(populationDensityMigrationTable);
    }
}

