package com.regions.nutsLevel.nutsRegionlevel.service;

import com.regions.nutsLevel.nutsRegionlevel.persistence.dao.NutsLevel0RegionDao;
import com.regions.nutsLevel.nutsRegionlevel.persistence.dao.NutsLevel1RegionDao;
import com.regions.nutsLevel.nutsRegionlevel.persistence.dao.NutsLevel2RegionDao;
import com.regions.nutsLevel.nutsRegionlevel.persistence.dao.NutsLevel3RegionDao;
import com.regions.nutsLevel.nutsRegionlevel.persistence.internal.entity.NutsLevel0Region;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@AllArgsConstructor
public class NutsLevelRegionService {

    NutsLevel0RegionDao nutsLevel0RegionDao;
    NutsLevel1RegionDao nutsLevel1RegionDao;
    NutsLevel2RegionDao nutsLevel2RegionDao;
    NutsLevel3RegionDao nutsLevel3RegionDao;


    public List<NutsLevel0Region> findAllNutsLevel0Regions() {
        return nutsLevel0RegionDao.findAll();
    }
}
