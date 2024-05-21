package com.example.demo.controller;

import com.example.demo.module.Result;
import com.example.demo.service.MonitorService;
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
@RequestMapping("/monitor")
public class MonitorController {

    @Resource
    private MonitorService monitorService;

    @GetMapping("/getMonitor")
    public Result getMonitor(){
        return new Result(Result.SUCCESS, "查询成功", monitorService.getMonitor());
    }
}
