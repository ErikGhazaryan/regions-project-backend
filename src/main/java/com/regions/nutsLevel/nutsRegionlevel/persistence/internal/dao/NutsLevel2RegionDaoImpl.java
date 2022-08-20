package com.regions.nutsLevel.nutsRegionlevel.persistence.internal.dao;

import com.regions.nutsLevel.nutsRegionlevel.persistence.dao.NutsLevel1RegionDao;
import com.regions.nutsLevel.nutsRegionlevel.persistence.dao.NutsLevel2RegionDao;
import com.regions.nutsLevel.nutsRegionlevel.persistence.internal.entity.NutsLevel1Region;
import com.regions.nutsLevel.nutsRegionlevel.persistence.internal.entity.NutsLevel2Region;
import com.regions.nutsLevel.nutsRegionlevel.persistence.internal.repository.NutsLevel1RegionRepository;
import com.regions.nutsLevel.nutsRegionlevel.persistence.internal.repository.NutsLevel2RegionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class NutsLevel2RegionDaoImpl implements NutsLevel2RegionDao {

    NutsLevel2RegionRepository nutsLevel2RegionRepository;


    @Override
    public NutsLevel2Region findByTerritoryCode(String territoryCode) {
        return nutsLevel2RegionRepository.findByTerritoryCode(territoryCode);
    }

    @Override
    public void deleteAll() {
        nutsLevel2RegionRepository.deleteAll();
    }

    @Override
    public void save(NutsLevel2Region nutsLevel2Region) {
        nutsLevel2RegionRepository.save(nutsLevel2Region);
    }

    @Override
    public List<NutsLevel2Region> findAll() {
        return nutsLevel2RegionRepository.findAll();
    }
}
