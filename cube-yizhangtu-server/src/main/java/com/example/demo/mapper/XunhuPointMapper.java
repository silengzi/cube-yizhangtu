package com.example.demo.mapper;
import com.example.demo.module.XunhuPoint;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface XunhuPointMapper {
    @Select("SELECT id, fid, ST_AsText(the_geom) AS the_geom, name, tel FROM gis_xunhu_point")
    List<XunhuPoint> getXunhuPoint();
}
