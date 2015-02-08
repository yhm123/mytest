package com.ai.redis;

/**
 * 
 * @ClassName: RedisConnection
 * @Title:
 * @Description:TODO(这里用一句话描述这个类的作用)
 * @Author:Administrator
 * @Since:2014-11-25下午08:13:23
 * @Version:1.0
 */
public class RedisConnection
{
    private static final String HOST = "10.173.228.35";
    
    private static final int PORT = 6390;
    
    private static final int TIME_OUT = 60000;
    
    public static void main(String[] args)
        throws Exception
    {
        // JedisPoolConfig jpConfig = new JedisPoolConfig();
        // jpConfig.setMaxIdle(1);
        // jpConfig.setMinIdle(0);
        // jpConfig.setMaxWaitMillis(100000);
        // JedisPool jp = new JedisPool(jpConfig, HOST, PORT, TIME_OUT);
        // Jedis jedis = jp.getResource();
        // System.out.println(jedis.hset("abc", "def", "ddd"));
        // jedis.close();
        try
        {
            int a = 9;
            int b = 0;
            System.out.println(a / b);
        }
        catch (Exception e)
        {
            System.out.println("catch");
        }
        System.out.println("a");
    }
    
    static String getStr(String str)
    {
        int len = str.length();
        return "abc";
    }
    
}
