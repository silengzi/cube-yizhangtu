package com.example.demo.mapper;
import com.example.demo.dto.TypeCount;
import com.example.demo.module.Monitor;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface MonitorMapper {
    List<Monitor>  getMonitor();

    @Select("SELECT type, COUNT(*) as count FROM monitor_equipment GROUP BY type")
    List<TypeCount> getMonitorTypeCount();
}
