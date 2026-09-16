package com.example.AopProxy.aspect;

import org.aspectj.lang.annotation.Pointcut;

public class ApplicationPointCuts {

    @Pointcut("within(com.example.AopProxy.controller..*)")
    public void controllerLayer() {
        // empty body
    }

    @Pointcut("within(com.example.AopProxy.service..*)")
    public void serviceLayer() {
        // empty body
    }

    @Pointcut("execution(public * * (..))")
    public void publicMethod() {
        // empty body
    }

    @Pointcut("serviceLayer() && publicMethod()")
    public void publicServiceMethod() {
        // empty body
    }

    @Pointcut("execution(* *.get* (..))")
    public void getterMethod() {
        // empty body
    }
}
