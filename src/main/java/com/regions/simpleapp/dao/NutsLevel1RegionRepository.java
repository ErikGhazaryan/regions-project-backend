package com.regions.simpleapp.dao;

import com.regions.simpleapp.entity.NutsLevel0Region;
import com.regions.simpleapp.entity.NutsLevel1Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Optional;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "nutslevel1region", path="nutslevel1region")
public interface NutsLevel1RegionRepository extends JpaRepository<NutsLevel1Region, Long> {
    NutsLevel1Region findByTerritoryCode(String territoryCode);


}
