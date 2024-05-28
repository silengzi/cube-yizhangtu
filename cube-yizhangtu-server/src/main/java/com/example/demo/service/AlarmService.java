package com.example.demo.service;
import com.example.demo.module.Alarm;

import java.util.List;
import java.util.Map;

public interface AlarmService {
    List<Alarm> getAlarm();

    Map<String, Integer> getAlarmNums();
}