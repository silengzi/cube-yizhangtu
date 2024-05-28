package com.example.demo.mapper;
import com.example.demo.dto.TypeCount;
import com.example.demo.module.Wildlife;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface WildlifeMapper {
    List<Wildlife> getWildlife();

    @Select("SELECT type2 as type, COUNT(*) as count FROM wildlife_conservation GROUP BY type2")
    List<TypeCount> getWildlifeTypeCount();
}
