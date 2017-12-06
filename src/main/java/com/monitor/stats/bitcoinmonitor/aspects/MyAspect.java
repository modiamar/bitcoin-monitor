package com.monitor.stats.bitcoinmonitor.aspects;

import java.util.Arrays;
import java.util.Date;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;


@Aspect
@Component
public class MyAspect {
	// This is a pointcut
	@Before("execution(* HiByeService.*(..)")
	public void before(JoinPoint joinPoint){
		System.out.println("Before");
		// get the signature of particular method that is called from HiByeService
		// will also print whatever arguments there were
		System.out.println(joinPoint.getSignature().getName());
		System.out.println(Arrays.toString(joinPoint.getArgs()));
	}

	@AfterReturning(pointcut = "execution(* HiByeService.*(..))", returning = "result")
	public void after(JoinPoint joinPoint, Object result){
		System.out.println("After ");
		System.out.println(joinPoint.getSignature().getName());
		System.out.println("result is " + result);
	}
	
	@Around(value = "execution(* HiByeService.*(..))")
	public void around(ProceedingJoinPoint joinPoint) throws Throwable{
		//proceeding join point allows us to proceed on a join point useful in around
		long startTime = new Date().getTime();
		//this method is executed
		Object result = joinPoint.proceed();
		long endTime = new Date().getTime();
		System.out.println("Execution Time - " + (endTime - startTime));
	}
}
