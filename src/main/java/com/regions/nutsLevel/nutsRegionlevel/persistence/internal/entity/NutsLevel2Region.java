package com.regions.nutsLevel.nutsRegionlevel.persistence.internal.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name ="nuts_level_2_region")
public class NutsLevel2Region extends BaseNutsLevelRegion{

    public NutsLevel2Region() {
        super();
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nuts_level_2_region_id")
    private Long id;

    @With
    @ManyToOne
    @JoinColumn(name="nuts_level_1_region_id")
    private NutsLevel1Region nutsLevel1Region;

    @OneToMany(mappedBy = "nutsLevel2Region", cascade = {CascadeType.ALL})
    private List<NutsLevel3Region> nutsLevel3Regions = new ArrayList<>();

    @Builder
    public NutsLevel2Region(String territoryCode, String name,  NutsLevel1Region nutsLevel1Region, List<NutsLevel3Region> nutsLevel3Regions) {
        super(territoryCode, name);
        this.nutsLevel1Region = nutsLevel1Region;
        this.nutsLevel3Regions = nutsLevel3Regions;
    }

    public NutsLevel2Region(Long id, NutsLevel1Region nutsLevel1Region, List<NutsLevel3Region> nutsLevel3Regions) {
        this.id = id;
        this.nutsLevel1Region = nutsLevel1Region;
        this.nutsLevel3Regions = nutsLevel3Regions;
    }

    public NutsLevel2Region(BaseNutsLevelRegionBuilder<?, ?> b, Long id, NutsLevel1Region nutsLevel1Region, List<NutsLevel3Region> nutsLevel3Regions) {
        super(b);
        this.id = id;
        this.nutsLevel1Region = nutsLevel1Region;
        this.nutsLevel3Regions = nutsLevel3Regions;
    }
}
