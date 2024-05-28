package com.example.demo.mapper;
import com.example.demo.dto.TypeCount;
import com.example.demo.module.Wildplant;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface WildplantMapper {
    List<Wildplant> getWildplant();

    @Select("SELECT type2 as type, COUNT(*) as count FROM wildplant_conservation GROUP BY type2")
    List<TypeCount> getWildplantTypeCount();
}
