package com.example.demo.mapper;
import com.example.demo.dto.TypeCount;
import com.example.demo.module.Alarm;
import com.example.demo.module.Monitor;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AlarmMapper {
    List<Alarm> getAlarm();

    @Select("SELECT id, ST_AsText(the_geom) AS the_geom, type, level, status, description, person, handle_date, img, createTime, updateTime, isDelete FROM alarm_statistics WHERE type = #{type}")
    List<Alarm> getAlarmByType(@Param("type") String type);

    @Select("SELECT type, COUNT(*) as count FROM alarm_statistics GROUP BY type")
    List<TypeCount> getAlarmTypeCount();
}
