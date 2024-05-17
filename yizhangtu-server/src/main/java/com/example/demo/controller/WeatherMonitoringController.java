package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @ClassName TestController
 * @Description: 气象监测接口
 * @Author JavaZhan @公众号:Java全栈架构师
 * @Date 2020/6/13
 * @Version V1.0
 **/
@Controller
@RequestMapping("/weatherMonitoring")
public class WeatherMonitoringController {

    @RequestMapping("getAll")
    @ResponseBody
    public String getTest(){
        return "返回全部的气象监测数据";
    }
}

