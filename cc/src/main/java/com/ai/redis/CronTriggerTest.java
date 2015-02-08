package com.ai.redis;

import java.util.Date;
import java.util.TimeZone;

import org.quartz.CronTrigger;
import org.quartz.JobDataMap;
import org.quartz.JobKey;
import org.quartz.ScheduleBuilder;
import org.quartz.Trigger;
import org.quartz.TriggerBuilder;
import org.quartz.TriggerKey;

public class CronTriggerTest implements CronTrigger
{
    private CronTriggerTest cronTriggerTest = null;
    
    public CronTriggerTest()
    {
        if (cronTriggerTest == null)
        {
            cronTriggerTest = new CronTriggerTest();
        }
    }
    
    /**
     * @Fields serialVersionUID : 1L
     */
    private static final long serialVersionUID = 1L;
    
    public TriggerKey getKey()
    {
        return cronTriggerTest.getKey();
    }
    
    public JobKey getJobKey()
    {
        return cronTriggerTest.getJobKey();
    }
    
    public String getDescription()
    {
        return cronTriggerTest.getDescription();
    }
    
    public String getCalendarName()
    {
        return cronTriggerTest.getCalendarName();
    }
    
    public JobDataMap getJobDataMap()
    {
        return cronTriggerTest.getJobDataMap();
    }
    
    public int getPriority()
    {
        return cronTriggerTest.getPriority();
    }
    
    public boolean mayFireAgain()
    {
        return cronTriggerTest.mayFireAgain();
    }
    
    public Date getStartTime()
    {
        return cronTriggerTest.getStartTime();
    }
    
    public Date getEndTime()
    {
        return cronTriggerTest.getEndTime();
    }
    
    public Date getNextFireTime()
    {
        return cronTriggerTest.getNextFireTime();
    }
    
    public Date getPreviousFireTime()
    {
        return cronTriggerTest.getPreviousFireTime();
    }
    
    public Date getFireTimeAfter(Date afterTime)
    {
        return cronTriggerTest.getFireTimeAfter(afterTime);
    }
    
    public Date getFinalFireTime()
    {
        return cronTriggerTest.getFinalFireTime();
    }
    
    public int getMisfireInstruction()
    {
        return cronTriggerTest.getMisfireInstruction();
    }
    
    public ScheduleBuilder<? extends Trigger> getScheduleBuilder()
    {
        return null;
    }
    
    public int compareTo(Trigger other)
    {
        return cronTriggerTest.compareTo(other);
    }
    
    public String getCronExpression()
    {
        return cronTriggerTest.getCronExpression();
    }
    
    public TimeZone getTimeZone()
    {
        return cronTriggerTest.getTimeZone();
    }
    
    public String getExpressionSummary()
    {
        return cronTriggerTest.getExpressionSummary();
    }
    
    public TriggerBuilder<CronTrigger> getTriggerBuilder()
    {
        return cronTriggerTest.getTriggerBuilder();
    }
    
}
