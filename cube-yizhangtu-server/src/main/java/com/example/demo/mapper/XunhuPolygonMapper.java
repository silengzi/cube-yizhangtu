package com.example.demo.mapper;
import com.example.demo.module.XunhuPolygon;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface XunhuPolygonMapper {
    @Select("SELECT id, fid, ST_AsText(the_geom) AS the_geom FROM gis_xunhu_polygon")
    List<XunhuPolygon> getXunhuPolygon();
}
