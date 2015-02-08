package com.ai.redis;

import org.quartz.DisallowConcurrentExecution;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

@DisallowConcurrentExecution
public class SumScheduler implements Job
{
    public SumScheduler()
    {
    }
    
    @Override
    public void execute(JobExecutionContext context)
        throws JobExecutionException
    {
        System.out.println("put obj.");
        try
        {
            new LockTest().put(1);
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
    
}
