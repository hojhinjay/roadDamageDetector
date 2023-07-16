package com.example.roaddamage1;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.util.Observable;

public class DynamicProxyHandler implements InvocationHandler {

    private Object realObject;

    public DynamicProxyHandler(Object realObject) {
        this.realObject = realObject;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("proxy do");
        return method.invoke(realObject,args);
    }
}
