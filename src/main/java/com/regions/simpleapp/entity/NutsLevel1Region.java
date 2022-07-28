package com.regions.simpleapp.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="nuts_level_1_region")
public class NutsLevel1Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nuts_level_1_region_id")
    private Long id;

    @With
    @Column(name = "territory_code")
    private String territoryCode;
    @With
    @Column(name = "nuts_name")
    private String name;

    @With
    @ManyToOne
    @JoinColumn(name="nuts_level_0_region_id")
    private NutsLevel0Region nutsLevel0Region;

    @OneToMany(mappedBy = "nutsLevel1Region", cascade = {CascadeType.ALL})
    private List<NutsLevel2Region> nutsLevel2Regions = new ArrayList<>();



}
