package com.example.lzh.jvmtest.controller;

import com.example.lzh.jvmtest.pojo.Teacher;
import com.example.lzh.jvmtest.util.Metaspace;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@RestController
public class MemoryController {
    private List<Teacher> teacherList=new ArrayList<Teacher>();
    private List<Class<?>> classesList=new ArrayList<Class<?>>();

    /**
     * -Xmx32M -Xms32M  最大 最小堆内存
     * 构造一个堆内存溢出
     * 访问接口出现：
     * Exception in thread "DataCarrier.DEFAULT.Consumser.0.Thread" Exception in thread "http-nio-8081-exec-6" Exception in thread "http-nio-8081-exec-5" java.lang.OutOfMemoryError: GC overhead limit exceeded
     * java.lang.OutOfMemoryError: GC overhead limit exceeded
     * java.lang.OutOfMemoryError: GC overhead limit exceeded
     * Exception in thread "grpc-default-worker-ELG-1-2" java.lang.OutOfMemoryError: GC overhead limit exceeded
     */
    @GetMapping("heap")
    public String heap(){
        int i=0;
        while(true){
            teacherList.add(new Teacher(i++,0, UUID.randomUUID().toString()));
        }
    }

    /**
     * -XX:MetaspaceSize=32M -XX:MaxMetaspaceSize=32M
     * 如果启动就报Exception in thread "main" java.lang.OutOfMemoryError: Metaspace
     * 把32M调大点
     * 构造一个非堆区内存溢出,Metaspace溢出
     * 访问接口出现：
     * java.lang.OutOfMemoryError: Metaspace
     * @return
     */
    @GetMapping("nonheap")
    public String nonheap(){
        int i=0;
        while(true){
            //动态的生成class
            classesList.addAll(Metaspace.createClasses());
        }
    }




}
