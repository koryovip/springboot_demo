package com.example.demo._config.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Aspect
@Slf4j
public class LogAdvice {
    @Pointcut("@within(org.springframework.stereotype.Controller)")
    public void controller() {
    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.RequestMapping)")
    public void requestMapping() {
    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.GetMapping)")
    public void doGet() {
    }

    @Pointcut("@annotation(org.springframework.web.bind.annotation.PostMapping)")
    public void doPost() {
    }

    @Pointcut("execution(* com.example.spring..*.*(..))")
    public void anyProjectMethodExecution() {
    }

    @Around("doGet() || doPost()")
    public Object log(ProceedingJoinPoint pjp) throws Throwable {
        // System.out.println("■■■■■■ before");
        long start = System.currentTimeMillis();
        try {
            log.info("■■■■■■ before");
            Object retVal = pjp.proceed();
            log.info("■■■■■■ after");
            // System.out.println("■■■■■■ after");
            return retVal;
        } finally {
            log.info("cost {}", System.currentTimeMillis() - start);
        }
    }
}