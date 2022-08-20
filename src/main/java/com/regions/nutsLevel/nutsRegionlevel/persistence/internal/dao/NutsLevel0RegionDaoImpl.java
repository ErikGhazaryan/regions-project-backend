package com.regions.nutsLevel.nutsRegionlevel.persistence.internal.dao;

import com.regions.nutsLevel.nutsRegionlevel.persistence.dao.NutsLevel0RegionDao;
import com.regions.nutsLevel.nutsRegionlevel.persistence.internal.entity.NutsLevel0Region;
import com.regions.nutsLevel.nutsRegionlevel.persistence.internal.repository.NutsLevel0RegionRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class NutsLevel0RegionDaoImpl implements NutsLevel0RegionDao {

    NutsLevel0RegionRepository nutsLevel0RegionRepository;


    @Override
    public NutsLevel0Region findByTerritoryCode(String territoryCode) {
        return nutsLevel0RegionRepository.findByTerritoryCode(territoryCode);
    }

    @Override
    public void deleteAll() {
        nutsLevel0RegionRepository.deleteAll();
    }

    @Override
    public void save(NutsLevel0Region nutsLevel0Region) {
        nutsLevel0RegionRepository.save(nutsLevel0Region);
    }

    @Override
    public List<NutsLevel0Region> findAll() {
        return nutsLevel0RegionRepository.findAll();
    }
}
