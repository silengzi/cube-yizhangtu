package com.example.demo.service;
import com.example.demo.dto.MonitorWithTypeCountDTO;
import com.example.demo.module.Monitor;

import java.util.List;

public interface MonitorService {
    List<MonitorWithTypeCountDTO> getMonitor();
}