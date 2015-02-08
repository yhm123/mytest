package com.ai.redis;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.Vector;

import org.apache.commons.lang3.RandomUtils;

public class PressureTest implements Runnable
{
    private static ThreadLocal<DateFormat> threadLocal = new ThreadLocal<DateFormat>();
    
    private static final String date_format = "yyyy-MM-dd HH:mm:ss";
    
    private static Map<String, String> map = null;
    
    private final long b = RandomUtils.nextLong(100000000, 999999999);
    
    private int stackLength = 1;
    
    private final LockTest lock = new LockTest();
    
    /**
     * 
     * @Title: stackLeak
     * @Description: 虚拟机栈溢出，-Xss128k
     * @Author: Administrator
     * @Since: 2015-1-21上午10:52:42
     * @param:
     * @return void
     */
    public void stackLeak()
    {
        stackLength++;
        stackLeak();
    }
    
    /**
     * 
     * @Title: permGenGC
     * @Description: 方法区内存溢出异常，-XX:PermSize=128M
     * @Author: Administrator
     * @Since: 2015-1-21下午04:13:36
     * @param:
     * @return void
     */
    public void permGenGC()
    {
        for (int i = 0, len = Integer.MAX_VALUE; i < len; i++)
        {
            String t = String.valueOf(i).intern();
        }
    }
    
    /**
     * 
     * @Title: heapOver
     * @Description: 堆内存溢出异常，-Xmx5M
     * @Author: Administrator
     * @Since: 2015-1-21下午04:13:18
     * @param:
     * @return void
     */
    public void heapOver()
    {
        Vector<byte[]> v = new Vector<byte[]>(10);
        for (int i = 0; i < 10; i++)
        {
            byte[] content = new byte[1024 * 1024];
            v.add(content);
            System.out.println(i + " M is allocated.");
        }
        System.out.println("Xmx: " + Runtime.getRuntime().maxMemory() / 1024L / 1024L + " M.");
    }
    
    /**
     * @Title: main
     * @Description: test
     * @Author: Administrator
     * @Since: 2015-1-3下午10:44:19
     * @param args
     * @throws Throwable
     */
    public static void main(String[] args)
        throws Throwable
    {
        multiThread();
        // PressureTest test = new PressureTest();
        // test.heapOver();
    }
    
    public static String replaceByToken(String srcStr, String org, String ob)
    {
        StringTokenizer st = new StringTokenizer(srcStr);
        StringBuilder newString = new StringBuilder(50);
        int index = 0;
        while (st.hasMoreTokens())
        {
            String str = st.nextToken(org);
            if (index == 0)
            {
                newString.append(str);
            }
            newString.append(firstCharacterToUpper(str));
        }
        return newString.length() != 0 ? newString.toString() : "";
    }
    
    public static String replaceUnderlineAndfirstToUpper(String srcStr, String org, String ob)
    {
        int first = 0;
        int len = org.length();
        StringBuilder newString = new StringBuilder(50);
        while (srcStr.indexOf(org) != -1)
        {
            first = srcStr.indexOf(org);
            newString.append(srcStr.substring(0, first)).append(ob);
            srcStr = srcStr.substring(first + len);
            srcStr = firstCharacterToUpper(srcStr);
        }
        newString.append(srcStr);
        return newString.length() != 0 ? newString.toString() : "";
    }
    
    public static String firstCharacterToUpper(String srcStr)
    {
        return Character.toUpperCase(srcStr.charAt(0)) + srcStr.substring(1);
    }
    
    @Override
    public void run()
    {
        // long start = System.currentTimeMillis();
        for (int i = 0; i < 10000001; i++)
        {
            if ((i % 2) == 0)
            {
                try
                {
                    System.out.println("put");
                    lock.put(i);
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
            else
            {
                try
                {
                    System.out.println(lock.take());
                }
                catch (InterruptedException e)
                {
                    e.printStackTrace();
                }
            }
            // StringBuilder sb = new StringBuilder(25);
            // long a = RandomUtils.nextLong(100000000, 999999999);
            // if (b == a)
            // {
            // System.out.println(a);
            // }
            // String a = sb.append(1233333333).append(RandomUtils.nextInt(100000, 999999)).toString();
            // if (i == 10000000)
            // {
            // long end = System.currentTimeMillis();
            // System.out.printf("uses %d mills.\n", (end - start));
            // }
        }
    }
    
    static Map<String, String> addObjByMap()
    {
        Map<String, String> map = new HashMap<String, String>(2000);
        for (int i = 0; i < 2000; i++)
        {
            map.put("" + i, "aa");
        }
        return map;
    }
    
    static List<String> addObjByList()
    {
        List<String> list = new ArrayList<String>(2000);
        for (int i = 0; i < 2000; i++)
        {
            list.add("aa");
        }
        return list;
    }
    
    static Vector<String> addObjByVector()
    {
        Vector<String> list = new Vector<String>(2000);
        for (int i = 0; i < 2000; i++)
        {
            list.add("bb");
        }
        return list;
    }
    
    int getNum(String str, char ch)
    {
        int count = 0;
        for (int i = 0; i < str.length(); i++)
        {
            if (str.charAt(i) == ch)
            {
                count++;
            }
        }
        return ++count;
    }
    
    String[] getStrs(String str, char ch)
    {
        int index = 0;
        int fromIndex = 0;
        int length = getNum(str, ch);
        String[] strs = new String[length];
        int i = 0;
        while ((index = str.indexOf(ch, fromIndex)) >= 0)
        {
            strs[i] = str.substring(fromIndex, index);
            fromIndex = ++index;
            i++;
            if (fromIndex == str.lastIndexOf(ch) + 1)
            {
                strs[i] = str.substring(fromIndex);
            }
        }
        return strs;
    }
    
    static void multiThread()
    {
        Thread t = new Thread(new PressureTest());
        t.start();
        
        Thread t1 = new Thread(new PressureTest());
        t1.start();
        
        Thread t2 = new Thread(new PressureTest());
        t2.start();
        
        Thread t3 = new Thread(new PressureTest());
        t3.start();
        
        Thread t4 = new Thread(new PressureTest());
        t4.start();
    }
    
    DateFormat testThreadLocalTest()
    {
        DateFormat df = threadLocal.get();
        if (df == null)
        {
            df = new SimpleDateFormat(date_format);
            threadLocal.set(df);
        }
        return df;
    }
    
}
