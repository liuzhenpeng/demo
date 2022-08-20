package com.example.services;

import com.example.annotation.Log;
import org.springframework.stereotype.Service;

@Service
public class Hello {

    @Log(name="小明")
    String name = "world";

    public void say() {
        System.out.println("hello, " + name);
    }
}
