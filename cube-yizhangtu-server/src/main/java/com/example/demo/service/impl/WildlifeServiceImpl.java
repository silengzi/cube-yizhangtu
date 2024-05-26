package com.example.demo.service.impl;

import com.example.demo.dto.TypeCount;
import com.example.demo.mapper.WildlifeMapper;
import com.example.demo.module.Wildlife;
import com.example.demo.service.WildlifeService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WildlifeServiceImpl implements WildlifeService {

    @Resource
    private WildlifeMapper wildlifeMapper;

    @Override
    public List<Wildlife> getWildlife() {
        return wildlifeMapper.getWildlife();
    }

    @Override
    public Map<String, Integer> getWildlifeNums() {
        List<TypeCount> typeCounts = wildlifeMapper.getWildlifeTypeCount();

        // 将 typeCounts 转换为 Map，方便查找
        Map<String, Integer> typeCountMap = new HashMap<>();
        for (TypeCount typeCount : typeCounts) {
            typeCountMap.put(typeCount.getType(), typeCount.getCount());
        }
        return typeCountMap;
    }
}