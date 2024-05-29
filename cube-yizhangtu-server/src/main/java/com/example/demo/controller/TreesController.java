package com.example.demo.controller;

import com.example.demo.module.Result;
import com.example.demo.service.TreesService;
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
@RequestMapping("/trees")
public class TreesController {

    @Resource
    private TreesService treesService;

    /**
     * 查询所有的监控设备
     * @return
     */
    @GetMapping("/getTrees")
    public Result getTrees(){
        return new Result(Result.SUCCESS, "查询成功", treesService.getTrees());
    }

    /**
     * 查询各种监控设备的数量
     */
    @GetMapping("/getTreesNums")
    public Result getTreesNums(){
        return new Result(Result.SUCCESS, "查询成功", treesService.getTreesNums());
    }
}
