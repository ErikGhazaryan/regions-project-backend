package com.regions.nutsLevel.nutsRegionlevel.persistence.internal.entity;

import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@Table(name="population_density")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PopulationDensity {




    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "population_density_id")
    private Long id;

    @Column(name="population_density_psk")
    private String populationDensityPsk;


    @ManyToOne
    @JoinColumn(name="nuts_level_3_region_id")
    private NutsLevel3Region nutsLevel3Region;

    @ManyToOne
    @JoinColumn(name="year_period_id")
    private YearPeriod yearPeriod;

}
