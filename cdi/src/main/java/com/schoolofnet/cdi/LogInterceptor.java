package com.schoolofnet.cdi;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Interceptor
@Log
public class LogInterceptor {

	@AroundInvoke
	public Object intercept(InvocationContext context) throws Exception {
		System.out.println("Passing by interceptor...");
		
		return context.proceed();
	}
}
