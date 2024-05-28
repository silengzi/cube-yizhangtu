package com.example.demo.service.impl;

import com.example.demo.dto.TypeCount;
import com.example.demo.mapper.TreesMapper;
import com.example.demo.module.Trees;
import com.example.demo.service.TreesService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class TreesServiceImpl implements TreesService {

    @Resource
    private TreesMapper treesMapper;

    @Override
    public List<Trees> getTrees() {
        return treesMapper.getTrees();
    }

    @Override
    public Map<String, Integer> getTreesNums() {
        List<TypeCount> typeCounts = treesMapper.getTreesTypeCount();

        // 将 typeCounts 转换为 Map，方便查找
        Map<String, Integer> typeCountMap = new HashMap<>();
        for (TypeCount typeCount : typeCounts) {
            typeCountMap.put(typeCount.getType(), typeCount.getCount());
        }
        return typeCountMap;
    }
}