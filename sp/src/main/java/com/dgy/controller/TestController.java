package com.dgy.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("test")
public class TestController {

    //提供接口的数据

    @RequestMapping("getDatas")
    public Map<String,Object> getDatas(){
        System.out.println("sayHello.......");
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("code",1);
        map.put("msg","hello");
        return map;
    }
}
