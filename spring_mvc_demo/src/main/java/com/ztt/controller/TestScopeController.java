package com.ztt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class TestScopeController {
    @RequestMapping("/test/mav")
    public ModelAndView testMAV(){
        /**
         * ModelAndView包含Model和View的功能
         * Model：向请求域中中共享数据
         * View：设置逻辑视图实现页面跳转
         */
       ModelAndView mav =new ModelAndView();
       //向请求域中中共享数据
       mav.addObject("testRequestScope","hello,ModelAndView");
       mav.setViewName("success");
       return mav;
    }
    @RequestMapping("/test/model")
    public String testModel(Model model){
        model.addAttribute("testRequestScope","hello,Model");
        return "success";
    }
    @RequestMapping("/test/modelMap")
    public String testModelMap(ModelMap modelMap){
        modelMap.addAttribute("testRequestScope","hello,ModelMap");
        return "success";
    }
}
