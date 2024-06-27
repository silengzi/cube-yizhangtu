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
import com.example.demo.module.XunhuPoint;
import com.example.demo.mapper.XunhuPointMapper;
import com.example.demo.module.XunhuLine;
import com.example.demo.mapper.XunhuLineMapper;
import com.example.demo.module.XunhuPolygon;
import com.example.demo.mapper.XunhuPolygonMapper;
import com.example.demo.module.Trees;
import com.example.demo.mapper.TreesMapper;
import com.example.demo.service.LayerService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service
public class LayerServiceImpl implements LayerService {

    @Resource
    private MonitorMapper monitorMapper;
    @Resource
    private WildlifeMapper wildlifeMapper;
    @Resource
    private WildplantMapper wildplantMapper;
    @Resource
    private AlarmMapper alarmMapper;
    @Resource
    private XunhuPointMapper xunhuPointMapper;
    @Resource
    private XunhuLineMapper xunhuLineMapper;
    @Resource
    private XunhuPolygonMapper xunhuPolygonMapper;
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
            case "野生动物":
                return getWildlife();
            case "野生植物":
                return getWildplant();
            case "巡护员":
                return getXunhuPoint();
            case "巡护路线":
                return getXunhuLine();
            case "巡护区域":
                return getXunhuPolygon();
            case "alarm":
                return getAlarm();
            case "trees":
                return getTrees();
            case "无人机":
                return getMonitorByType("无人机");
            case "云台":
                return getMonitorByType("云台");
            case "卡口":
                return getMonitorByType("卡口");
            case "摄像头":
                return getMonitorByType("摄像头");
            case "红外相机":
                return getMonitorByType("红外相机");
            case "声光报警器":
                return getMonitorByType("声光报警器");
            case "气体检测器":
                return getMonitorByType("气体检测器");
            case "火灾告警":
                return getAlarmByType("火灾告警");
            case "非法活动":
                return getAlarmByType("非法活动");
            case "环境污染":
                return getAlarmByType("环境污染");
            case "野生动物异常":
                return getAlarmByType("野生动物异常");
            case "自然灾害":
                return getAlarmByType("自然灾害");
            case "乔木":
                return getTreesByType("乔木");
            case "灌木":
                return getTreesByType("灌木");
            case "草本":
                return getTreesByType("草本");
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

    private List<XunhuPoint> getXunhuPoint() {
        return xunhuPointMapper.getXunhuPoint();
    }
    private List<XunhuLine> getXunhuLine() {
        return xunhuLineMapper.getXunhuLine();
    }
    private List<XunhuPolygon> getXunhuPolygon() {
        return xunhuPolygonMapper.getXunhuPolygon();
    }

    private List<Trees> getTrees() {
        return treesMapper.getTrees();
    }

    private List<Monitor> getMonitorByType(String type) {
        return monitorMapper.getMonitorByType(type);
    }

    private List<Alarm> getAlarmByType(String type) {
        return alarmMapper.getAlarmByType(type);
    }

    private List<Trees> getTreesByType(String type) {
        return treesMapper.getTreesByType(type);
    }
}