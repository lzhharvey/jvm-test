package com.example.lzh.jvmtest.util;
import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.OnMethod;
import com.sun.btrace.annotations.ProbeClassName;
import com.sun.btrace.annotations.ProbeMethodName;
@BTrace
public class PrintRegex {
	@OnMethod(
	        clazz="com.example.lzh.jvmtest.controller.BTraceController",
	        //拦截所有方法
			method="/.*/"
	)
	public static void anyRead(@ProbeClassName String pcn, @ProbeMethodName String pmn) {
		BTraceUtils.println(pcn+","+pmn);
		BTraceUtils.println();
    }
}
