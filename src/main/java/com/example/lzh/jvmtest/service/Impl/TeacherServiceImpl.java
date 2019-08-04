package com.example.lzh.jvmtest.service.Impl;

import com.example.lzh.jvmtest.dao.TeacherMapper;
import com.example.lzh.jvmtest.pojo.Teacher;
import com.example.lzh.jvmtest.pojo.TeacherExample;
import com.example.lzh.jvmtest.service.TeacherService;
import org.apache.skywalking.apm.toolkit.trace.ActiveSpan;
import org.apache.skywalking.apm.toolkit.trace.Trace;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

//    @Trace
    @Override
    public List<Teacher> getAllTeacher() {
        TeacherExample example=new TeacherExample();

        List<Teacher> teachers = teacherMapper.selectByExample(example);
        ActiveSpan.tag("getAllTeacher_tag","getAllTeacher-service");

        return teachers;
    }
}
