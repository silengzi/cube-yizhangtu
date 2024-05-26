package com.example.demo.service;
import com.example.demo.module.Wildlife;

import java.util.List;
import java.util.Map;

public interface WildlifeService {
    List<Wildlife> getWildlife();

    Map<String, Integer> getWildlifeNums();
}