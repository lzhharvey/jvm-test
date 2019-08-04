package com.example.lzh.jvmtest.controller;

import com.example.lzh.jvmtest.pojo.Teacher;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("ch4")
public class BTraceController {
    /**
     * 测试拦截方法的参数
     * 测试拦截的时机--拦截返回值
     * @param name
     * @return
     */
    @RequestMapping("arg1")
    public String arg1(@RequestParam("name")String name) {
        return  "hello,"+name;
    }
    /**
     * 测试拦截构造函数
     * @param teacher
     * @return
     */
    @RequestMapping("constructor")
    public Teacher constructor(Teacher teacher){
        return teacher;
    }

    /**
     * 测试拦截同名函数
     * @param name
     * @return
     */
    @RequestMapping("same1")
    public String same(@RequestParam("name")String name) {
        return  "hello,"+name;
    }
    @RequestMapping("same2")
    public String same(@RequestParam("name")String name,@RequestParam("id")int id) {
        return  "hello,"+name+","+id;
    }

    /**
     * 测试拦截时机--异常
     * @return
     */
    @RequestMapping("exception")
    public String exception(){
        try{
            System.out.println("start....");
            System.out.println(1/0);
            System.out.println("end....");
        }
        catch(Exception e)
        {
        }
        return "success";
    }

    @RequestMapping("arg2")
    public Teacher arg2(Teacher teacher) {
        return  teacher;
    }


}
