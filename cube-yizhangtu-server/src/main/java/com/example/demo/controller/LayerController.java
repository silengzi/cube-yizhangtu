package com.example.demo.controller;

import com.example.demo.module.Result;
import com.example.demo.service.LayerService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping("/layers")
public class LayerController {

    @Resource
    private LayerService layerService;

    /**
     * 根据图层类型查询各图层的数据
     * @return
     */
    @GetMapping("/getLayers")
    public Result getLayers(@RequestParam String type) {
        return new Result(Result.SUCCESS, "查询成功", layerService.getLayers(type));
    }
}
