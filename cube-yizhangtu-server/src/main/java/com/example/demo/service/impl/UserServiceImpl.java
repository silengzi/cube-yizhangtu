package com.example.demo.service.impl;
import com.example.demo.mapper.UserMapper;
import com.example.demo.module.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public List getAllUser() {
        return userMapper.getAllUser();
    }
}