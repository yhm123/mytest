package com.ai.redis;

import java.util.ArrayList;
import java.util.List;

public class User
{
    private String id;
    
    private String name;
    
    private static final String ABC = "cc";
    
    public String getId()
    {
        return id;
    }
    
    public void setId(String id)
    {
        this.id = id;
    }
    
    public String getName()
    {
        return name;
    }
    
    public void setName(String name)
    {
        this.name = name;
    }
    
    public User(String id, String name)
    {
        super();
        this.id = id;
        this.name = name;
    }
    
    static
    {
        System.out.println("static code");
    }
    
    public static void main(String[] args)
    {
    }
    
    void addObj()
    {
        List<User> list = new ArrayList<User>();
        for (int i = 1; i < 10000; i++)
        {
            User o = new User(i + "", System.currentTimeMillis() + "");
            list.add(o);
        }
    }
}
