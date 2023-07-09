package com.example.jdbccluster.controller;

import com.example.jdbccluster.entity.User;
import com.example.jdbccluster.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Yu
 */
@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("selectAll")
    public void selectAll() {
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }
}
