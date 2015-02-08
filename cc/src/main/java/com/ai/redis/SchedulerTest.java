package com.ai.redis;

import static org.quartz.JobBuilder.newJob;
import static org.quartz.SimpleScheduleBuilder.simpleSchedule;
import static org.quartz.TriggerBuilder.newTrigger;

import org.quartz.JobDetail;
import org.quartz.Scheduler;
import org.quartz.SchedulerException;
import org.quartz.Trigger;
import org.quartz.impl.StdSchedulerFactory;

public class SchedulerTest
{
    
    /**
     * @Title: main
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @Author: Administrator
     * @Since: 2014-11-27上午11:47:44
     * @param args
     * @throws SchedulerException
     */
    public static void main(String[] args)
        throws SchedulerException
    {
        Scheduler scheduler = StdSchedulerFactory.getDefaultScheduler();
        scheduler.start();
        
        JobDetail task1 = newJob(SumScheduler.class).withIdentity("myJob", "group1").build();
        JobDetail task2 = newJob(MinusScheduler.class).withIdentity("myJob", "group2").build();
        Trigger trigger1 =
            newTrigger().withIdentity("myTrigger1", "group1")
                .startNow()
                .withSchedule(simpleSchedule().withIntervalInMilliseconds(10).repeatForever())
                .build();
        
        Trigger trigger2 =
            newTrigger().withIdentity("myTrigger2", "group2")
                .startNow()
                .withSchedule(simpleSchedule().withIntervalInMilliseconds(10).repeatForever())
                .build();
        
        scheduler.scheduleJob(task1, trigger1);
        scheduler.scheduleJob(task2, trigger2);
    }
}
