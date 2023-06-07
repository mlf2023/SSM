package com.ztt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.lang.reflect.Method;

@Controller
@RequestMapping("/test")
public class TestRequestMappingController {
    @RequestMapping(
            value = {"/hello","/abc"},
            method ={ RequestMethod.GET,RequestMethod.POST}
            //params = {"username","!user","age=20","gender!=女"}
    )
    public String hello(){
    return "success";
    }
    @RequestMapping("/ **/ant")
    public String testAnt()
    {
       return "success";
    }
    @RequestMapping("/rest/{id}")
    public String testRest(@PathVariable("id") Integer id){
        System.out.println(id);
        return "success";
    }
}
