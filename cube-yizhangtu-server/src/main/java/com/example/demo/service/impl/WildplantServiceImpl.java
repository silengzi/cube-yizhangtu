package com.example.demo.service.impl;

import com.example.demo.dto.TypeCount;
import com.example.demo.mapper.WildplantMapper;
import com.example.demo.module.Wildplant;
import com.example.demo.service.WildplantService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class WildplantServiceImpl implements WildplantService {

    @Resource
    private WildplantMapper wildplantMapper;

    @Override
    public List<Wildplant> getWildplant() {
        return wildplantMapper.getWildplant();
    }

    @Override
    public Map<String, Integer> getWildplantNums() {
        List<TypeCount> typeCounts = wildplantMapper.getWildplantTypeCount();

        // 将 typeCounts 转换为 Map，方便查找
        Map<String, Integer> typeCountMap = new HashMap<>();
        for (TypeCount typeCount : typeCounts) {
            typeCountMap.put(typeCount.getType(), typeCount.getCount());
        }
        return typeCountMap;
    }
}