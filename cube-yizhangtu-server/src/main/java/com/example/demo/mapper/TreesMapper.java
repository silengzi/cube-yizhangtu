package com.example.demo.mapper;
import com.example.demo.dto.TypeCount;
import com.example.demo.module.Trees;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface TreesMapper {
    List<Trees> getTrees();

    @Select("SELECT type, COUNT(*) as count FROM heritage_trees GROUP BY type")
    List<TypeCount> getTreesTypeCount();
}
