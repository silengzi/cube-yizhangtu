package com.example.demo.controller;

import com.example.demo.module.Result;
import com.example.demo.service.WildlifeService;
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
@RequestMapping("/wildlife")
public class WildlifeController {

    @Resource
    private WildlifeService wildlifeService;

    /**
     * 查询所有的监控设备
     * @return
     */
    @GetMapping("/getWildlife")
    public Result getWildlife(){
        return new Result(Result.SUCCESS, "查询成功", wildlifeService.getWildlife());
    }

    /**
     * 查询各种监控设备的数量
     */
    @GetMapping("/getWildlifeNums")
    public Result getWildlifeNums(){
        return new Result(Result.SUCCESS, "查询成功", wildlifeService.getWildlifeNums());
    }
}
