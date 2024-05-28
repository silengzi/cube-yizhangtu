package com.example.demo.service;
import com.example.demo.module.Trees;

import java.util.List;
import java.util.Map;

public interface TreesService {
    List<Trees> getTrees();

    Map<String, Integer> getTreesNums();
}