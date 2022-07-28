package com.regions.simpleapp.dao;

import com.regions.simpleapp.entity.MigrationTable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.List;

@CrossOrigin
@RepositoryRestResource(collectionResourceRel = "migrationtable", path="migrationtable")
public interface MigrationTableRepository extends JpaRepository <MigrationTable, Long> {

    List<MigrationTable> findByNutsLevel(Integer nutsLevel);
}
