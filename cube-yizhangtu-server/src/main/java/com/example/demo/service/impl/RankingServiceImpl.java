package com.example.demo.service.impl;

import com.example.demo.mapper.RankingMapper;
import com.example.demo.module.Ranking;
import com.example.demo.service.RankingService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RankingServiceImpl implements RankingService {

    @Resource
    private RankingMapper rankingMapper;

    @Override
    public List<Ranking> getRanking() {
        return rankingMapper.getRanking();
    }
}