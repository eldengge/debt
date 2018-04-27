package com.nsm.debt.entities;

import org.apache.log4j.Logger;
import org.aspectj.lang.ProceedingJoinPoint;;

public class Log {
	private static final Logger LOGGER=Logger.getLogger(Log.class);
	
	public Object aroudMethod(ProceedingJoinPoint pjp) {
		String methodName = pjp.getSignature().getName();
		Object result=null;
		Object[] args = pjp.getArgs();
		try {
			LOGGER.info("The method"+methodName+"begin with");
			for (Object object : args) {
				System.out.print(object);
			}
			System.out.println();
			result = pjp.proceed();
			LOGGER.info("The method"+methodName+"end with"+result);
		} catch (Throwable e) {
			// TODO: handle exception
			LOGGER.info("The method "+methodName+" throw "+e);
		}finally {
			LOGGER.info("The method"+methodName+"ends");
		}
		return result;
	}
}
