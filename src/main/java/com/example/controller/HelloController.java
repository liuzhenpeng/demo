package com.example.controller;

import com.example.mapper.KdUserMapper;
import com.example.pojo.KdUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HelloController {
    @Autowired
    KdUserMapper kdUserMapper;

    @GetMapping("/hello")
    @ResponseBody
    public String hello() {
        return "hello world";
    }

    @GetMapping("/getusers")
    @ResponseBody
    public List<KdUser> getUsers(){
         List<KdUser> users = kdUserMapper.getUsers();
         System.out.println(users);
         return users;
    }
}