package com.example.demo.service;
import com.example.demo.dto.MonitorWithTypeCountDTO;
import com.example.demo.module.Monitor;

import java.util.List;
import java.util.Map;

public interface MonitorService {
//    List<MonitorWithTypeCountDTO> getMonitor();
    List<Monitor> getMonitor();

    Map<String, Integer> getMonitorNums();
}