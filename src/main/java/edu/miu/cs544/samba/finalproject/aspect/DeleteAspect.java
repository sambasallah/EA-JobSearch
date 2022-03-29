package edu.miu.cs544.samba.finalproject.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Aspect
@Configuration
public class DeleteAspect {

    private static final Logger logger = LoggerFactory.getLogger(DeleteAspect.class);

    @Before("execution(* edu.miu.cs544.samba.finalproject.repository.*.delete(..))")
    public void before(JoinPoint joinPoint){
        //Advice
       logger.info("Deleted: " + joinPoint.getSignature().getDeclaringTypeName() + ", Method: " + joinPoint.getSignature().getName());
    }
}
