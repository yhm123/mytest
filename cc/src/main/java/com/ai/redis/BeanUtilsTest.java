package com.ai.redis;

public class BeanUtilsTest
{
    
    public static void main(String[] args)
        throws Exception
    {
        System.out.println(A.VALUE);
    }
}

class A
{
    public static final int VALUE = 10;
    static
    {
        System.out.println("run parent static code.");
    }
}

class B extends A
{
    static
    {
        System.out.println("run child static code.");
    }
}