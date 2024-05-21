package com.example.demo.mapper;
import com.example.demo.module.Weather;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface WeatherMapper {
    List<Weather>  getWeather();
}