package com.nevergetme.others;

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Constructor;

@Repeatable(Annos.class)
@interface Anno{}
@Retention(value= RetentionPolicy.RUNTIME)
@interface Annos{
    Anno[] value();
}
@SuppressWarnings(value="unchecked")
@Deprecated
@Anno
@Anno
public class ClassTest {
    private ClassTest(){}
    public ClassTest(String name){
        System.out.println("执行有参数的构造器");
    }
    public void info(){
        System.out.println("执行无参数的info方法");
    }
    public void info(String str){
        System.out.println("执行有参数的info方法");
    }
    class Inner{

    }
    public static void main(String[] args){
        Class<ClassTest> clazz=ClassTest.class;
        Constructor[] ctors=clazz.getDeclaredConstructors();
        System.out.println("ClassTest的全部构造器如下所示：");
        for(Constructor c:ctors){
            System.out.println(c);
        }
        Constructor[] publicCtors=clazz.getConstructors();
        System.out.println("ClassTest的全部public构造器如下所示：");
        for(Constructor c:publicCtors){
            System.out.println(c);
        }

    }
}
