package com.regions.nutsLevel.migration.persistence.dao;

import com.regions.nutsLevel.migration.persistence.internal.entity.NutsLevelRegionMigrationTable;

import java.util.List;

public interface NutsLevelRegionMigrationTableDao {
    List<NutsLevelRegionMigrationTable> findAll();

    List<NutsLevelRegionMigrationTable> findByNutsLevel(Integer nutsLevel);

    void save(NutsLevelRegionMigrationTable nutsLevelRegionMigrationTable);
}
