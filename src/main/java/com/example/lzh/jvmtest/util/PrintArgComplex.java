package com.example.lzh.jvmtest.util;
import java.lang.reflect.Field;

import com.example.lzh.jvmtest.pojo.Teacher;
import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.Kind;
import com.sun.btrace.annotations.Location;
import com.sun.btrace.annotations.OnMethod;
import com.sun.btrace.annotations.ProbeClassName;
import com.sun.btrace.annotations.ProbeMethodName;
@BTrace
public class PrintArgComplex {
	@OnMethod(
	        clazz="com.example.lzh.jvmtest.controller.BTraceController",
	        method="arg2",
	        location=@Location(Kind.ENTRY)
	)
	public static void anyRead(@ProbeClassName String pcn, @ProbeMethodName String pmn, Teacher user) {
		//print all fields  打印对象
		BTraceUtils.printFields(user);
		//print one field  获取其中的一个属性
		Field filed2 = BTraceUtils.field("com.example.lzh.jvmtest.pojo.Teacher", "name");
		BTraceUtils.println(BTraceUtils.get(filed2, user));
		BTraceUtils.println(pcn+","+pmn);
		BTraceUtils.println();
    }
}
