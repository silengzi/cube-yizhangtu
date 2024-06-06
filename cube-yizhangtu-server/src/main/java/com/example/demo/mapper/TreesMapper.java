package com.example.demo.mapper;
import com.example.demo.dto.TypeCount;
import com.example.demo.module.Alarm;
import com.example.demo.module.Trees;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TreesMapper {
    List<Trees> getTrees();

    @Select("SELECT id, ST_AsText(the_geom) AS the_geom, name, type, age, height, bhd, position, protectiv_measures, historical_background, img, createTime, updateTime, isDelete FROM heritage_trees WHERE type = #{type}")
    List<Trees> getTreesByType(@Param("type") String type);

    @Select("SELECT type, COUNT(*) as count FROM heritage_trees GROUP BY type")
    List<TypeCount> getTreesTypeCount();
}
