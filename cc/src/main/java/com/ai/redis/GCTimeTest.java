package com.ai.redis;

import java.util.HashMap;
import java.util.Map;

public class GCTimeTest
{
    static Map<Long, byte[]> map = new HashMap<Long, byte[]>();
    
    /**
     * @Title: main
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @Author: Administrator
     * @Since: 2015-1-22下午09:42:39
     * @param: @param args
     * @return void
     */
    public static void main(String[] args)
    {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++)
        {
            if (map.size() * 512 / 1024 / 1024 >= 500)
            {
                map.clear();
            }
            byte[] b1;
            for (int j = 0; j < 100; j++)
            {
                b1 = new byte[512];
                map.put(System.nanoTime(), b1);
            }
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start + " mills.");
    }
}
