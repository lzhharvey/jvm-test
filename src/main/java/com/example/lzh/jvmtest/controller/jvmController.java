package com.example.lzh.jvmtest.controller;

import com.alibaba.fastjson.JSON;
import com.example.lzh.jvmtest.pojo.Teacher;
import com.example.lzh.jvmtest.service.TeacherService;
import org.apache.skywalking.apm.toolkit.trace.ActiveSpan;
import org.apache.skywalking.apm.toolkit.trace.Trace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class jvmController {
    @Autowired
    private TeacherService teacherService;

    /**
     * hello
     * @return
     */
    @RequestMapping("hello")
    @ResponseBody
    public String  getHello(){
        return  "hello";
    }

    @RequestMapping("hi")
    @ResponseBody
    public String  getHello(@RequestParam("name")String name){
        return  "hi "+name;
    }

    @RequestMapping("getMessage")
    @ResponseBody
    public String  getMessage(@RequestParam("message")String message){
        return  message;
    }

    @RequestMapping("getAllTeacher")
    @ResponseBody
    public String getAllTeacher(){
        List<Teacher> allTeacher = teacherService.getAllTeacher();
        String string = JSON.toJSONString(allTeacher);
        ActiveSpan.tag("getAllTeacher_tag","getAllTeacher-controller");
        return string;
    }
}
