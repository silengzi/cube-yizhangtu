package com.example.demo.service.impl;

import com.example.demo.dto.TypeCount;
import com.example.demo.mapper.AlarmMapper;
import com.example.demo.module.Alarm;
import com.example.demo.service.AlarmService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class AlarmServiceImpl implements AlarmService {

    @Resource
    private AlarmMapper alarmMapper;

    @Override
    public List<Alarm> getAlarm() {
        return alarmMapper.getAlarm();
    }

    @Override
    public Map<String, Integer> getAlarmNums() {
        List<TypeCount> typeCounts = alarmMapper.getAlarmTypeCount();

        // 将 typeCounts 转换为 Map，方便查找
        Map<String, Integer> typeCountMap = new HashMap<>();
        for (TypeCount typeCount : typeCounts) {
            typeCountMap.put(typeCount.getType(), typeCount.getCount());
        }
        return typeCountMap;
    }
}