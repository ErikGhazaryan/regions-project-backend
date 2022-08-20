package com.regions.nutsLevel.nutsRegionlevel.persistence.dao;

import com.regions.nutsLevel.nutsRegionlevel.persistence.internal.entity.NutsLevel0Region;

import java.util.List;

public interface NutsLevel0RegionDao {

    NutsLevel0Region findByTerritoryCode(String territoryCode);

    void deleteAll();

    void save(NutsLevel0Region build);

    List<NutsLevel0Region> findAll();
}
