package com.regions.simpleapp.dao;

import com.regions.simpleapp.entity.NutsLevel0Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "nutslevel0region", path="nutslevel0region")
public interface NutsLevel0RegionRepository extends JpaRepository<NutsLevel0Region, Long> {
    NutsLevel0Region  findByTerritoryCode(String territoryCode);


}
