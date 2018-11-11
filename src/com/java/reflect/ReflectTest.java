package com.java.reflect;

import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.lang.reflect.*;
import java.math.BigDecimal;
import java.util.Properties;

/**
 * Created by pc on 2018/8/25.
 */
public class ReflectTest {
    @Test
    public  void test6() throws Exception {
        Type type = new Man().getClass().getGenericSuperclass();
        ParameterizedType pt = (ParameterizedType) type;
        Type[] ts=pt.getActualTypeArguments();
        System.out.println(((Class)ts[0]).getName());
        Class<Person> c=Person.class;
        System.out.println(c);
        Person o= test7(c);
        System.out.println(o);
    }



    public <T> T test7(Class<T> tClass) throws Exception {
        T t=null;
        t=tClass.newInstance();
        return t;
    }
    @Test
    public void test1() throws Exception {
        //操作public类型属性
        Class clzz=Person.class;
        Person p= (Person) clzz.newInstance();
        Field f1=clzz.getField("name");
        f1.set(p,"leijun");
        System.out.println(p);
        System.out.println(p.getName());
        System.out.println(f1.get(p));

        //操作private类型属性
        Field f2= clzz.getDeclaredField("age");
        f2.setAccessible(true);
        f2.set(p,20);
        System.out.println(p);

        //调用无参方法
        Method m1=clzz.getMethod("say");
        m1.invoke(p);
        //调用有参方法
        Method m2=clzz.getMethod("eat",String.class);
        m2.invoke(p,"malantang");
        String res= (String) m2.invoke(p,"tofu");
        System.out.println(res);
        //调用私有方法
        Method m3=clzz.getDeclaredMethod("friends",String.class,String.class);
        m3.setAccessible(true);
        m3.invoke(p,"任正非","柳传志");
    }
    @Test
    public void test3() throws Exception {
        Class clzz=Person.class;
        Object obj=clzz.newInstance();
        System.out.println(clzz.getName());

        Person person=new Person();
        Class clzz1=person.getClass();
        Object obj1=clzz1.newInstance();
        System.out.println(clzz1.getName());

        String str="com.java.reflect.Person";
        Class clzz2=Class.forName(str);
        Object obj2=clzz2.newInstance();
        System.out.println(clzz2.getName());

        System.out.println(this.getClass().getName());
        ClassLoader classLoader=this.getClass().getClassLoader();
        Class clzz3=classLoader.loadClass(str);
        Object obj3=clzz3.newInstance();
        System.out.println(clzz3.getName());


        String str1="resource/file.properties";
        /*ClassLoader classLoader1=this.getClass().getClassLoader();
        InputStream fis=classLoader1.getResourceAsStream(str1);
        Properties properties=new Properties();
        properties.load(fis);
        System.out.println(properties.get("user"));*/

        File file=new File(str1);
        FileInputStream fileInputStream=new FileInputStream(file);
        Properties properties=new Properties();
        properties.load(fileInputStream);
        System.out.println(properties.get("pass"));
    }

    @Test
    public void test4() throws Exception {
        Class clzz = Man.class;
        Man man= (Man) clzz.newInstance();
        Field field=clzz.getField("sex");
        field.set(man,"男");
        System.out.println(field.get(man));

        System.out.println(clzz.getName());
        System.out.println("------------------------1");
        //获取当前类及其父类的所有public属性
        Field[] fields=clzz.getFields();
        for (Field f:fields){
            System.out.println(f.getName());
            //获取属性的访问修饰符
            System.out.println(Modifier.toString(f.getModifiers()));
            System.out.println(f);
        }
        //获取当前类的所有属性，包括privete和public
        System.out.println("---------------------------2");
        Field[] fields1=clzz.getDeclaredFields();
        for (Field f:fields1){
            System.out.println(f.getName());
            System.out.println(Modifier.toString(f.getModifiers()));
            System.out.println(f);
        }
        System.out.println("========================");
        Method[] methods=clzz.getMethods();
        for (Method m:methods){
            System.out.println(m.getName());
            System.out.println("===========1");
            //获取方法的参数
            Class[] pt=m.getParameterTypes();
            for (Class c:pt)
                System.out.println(c.getName());
            System.out.println("===========2");
            System.out.println(m);
            //获取方法的返回参数
            Class c=m.getReturnType();
            System.out.println(c.getName());
        }
    }


    /**
     * 通过类的对象获取的class，再通过该class创建出该类的新对象，新对象没有原对象已设置的相关值
     * @throws Exception
     */
    @Test
    public void test5() throws Exception {
        Man man=new Man();
        man.setSex("nan");
        man.setSalary(new BigDecimal(1000000));
        Person person=man;
        person.setName("zhangsan");

        Class clz=person.getClass();
        Person m= (Person) clz.newInstance();
        System.out.println(m.toString());

        Field[] fields=clz.getFields();
        for (Field f:fields){
            System.out.println(f.get(m));
        }
        Method method=clz.getMethod("getSex");
        System.out.println(method.invoke(m));
        System.out.println("=====================");
        Method[] ms=clz.getMethods();
        /*for (Method method1:ms){
            System.out.println(method1.getName());
        }*/

        Class clzz=Person.class;
        Field[] fields1=clzz.getFields();
        for (Field f:fields1)
            System.out.println(f);
    }

    @Test
    public void test(){
        T1 t=new T2();
        t.say();
    }

}


class T1{
    public void say(){
        System.out.println("i am t1");
    }
}

class T2 extends T1{
    @Override
    public void say() {
        System.out.println("-------");
        super.say();
        System.out.println("=======");
        System.out.println("i am t2");
    }
}

