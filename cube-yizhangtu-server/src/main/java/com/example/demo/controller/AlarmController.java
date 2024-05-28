package com.example.demo.controller;

import com.example.demo.module.Result;
import com.example.demo.service.AlarmService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @ClassName UserController
 * @Description: TODO
 * @Author JavaZhan @公众号:Java全栈架构师
 * @Date 2020/6/13
 * @Version V1.0
 **/

@RestController
@RequestMapping("/alarm")
public class AlarmController {

    @Resource
    private AlarmService alarmService;

    /**
     * 查询所有的监控设备
     * @return
     */
    @GetMapping("/getAlarm")
    public Result getAlarm(){
        return new Result(Result.SUCCESS, "查询成功", alarmService.getAlarm());
    }

    /**
     * 查询各种监控设备的数量
     */
    @GetMapping("/getAlarmNums")
    public Result getAlarmNums(){
        return new Result(Result.SUCCESS, "查询成功", alarmService.getAlarmNums());
    }
}
