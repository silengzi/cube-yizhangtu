package com.example.demo.mapper;
import com.example.demo.dto.TypeCount;
import com.example.demo.module.Monitor;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MonitorMapper {
    List<Monitor>  getMonitor();

    @Select("SELECT id, ST_AsText(the_geom) AS the_geom, name, code, fzr, tel, type, createTime, updateTime, isDelete FROM monitor_equipment WHERE type = #{type}")
    List<Monitor> getMonitorByType(@Param("type") String type);

    @Select("SELECT type, COUNT(*) as count FROM monitor_equipment GROUP BY type")
    List<TypeCount> getMonitorTypeCount();
}
