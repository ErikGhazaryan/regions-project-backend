package com.regions.simpleapp.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
public class MigrationTable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "migration_table_id")
    private Long id;

    @Column(name = "territory_code")
    private String territoryCode;

    @Column(name = "nuts_level")
    private Integer nutsLevel;

    @Column(name = "country_order")
    private Integer countryOrder;

    @Column(name = "region_order")
    private Integer regionOrder;
}
