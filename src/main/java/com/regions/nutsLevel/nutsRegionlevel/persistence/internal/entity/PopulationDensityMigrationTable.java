package com.regions.nutsLevel.nutsRegionlevel.persistence.internal.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PopulationDensityMigrationTable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "population_density_migration_table_id")
    private Long id;

    @Column(name = "territory_code")
    private String territoryCode;

    @Column(name = "nuts_level_name")
    private String nutsLevelName;

    @Column(name = "year_2015")
    private String year2015;

    @Column(name = "year_2016")
    private String year2016;

    @Column(name = "year_2017")
    private String year2017;

    @Column(name = "year_2018")
    private String year2018;

    @Column(name = "year_2019")
    private String year2019;
}
