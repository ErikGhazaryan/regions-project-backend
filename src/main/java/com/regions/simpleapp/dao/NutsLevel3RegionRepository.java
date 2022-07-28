package com.regions.simpleapp.dao;

import com.regions.simpleapp.entity.NutsLevel2Region;
import com.regions.simpleapp.entity.NutsLevel3Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "nutslevel3region", path="nutslevel3region")
public interface NutsLevel3RegionRepository extends JpaRepository<NutsLevel3Region, Long> {

}
