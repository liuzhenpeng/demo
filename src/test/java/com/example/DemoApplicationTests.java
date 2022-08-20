package com.example;


import com.example.mapper.KdUserMapper;
import com.example.pojo.KdUser;
import com.example.services.Hello;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;
import com.example.utils.utils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@SpringBootTest
class DemoApplicationTests {

    @Autowired
    KdUserMapper kdUserMapper ;
    @Autowired
    Hello hello;

    @Test
    void contextLoads() throws SQLException {
        List<KdUser> users=kdUserMapper.getUsers();
         System.out.println(users);
    }
    @Test
    void Test_getUser() throws SQLException {
        KdUser user=kdUserMapper.getUser(1);
        System.out.println(user);
    }

    @Test
    void TestinsertUser() throws SQLException {
        KdUser user = new KdUser(0,"lzp1",101,utils.getSecondTimestamp());
        int reslut=kdUserMapper.insertUser(user);
        System.out.println(reslut);
    }

    @Test
    void TestupdateUser() throws SQLException {
        Map<String,Object> map= new HashMap<String, Object>();
        map.put("id",1);
        map.put("username","updatename111");
        int reslut=kdUserMapper.updateUser(map);
        System.out.printf("============%s  %d\n" ,"testupdateUser", reslut);
    }
    @Test
    void Test_deleteUser() throws SQLException {
        Map<String,Object> map= new HashMap<String, Object>();
        map.put("id",2);
        int reslut=kdUserMapper.deleteUser(map);
        System.out.println(reslut);
    }
    @Test
    void Test_Hello() throws SQLException {
       // Hello hello = context.getBean(Hello.class);
        hello.say();
    }

}
