package com.regions.simpleapp.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name ="nuts_level_3_region")
public class NutsLevel3Region {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "nuts_level_3_region_id")
    private Long id;

    @With
    @Column(name = "territory_code")
    private String territoryCode;

    @With
    @Column(name = "nuts_name")
    private String name;

    @With
    @ManyToOne
    @JoinColumn(name="nuts_level_2_region_id")
    private NutsLevel2Region nutsLevel2Region;


}
