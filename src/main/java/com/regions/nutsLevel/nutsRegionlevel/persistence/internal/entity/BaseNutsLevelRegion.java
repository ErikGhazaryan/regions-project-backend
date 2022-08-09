package com.regions.nutsLevel.nutsRegionlevel.persistence.internal.entity;


import lombok.*;
import lombok.experimental.SuperBuilder;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder
@MappedSuperclass
public abstract class BaseNutsLevelRegion {

    @Column(name = "territory_code")
    @Builder.Default
    private String territoryCode = "default";

    @Column(name = "nuts_name")
    private String name;
}
