package com.regions.nutsLevel.nutsRegionlevel.persistence.internal.dao;

import com.regions.nutsLevel.nutsRegionlevel.persistence.dao.NutsLevel0RegionDao;
import com.regions.nutsLevel.nutsRegionlevel.persistence.dao.NutsLevel1RegionDao;
import com.regions.nutsLevel.nutsRegionlevel.persistence.internal.entity.NutsLevel0Region;
import com.regions.nutsLevel.nutsRegionlevel.persistence.internal.entity.NutsLevel1Region;
import com.regions.nutsLevel.nutsRegionlevel.persistence.internal.repository.NutsLevel0RegionRepository;
import com.regions.nutsLevel.nutsRegionlevel.persistence.internal.repository.NutsLevel1RegionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class NutsLevel1RegionDaoImpl implements NutsLevel1RegionDao {

    NutsLevel1RegionRepository nutsLevel1RegionRepository;


    @Override
    public NutsLevel1Region findByTerritoryCode(String territoryCode) {
        return nutsLevel1RegionRepository.findByTerritoryCode(territoryCode);
    }

    @Override
    public void deleteAll() {
        nutsLevel1RegionRepository.deleteAll();
    }

    @Override
    public void save(NutsLevel1Region nutsLevel1Region) {
        nutsLevel1RegionRepository.save(nutsLevel1Region);
    }

    @Override
    public List<NutsLevel1Region> findAll() {
        return nutsLevel1RegionRepository.findAll();
    }
}
