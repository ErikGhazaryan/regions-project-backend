package com.regions.nutsLevel.nutsRegionlevel.persistence.internal.dao;

import com.regions.nutsLevel.nutsRegionlevel.persistence.dao.NutsLevel2RegionDao;
import com.regions.nutsLevel.nutsRegionlevel.persistence.dao.NutsLevel3RegionDao;
import com.regions.nutsLevel.nutsRegionlevel.persistence.internal.entity.NutsLevel2Region;
import com.regions.nutsLevel.nutsRegionlevel.persistence.internal.entity.NutsLevel3Region;
import com.regions.nutsLevel.nutsRegionlevel.persistence.internal.repository.NutsLevel2RegionRepository;
import com.regions.nutsLevel.nutsRegionlevel.persistence.internal.repository.NutsLevel3RegionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class NutsLevel3RegionDaoImpl implements NutsLevel3RegionDao {

    NutsLevel3RegionRepository nutsLevel3RegionRepository;


    @Override
    public NutsLevel3Region findByTerritoryCode(String territoryCode) {
        return nutsLevel3RegionRepository.findByTerritoryCode(territoryCode);
    }

    @Override
    public void deleteAll() {
        nutsLevel3RegionRepository.deleteAll();
    }

    @Override
    public void save(NutsLevel3Region nutsLevel3Region) {
        nutsLevel3RegionRepository.save(nutsLevel3Region);
    }

    @Override
    public List<NutsLevel3Region> findAll() {
        return nutsLevel3RegionRepository.findAll();
    }
}
