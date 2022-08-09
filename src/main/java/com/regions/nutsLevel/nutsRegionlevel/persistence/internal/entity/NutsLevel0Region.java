package com.regions.nutsLevel.nutsRegionlevel.persistence.internal.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name ="nuts_level_0_region")
public class NutsLevel0Region extends BaseNutsLevelRegion {

    public NutsLevel0Region() {
        super();
    }

    @Builder
    public NutsLevel0Region(String territoryCode, String name, List<NutsLevel1Region> nutsLevel1Regions) {
        super(territoryCode, name);
        this.nutsLevel1Regions = nutsLevel1Regions;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nuts_level_0_region_id")
    private Long id;

    @OneToMany(mappedBy = "nutsLevel0Region", cascade = {CascadeType.ALL})
    private List<NutsLevel1Region> nutsLevel1Regions = new ArrayList<>();



}
