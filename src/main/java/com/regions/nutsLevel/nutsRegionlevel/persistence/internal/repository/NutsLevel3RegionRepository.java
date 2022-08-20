package com.regions.nutsLevel.nutsRegionlevel.persistence.internal.repository;

import com.regions.nutsLevel.nutsRegionlevel.persistence.internal.entity.NutsLevel3Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "nutslevel3region", path="nutslevel3region")
public interface NutsLevel3RegionRepository extends JpaRepository<NutsLevel3Region, Long> {
            NutsLevel3Region findByTerritoryCode(String territoryCode);
}
