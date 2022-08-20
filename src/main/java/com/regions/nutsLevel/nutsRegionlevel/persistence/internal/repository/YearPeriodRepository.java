package com.regions.nutsLevel.nutsRegionlevel.persistence.internal.repository;

import com.regions.nutsLevel.nutsRegionlevel.persistence.internal.entity.PopulationDensity;
import com.regions.nutsLevel.nutsRegionlevel.persistence.internal.entity.YearPeriod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.time.Year;
import java.util.Optional;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "yearperiod", path="yearperiod")
public interface YearPeriodRepository extends JpaRepository<YearPeriod, Long> {
        Optional<YearPeriod> findByCalendarYear(int year);
}
