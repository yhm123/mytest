package com.ai.redis;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public final class Job implements Callable<Boolean>, Executor
{
    private final ConcurrencyControl control = new ConcurrencyControl();
    
    private boolean finish = true;
    
    public static void main(String[] args)
        throws Exception
    {
        // multiThread();
        System.out.println("7111011829006870+2+1+20150201+2".substring(4, 6));
    }
    
    static void multiThread()
        throws Exception
    {
        BlockingQueue<Runnable> queue = new LinkedBlockingQueue<Runnable>();
        ExecutorService service = new ThreadPoolExecutor(3, 5, 10, TimeUnit.MILLISECONDS, queue);
        List<Future<Boolean>> results = new ArrayList<Future<Boolean>>();
        for (int i = 0; i < 10; i++)
        {
            Future<Boolean> job = service.submit(new Job());
            results.add(job);
        }
        
        for (int i = 0; i < 15; i++)
        {
            final int tmpint = i;
            new Job().execute(new Runnable()
            {
                @Override
                public void run()
                {
                    try
                    {
                        System.out.println(tmpint + "Hello World");
                        Thread.sleep(1000);
                    }
                    catch (InterruptedException e)
                    {
                    }
                }
            });
        }
        boolean result = true;
        for (int i = 0; i < results.size(); i++)
        {
            result = results.get(i).get().booleanValue();
            if (!result)
            {
                result = false;
                break;
            }
        }
        if (result)
        {
            try
            {
                service.shutdown();
                if (!service.awaitTermination(6000, TimeUnit.MILLISECONDS))
                {
                    service.shutdownNow();
                }
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
    }
    
    @Override
    public void execute(Runnable command)
    {
        System.out.println("Hello World");
    }
    
    static void timeCost()
    {
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SSS");
        Calendar end = Calendar.getInstance();
        end.set(Calendar.YEAR, 2015);
        end.set(Calendar.MONTH, 1);
        end.set(Calendar.DAY_OF_MONTH, 1);
        end.set(Calendar.HOUR_OF_DAY, 11);
        end.set(Calendar.MINUTE, 10);
        end.set(Calendar.SECOND, 38);
        
        Calendar start = Calendar.getInstance();
        start.set(Calendar.YEAR, 2015);
        start.set(Calendar.MONTH, 1);
        start.set(Calendar.DAY_OF_MONTH, 1);
        start.set(Calendar.HOUR_OF_DAY, 10);
        start.set(Calendar.MINUTE, 42);
        start.set(Calendar.SECOND, 16);
        System.out.printf("startDate=%s,endDate=%s,use time is %d seconds\n",
            format.format(start.getTime()),
            format.format(end.getTime()),
            (end.getTimeInMillis() - start.getTimeInMillis()) / 1000);
    }
    
    void setNum()
    {
        System.out.println("setNum");
    }
    
    public boolean isFinish()
    {
        return finish;
    }
    
    public void setFinish(boolean finish)
    {
        this.finish = finish;
    }
    
    @Override
    public Boolean call()
        throws Exception
    {
        try
        {
            finish = control.printMsg();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return finish;
    }
}