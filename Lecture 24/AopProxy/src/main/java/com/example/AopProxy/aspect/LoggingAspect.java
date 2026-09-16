package com.example.AopProxy.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class LoggingAspect {

    @Pointcut("within(com.example.AopProxy.service..*)" +
            "&&" +
            "execution(public * * (..))")
    public void logPublicServiceMethod(){
            //empty body
    }

    //wildcards
    // com.example.AopProxy.service..* - means any subpackage inside the service package any subpackage or any class can be intercepted
   // @Before("execution(* com.example.AopProxy.service.StudentService.*(..))")
    //within designator
//    @Before("within(com.example.AopProxy.service.StudentService)")
//    public void logBeforeMethod(){
//        System.out.println("method intercepted");
//
//    }


    //bean designator
//    @Before("bean(studentService)")
//    public void logBeforeMethod(){
//        System.out.println("method intercepted");
//
//    }


//    @Before("within(com.example.AopProxy.service..*)" +
//            "&&" +
//            "execution(public * * (..))")
//    public void logBeforeMethod(){
//        System.out.println("method intercepted");
//
//    }

    //if we don't want to write again and again pointcut designation we can use pointcut method we create that already store the value
    @Before("logPublicServiceMethod()")
    public void logBeforeMethod(){
        System.out.println("method intercepted");

    }

    // execution designator
//    @Before("execution(com.example.AopProxy.dto.Student " +
//            "com.example.AopProxy.service.StudentService.createStudent(" +
//            "com.example.AopProxy.dto.Student)))")
//    public void logBeforeMethod2(){
//        System.out.println("method intercepted");
//
//    }
}


// there are three designator

//1. execution --method level
//2. within -- class level
//3. @annotation -- method level
//4. bean