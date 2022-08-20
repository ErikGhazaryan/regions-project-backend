package com.regions.nutsLevel.nutsRegionlevel.persistence.dao;

import com.regions.nutsLevel.nutsRegionlevel.persistence.internal.entity.NutsLevel2Region;
import com.regions.nutsLevel.nutsRegionlevel.persistence.internal.entity.NutsLevel3Region;

import java.util.List;

public interface NutsLevel3RegionDao {

    NutsLevel3Region findByTerritoryCode(String territoryCode);

    void deleteAll();

    void save(NutsLevel3Region build);

    List<NutsLevel3Region> findAll();
}
