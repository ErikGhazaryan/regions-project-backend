package com.regions.nutsLevel.api;

import com.regions.nutsLevel.nutsRegionlevel.persistence.internal.entity.NutsLevel0Region;
import com.regions.nutsLevel.nutsRegionlevel.service.NutsLevelRegionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@AllArgsConstructor
@RestController
public class NutsLevelRegionController {

  NutsLevelRegionService nutsLevelRegionService;


@GetMapping(value="/nutslevel0region", produces = "application/json")
    public List<NutsLevel0Region> findNutsLevel0Regions() {
    return nutsLevelRegionService.findAllNutsLevel0Regions();
  }



}
