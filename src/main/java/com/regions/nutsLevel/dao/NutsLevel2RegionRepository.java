package com.regions.nutsLevel.dao;

import com.regions.nutsLevel.nutsRegionlevel.persistence.internal.entity.NutsLevel2Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "nutslevel2region", path="nutslevel2region")
public interface NutsLevel2RegionRepository extends JpaRepository<NutsLevel2Region, Long> {
    NutsLevel2Region findByTerritoryCode(String territoryCode);

}
