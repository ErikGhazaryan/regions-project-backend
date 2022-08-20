package com.regions.nutsLevel.migration.persistence.internal.dao;

import com.regions.nutsLevel.migration.persistence.dao.NutsLevelRegionMigrationTableDao;
import com.regions.nutsLevel.migration.persistence.internal.entity.NutsLevelRegionMigrationTable;
import com.regions.nutsLevel.migration.persistence.internal.repository.NutsLevelRegionMigrationTableRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class NutsLevelRegionMigrationTableDaoImpl implements NutsLevelRegionMigrationTableDao {

    NutsLevelRegionMigrationTableRepository nutsLevelRegionMigrationTableRepository;
    @Override
    public List<NutsLevelRegionMigrationTable> findAll() {
        return nutsLevelRegionMigrationTableRepository.findAll();
    }

    @Override
    public List<NutsLevelRegionMigrationTable> findByNutsLevel(Integer nutsLevel) {
        return nutsLevelRegionMigrationTableRepository.findByNutsLevel(nutsLevel);
    }

    @Override
    public void save(NutsLevelRegionMigrationTable nutsLevelRegionMigrationTable) {
        nutsLevelRegionMigrationTableRepository.save(nutsLevelRegionMigrationTable);
    }
}
