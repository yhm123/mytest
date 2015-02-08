package com.ai.redis;

import org.apache.commons.lang3.RandomUtils;

/**
 * @version $Id$
 */
public class VolatileTest extends Thread
{
    private static int n = 0;
    
    private static String sync = "";
    
    private static char ch = 'A';
    
    private String methodType = "";
    
    private static VolatileTest volatileTest = null;
    
    VolatileTest(String str)
    {
        this.methodType = str;
    }
    
    public static VolatileTest getVolatileTest()
    {
        if (volatileTest == null)
        {
            volatileTest = new VolatileTest("");
        }
        return volatileTest;
    }
    
    private static void method(String str)
    {
        synchronized (sync)
        {
            sync = str;
        }
    }
    
    public void method1(String str)
    {
        method("method1");
    }
    
    public static void staticMethod1(String str)
    {
        method("staticmethod");
    }
    
    @Override
    public void run()
    {
        // inc();
        if (methodType.equalsIgnoreCase("staticmethod"))
        {
            staticMethod1("staticmethod");
        }
        else
        {
            method1("method1");
        }
        // n++;
        try
        {
            sleep(3);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
    
    synchronized void inc()
    {
        n++;
    }
    
    public static void main(String[] args)
        throws Exception
    {
        System.out.println(11 + "" + RandomUtils.nextInt(100000, 999999));
        VolatileTest t1 = new VolatileTest("staticmethod");
        VolatileTest t2 = new VolatileTest("method1");
        t1.start();
        t2.start();
        // t2.join();
        System.out.println(sync);
        // new VolatileTest().volatileTest();
    }
    
    void volatileTest()
        throws InterruptedException
    {
        VolatileTest threads[] = new VolatileTest[100];
        for (int i = 0; i < threads.length; i++)
        {
            // 建立100个线程
            threads[i] = new VolatileTest("");
        }
        System.out.println(" n1= " + n);
        System.out.println(" n2= " + n);
        for (int i = 0; i < threads.length; i++)
        {
            // 运行刚才建立的100个线程
            threads[i].start();
        }
        System.out.println(" n3= " + n);
        System.out.println(" n4= " + n);
        for (int i = 0; i < threads.length; i++)
        {
            // 100个线程都执行完后继续
            threads[i].join();
        }
        System.out.println(" n5= " + n);
        System.out.println(" n6= " + n);
    }
    
    class MultiThread extends Thread
    {
        @Override
        public void run()
        {
            inc();
        }
    }
}
