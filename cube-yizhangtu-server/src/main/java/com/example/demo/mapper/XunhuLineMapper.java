package com.example.demo.mapper;
import com.example.demo.module.XunhuLine;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface XunhuLineMapper {
    @Select("SELECT id, fid, ST_AsText(the_geom) AS the_geom FROM gis_xunhu_line")
    List<XunhuLine> getXunhuLine();
}
