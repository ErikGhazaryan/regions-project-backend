package com.regions.nutsLevel.nutsRegionlevel.persistence.dao;

import com.regions.nutsLevel.nutsRegionlevel.persistence.internal.entity.NutsLevel1Region;
import com.regions.nutsLevel.nutsRegionlevel.persistence.internal.entity.NutsLevel2Region;

import java.util.List;

public interface NutsLevel2RegionDao {

    NutsLevel2Region findByTerritoryCode(String territoryCode);

    void deleteAll();

    void save(NutsLevel2Region build);

    List<NutsLevel2Region> findAll();
}
