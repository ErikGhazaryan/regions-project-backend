package com.regions.simpleapp.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="nuts_level_0_region")
public class NutsLevel0Region {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nuts_level_0_region_id")
    private Long id;

    @With
    @Column(name = "territory_code")
    private String territoryCode;

    @Column(name = "nuts_name")
    private String name;


    @OneToMany(mappedBy = "nutsLevel0Region", cascade = {CascadeType.ALL})
    private List<NutsLevel1Region> nutsLevel1Regions = new ArrayList<>();

}
