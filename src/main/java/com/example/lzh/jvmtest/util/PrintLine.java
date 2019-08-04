package com.example.lzh.jvmtest.util;
import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.Kind;
import com.sun.btrace.annotations.Location;
import com.sun.btrace.annotations.OnMethod;
import com.sun.btrace.annotations.ProbeClassName;
import com.sun.btrace.annotations.ProbeMethodName;
@BTrace
public class PrintLine {
	@OnMethod(
	        clazz="com.example.lzh.jvmtest.controller.BTraceController",
	        method="exception",
	        location=@Location(value=Kind.LINE, line=54)
	)
	public static void anyRead(@ProbeClassName String pcn, @ProbeMethodName String pmn, int line) {
		BTraceUtils.println(pcn+", "+pmn + ", " +line);
		BTraceUtils.println();
    }
}
