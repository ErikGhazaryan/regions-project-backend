package com.regions.nutsLevel.dao;

import com.regions.nutsLevel.nutsRegionlevel.persistence.internal.entity.NutsLevel3Region;
import com.regions.nutsLevel.nutsRegionlevel.persistence.internal.entity.PopulationDensity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "populationdensity", path="populationdensity")
public interface PopulationDensityRepository extends JpaRepository<PopulationDensity, Long> {

}
