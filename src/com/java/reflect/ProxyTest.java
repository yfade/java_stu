package com.java.reflect;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by pc on 2018/8/28.
 */

interface Club{
    String playGame(String name);
}
//被代理类
class RNG implements Club{
    @Override
    public String playGame(String name) {
        System.out.println("-------"+name);
        return name;
    }
}

class ProxyF implements InvocationHandler{
    Object obj;//被代理类对象

    //传入被代理对象，返回一个代理对象
    public Object blind(Object obj){
        this.obj=obj;
        //被代理对象的类加载器，被代理对象实现的接口，ProxyF的对象
        return Proxy.newProxyInstance(obj.getClass().getClassLoader(),obj.getClass().getInterfaces(),this);
    }

    //当通过代理类的对象调用重写方法时，转为调用此方法
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("invoke before------");
        Object object=method.invoke(obj,args);
        System.out.println("invoke after----");
        return object;
    }
}

public class ProxyTest {
    @Test
    public void test(){
        //被代理对象
        RNG rng=new RNG();
        //创建一个实现了InvocationHandler接口类的对象
        ProxyF proxyF=new ProxyF();
        //动态返回一个实现了代理类实现的接口的类的代理类对象
        Object object=proxyF.blind(rng);
        //此时club就是代理类的对象
        Club club=(Club)object;
        String s = club.playGame("i am rng");
        System.out.println(s);
    }
}
