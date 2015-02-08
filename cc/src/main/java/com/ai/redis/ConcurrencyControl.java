package com.ai.redis;

public class ConcurrencyControl
{
    boolean printMsg()
        throws Exception
    {
        boolean finish = false;
        try
        {
            System.out.println("finish to printMsg.");
            Thread.sleep(3000);
            finish = true;
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
        return finish;
    }
}
