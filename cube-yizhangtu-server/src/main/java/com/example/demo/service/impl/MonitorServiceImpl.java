package com.example.demo.service.impl;

import com.example.demo.mapper.MonitorMapper;
import com.example.demo.module.Monitor;
import com.example.demo.service.MonitorService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class MonitorServiceImpl implements MonitorService {

    @Resource
    private MonitorMapper monitorMapper;

    @Override
    public List<Monitor> getMonitor() {
        return monitorMapper.getMonitor();
    }

}