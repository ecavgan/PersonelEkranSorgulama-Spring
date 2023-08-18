package com.ekran.personel.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PersonelAspect {
	@After("execution(* com.ekran.personel.service.PersonelService.updatePersonel(..))")
	public void afterUpdatePersonel(JoinPoint joinPoint)
	{
		System.out.println(joinPoint.getArgs()[0]);
		System.out.println("!!!!!!!!!!!!");
	}
}
