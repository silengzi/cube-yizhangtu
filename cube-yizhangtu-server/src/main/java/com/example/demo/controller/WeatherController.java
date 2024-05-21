package com.example.demo.controller;

import com.example.demo.dto.DeleteArticleRequest;
import com.example.demo.module.Weather;
import com.example.demo.module.Result;
import com.example.demo.service.WeatherService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * @ClassName UserController
 * @Description: TODO
 * @Author JavaZhan @公众号:Java全栈架构师
 * @Date 2020/6/13
 * @Version V1.0
 **/

@RestController
@RequestMapping("/weather")
public class WeatherController {

    @Resource
    private WeatherService weatherService;

    @GetMapping("/getWeather")
    public Result getWeather(){
        return new Result(Result.SUCCESS, "查询成功", weatherService.getWeather());
    }
}
