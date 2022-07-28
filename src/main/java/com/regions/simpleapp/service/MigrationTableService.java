package com.regions.simpleapp.service;

import com.regions.simpleapp.dao.MigrationTableRepository;
import com.regions.simpleapp.entity.MigrationTable;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MigrationTableService {

    @Autowired
    MigrationTableRepository migrationTableRepository;

    public List<MigrationTable> getMigrationTables() {
    return this.migrationTableRepository.findAll();
    };



    public List<MigrationTable> prepareRegionByNutsLevel(Integer nutsLevel) {
        return this.migrationTableRepository.findByNutsLevel(nutsLevel);
    }
}
