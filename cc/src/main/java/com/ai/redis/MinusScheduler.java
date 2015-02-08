package com.ai.redis;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class MinusScheduler implements Job
{
    public static final String NUM_EXECUTIONS = "NumExecutions";
    
    public static final String EXECUTION_DELAY = "ExecutionDelay";
    
    public MinusScheduler()
    {
    }
    
    @Override
    public void execute(JobExecutionContext context)
        throws JobExecutionException
    {
        System.out.println("get obj.");
        try
        {
            System.out.println(new LockTest().take());
        }
        catch (InterruptedException e)
        {
            e.printStackTrace();
        }
    }
    
}
