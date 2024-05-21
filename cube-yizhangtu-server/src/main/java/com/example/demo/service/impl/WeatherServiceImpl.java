package com.example.demo.service.impl;

import com.example.demo.mapper.WeatherMapper;
import com.example.demo.module.Weather;
import com.example.demo.service.WeatherService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class WeatherServiceImpl implements WeatherService {

    @Resource
    private WeatherMapper weatherMapper;

    @Override
    public List<Weather> getWeather() {
        return weatherMapper.getWeather();
    }

}