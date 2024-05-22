package com.example.demo.service.impl;

import com.example.demo.dto.MonitorWithTypeCountDTO;
import com.example.demo.dto.TypeCount;
import com.example.demo.mapper.MonitorMapper;
import com.example.demo.module.Monitor;
import com.example.demo.service.MonitorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class MonitorServiceImpl implements MonitorService {

    @Resource
    private MonitorMapper monitorMapper;

    @Override
    public List<MonitorWithTypeCountDTO> getMonitor() {
        List<Monitor> monitors = monitorMapper.getMonitor();
        List<TypeCount> typeCounts = monitorMapper.getMonitorTypeCount();

        // 将 typeCounts 转换为 Map，方便查找
        Map<String, Integer> typeCountMap = new HashMap<>();
        for (TypeCount typeCount : typeCounts) {
            typeCountMap.put(typeCount.getType(), typeCount.getCount());
        }

        // 创建一个新的 MonitorWithTypeCountDTO 列表
        List<MonitorWithTypeCountDTO> result = new ArrayList<>();
        for (Monitor monitor : monitors) {
            MonitorWithTypeCountDTO dto = new MonitorWithTypeCountDTO();
            dto.setId(monitor.getId());
            dto.setThe_geom(monitor.getThe_geom());
            dto.setName(monitor.getName());
            dto.setCode(monitor.getCode());
            dto.setFzr(monitor.getFzr());
            dto.setTel(monitor.getTel());
            dto.setType(monitor.getType());
            dto.setCreateTime(monitor.getCreateTime());
            dto.setUpdateTime(monitor.getUpdateTime());
            dto.setIsDelete(monitor.getIsDelete());
            dto.setTypeCount(typeCountMap);  // 将类型计数添加到 DTO
            result.add(dto);
        }
        return result;
    }

}