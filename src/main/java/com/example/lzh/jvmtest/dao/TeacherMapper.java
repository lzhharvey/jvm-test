package com.example.lzh.jvmtest.dao;

import com.example.lzh.jvmtest.pojo.Teacher;
import com.example.lzh.jvmtest.pojo.TeacherExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.apache.skywalking.apm.toolkit.trace.Trace;

public interface TeacherMapper {
    long countByExample(TeacherExample example);

    int deleteByExample(TeacherExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Teacher record);

    int insertSelective(Teacher record);
//    @Trace
    List<Teacher> selectByExample(TeacherExample example);

    Teacher selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Teacher record, @Param("example") TeacherExample example);

    int updateByExample(@Param("record") Teacher record, @Param("example") TeacherExample example);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);
}