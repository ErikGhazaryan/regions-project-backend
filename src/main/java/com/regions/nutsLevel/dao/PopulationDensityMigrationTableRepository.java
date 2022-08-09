package com.regions.nutsLevel.dao;

import com.regions.nutsLevel.nutsRegionlevel.persistence.internal.entity.PopulationDensityMigrationTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "populationdensitymigrationtable", path="populationdensitymigrationtable")
public interface PopulationDensityMigrationTableRepository extends JpaRepository <PopulationDensityMigrationTable, Long> {

}
