package com.example.demo.service.impl;

import com.example.demo.module.Layer;
import com.example.demo.module.Monitor;
import com.example.demo.mapper.MonitorMapper;
import com.example.demo.module.Wildlife;
import com.example.demo.mapper.WildlifeMapper;
import com.example.demo.module.Wildplant;
import com.example.demo.mapper.WildplantMapper;
import com.example.demo.module.Alarm;
import com.example.demo.mapper.AlarmMapper;
import com.example.demo.module.Trees;
import com.example.demo.mapper.TreesMapper;
import com.example.demo.service.LayerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class LayerserviceImpl implements LayerService {

    @Resource
    private MonitorMapper monitorMapper;
    @Resource
    private WildlifeMapper wildlifeMapper;
    @Resource
    private WildplantMapper wildplantMapper;
    @Resource
    private AlarmMapper alarmMapper;
    @Resource
    private TreesMapper treesMapper;

    @Override
    public List<? extends Layer> getLayers(String type) {
        switch (type) {
            case "monitor":
                return getMonitor();
            case "wildlife":
                return getWildlife();
            case "wildplant":
                return getWildplant();
            case "alarm":
                return getAlarm();
            case "trees":
                return getTrees();
            case "无人机":
                return getMonitorByType("无人机");
            default:
                return new ArrayList<>();
        }
    }

    private List<Monitor> getMonitor() {
        return monitorMapper.getMonitor();
    }

    private List<Wildlife> getWildlife() {
        return wildlifeMapper.getWildlife();
    }

    private List<Wildplant> getWildplant() {
        return wildplantMapper.getWildplant();
    }

    private List<Alarm> getAlarm() {
        return alarmMapper.getAlarm();
    }

    private List<Trees> getTrees() {
        return treesMapper.getTrees();
    }

    private List<Monitor> getMonitorByType(String type) {
        return monitorMapper.getMonitorByType(type);
    }
}