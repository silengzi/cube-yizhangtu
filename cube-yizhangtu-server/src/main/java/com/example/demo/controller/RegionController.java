package com.example.demo.controller;

import com.example.demo.module.Region;
import com.example.demo.service.RegionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RequestMapping("region")
@RestController
public class RegionController {

    @Resource
    private RegionService regionService;

    @GetMapping("/tree")
    public List<Region> getAllUser() {
        return regionService.getRegionTree();
    }
}

