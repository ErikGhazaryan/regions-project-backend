package com.regions.nutsLevel.dao;

import com.regions.nutsLevel.nutsRegionlevel.persistence.internal.entity.NutsLevelRegionMigrationTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "migrationtable", path="migrationtable")
public interface NutsLevelRegionMigrationTableRepository extends JpaRepository <NutsLevelRegionMigrationTable, Long> {

    List<NutsLevelRegionMigrationTable> findByNutsLevel(Integer nutsLevel);
}
