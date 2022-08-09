package com.regions.nutsLevel.nutsRegionlevel.persistence.internal.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name ="nuts_level_3_region")
public class NutsLevel3Region extends BaseNutsLevelRegion{

    public NutsLevel3Region() {
        super();
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nuts_level_3_region_id")
    private Long id;


    @ManyToOne
    @JoinColumn(name="nuts_level_2_region_id")
    private NutsLevel2Region nutsLevel2Region;


    @Builder
    public NutsLevel3Region(String territoryCode, String name, NutsLevel2Region nutsLevel2Region) {
        super(territoryCode, name);
        this.nutsLevel2Region = nutsLevel2Region;
    }

    @OneToMany(mappedBy = "nutsLevel3Region", cascade = {CascadeType.ALL})
    private List<PopulationDensity> populationDensityList = new ArrayList<>();

}
