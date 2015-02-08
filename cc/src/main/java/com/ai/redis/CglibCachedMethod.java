package com.ai.redis;

import net.sf.cglib.reflect.FastClass;
import net.sf.cglib.reflect.FastMethod;

public class CglibCachedMethod extends CachedMethod
{
    public FastMethod cglibSetId;
    
    public FastMethod cglibSetCode;
    
    public FastMethod cglibSetName;
    
    private FastClass cglibBeanClass = FastClass.create(Bean.class);
    
    {
        cglibSetId = cglibBeanClass.getMethod(setId);
        cglibSetCode = cglibBeanClass.getMethod(setCode);
        cglibSetName = cglibBeanClass.getMethod(setName);
    }
}
