package com.ai.redis;

import org.apache.commons.beanutils.PropertyUtils;

public class CglibReflect
{
    private int PvpnTag;
    
    /**
     * @Title: main
     * @Description: 两种反射方法的性能比较
     * @Author: Administrator
     * @Since: 2014-12-18上午01:03:09
     * @param args
     * @throws Exception
     */
    public static void main(String[] args)
        throws Exception
    {
        System.out.println("P_VPN".matches("^[A_Z]_"));
        long start = System.currentTimeMillis();
        CglibReflect obj = new CglibReflect();
        String str = "";
        for (int i = 0; i < 100000000; i++)
        {
            PropertyUtils.setSimpleProperty(obj, "pVpnTag", 33);
            // str = String.valueOf(PropertyUtils.getSimpleProperty(obj, "PVpnTag"));
        }
        System.out.printf("use %d mills,setFirstName=%s", System.currentTimeMillis() - start, obj.PvpnTag);
    }
    
    public int getPVpnTag()
    {
        return 123;
    }
    
    public void setpVpnTag(int name)
    {
        this.PvpnTag = name;
    }
}
