package com.regions.nutsLevel.nutsRegionlevel.persistence.internal.entity;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name="year_period")
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class YearPeriod {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "year_period_id")
    private Long id;

    @Column(name="calendar_year")
    private int calendarYear;

    @OneToMany(mappedBy = "yearPeriod", cascade = {CascadeType.ALL})
    private List<PopulationDensity> populationDensityList;

}
