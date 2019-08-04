package com.example.lzh.jvmtest.util;
import com.sun.btrace.AnyType;
import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.BTrace;
import com.sun.btrace.annotations.Kind;
import com.sun.btrace.annotations.Location;
import com.sun.btrace.annotations.OnMethod;
import com.sun.btrace.annotations.ProbeClassName;
import com.sun.btrace.annotations.ProbeMethodName;
//@BTrace表示这个是一个btrace脚本
@BTrace
public class PrintArgSimple {

	//表示在哪个类的哪个方法在什么时候进行拦截
	@OnMethod(
	        clazz="com.example.lzh.jvmtest.controller.BTraceController",
	        method="arg1",
	        //表示一进方法就拦截
	        location=@Location(Kind.ENTRY)
	)
	/**
	 * @ProbeClassName 拦截的类名
	 * @ProbeMethodName 拦截的方法名
	 * AnyType[] 拦截的参数名
	 */
	public static void anyRead(@ProbeClassName String pcn, @ProbeMethodName String pmn, AnyType[] args) {
		BTraceUtils.printArray(args);
		BTraceUtils.println(pcn+","+pmn);
		BTraceUtils.println();
    }
}
