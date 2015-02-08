package com.ai.redis;

import java.lang.reflect.Method;

public class CachedMethod
{
    public Method setId;
    
    public Method setCode;
    
    public Method setName;
    
    {
        try
        {
            setId = Bean.class.getDeclaredMethod("setId", int.class);
            setCode = Bean.class.getDeclaredMethod("setCode", Integer.class);
            setName = Bean.class.getDeclaredMethod("setName", String.class);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
