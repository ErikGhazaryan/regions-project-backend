package com.regions.nutsLevel.nutsRegionlevel.persistence.internal.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name ="nuts_level_1_region")
public class NutsLevel1Region extends BaseNutsLevelRegion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nuts_level_1_region_id")
    private Long id;


    @With
    @ManyToOne
    @JoinColumn(name="nuts_level_0_region_id")
    private NutsLevel0Region nutsLevel0Region;

    @OneToMany(mappedBy = "nutsLevel1Region", cascade = {CascadeType.ALL})
    private List<NutsLevel2Region> nutsLevel2Regions = new ArrayList<>();

    @Builder
    public NutsLevel1Region(String territoryCode, String name, NutsLevel0Region nutsLevel0Region, List<NutsLevel2Region> nutsLevel2Regions) {
        super(territoryCode, name);

        this.nutsLevel0Region = nutsLevel0Region;
        this.nutsLevel2Regions = nutsLevel2Regions;
    }

    public NutsLevel1Region() {
        super();
    }

    public NutsLevel1Region(Long id, NutsLevel0Region nutsLevel0Region, List<NutsLevel2Region> nutsLevel2Regions) {
        this.id = id;
        this.nutsLevel0Region = nutsLevel0Region;
        this.nutsLevel2Regions = nutsLevel2Regions;
    }

    public NutsLevel1Region(BaseNutsLevelRegionBuilder<?, ?> b, Long id, NutsLevel0Region nutsLevel0Region, List<NutsLevel2Region> nutsLevel2Regions) {
        super(b);
        this.id = id;
        this.nutsLevel0Region = nutsLevel0Region;
        this.nutsLevel2Regions = nutsLevel2Regions;
    }
}
