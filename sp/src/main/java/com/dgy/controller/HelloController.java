package com.dgy.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.util.HashMap;
import java.util.Map;

@Controller
@RequestMapping("hello")
public class HelloController {

    @RequestMapping("sayHello")
    public ModelAndView sayHello(){
        System.out.println("sayHello.......");
        ModelAndView m =new ModelAndView("hellos");

        m.addObject("msg","msg from server");
        return m;
    }

    @RequestMapping("getData")
    @ResponseBody
    public Map<String,Object> getData(){
        System.out.println("sayHello.......");
        Map<String,Object> map = new HashMap<String,Object>();
        map.put("code",0);
        map.put("msg","hello");
        return map;
    }


}
