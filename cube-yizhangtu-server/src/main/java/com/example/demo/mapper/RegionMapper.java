package com.example.demo.mapper;
import com.example.demo.module.Region;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RegionMapper {

    @Select("SELECT * FROM area_province")
    List<Region> getAllProvinces();

    @Select("SELECT * FROM area_city WHERE parent_code = #{provinceId}")
    List<Region> getCitiesByProvinceId(String provinceId);

    @Select("SELECT * FROM area_country WHERE parent_code = #{cityId}")
    List<Region> getCountrysByCityId(String cityId);
}