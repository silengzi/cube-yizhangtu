package com.example.demo.mapper;
import com.example.demo.dto.TypeCount;
import com.example.demo.module.Alarm;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AlarmMapper {
    List<Alarm> getAlarm();

    @Select("SELECT type, COUNT(*) as count FROM alarm_statistics GROUP BY type")
    List<TypeCount> getAlarmTypeCount();
}
