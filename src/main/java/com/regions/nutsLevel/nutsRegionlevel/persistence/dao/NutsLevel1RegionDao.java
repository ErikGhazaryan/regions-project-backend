package com.regions.nutsLevel.nutsRegionlevel.persistence.dao;

import com.regions.nutsLevel.nutsRegionlevel.persistence.internal.entity.NutsLevel0Region;
import com.regions.nutsLevel.nutsRegionlevel.persistence.internal.entity.NutsLevel1Region;

import java.util.List;

public interface NutsLevel1RegionDao {

    NutsLevel1Region findByTerritoryCode(String territoryCode);

    void deleteAll();

    void save(NutsLevel1Region build);

    List<NutsLevel1Region> findAll();
}
