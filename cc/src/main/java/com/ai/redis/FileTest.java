package com.ai.redis;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class FileTest
{
    
    /**
     * @Title: main
     * @Description: TODO(这里用一句话描述这个方法的作用)
     * @Author: Administrator
     * @Since: 2014-11-28下午02:53:54
     * @param args
     * @throws IOException
     */
    public static void main(String[] args)
        throws Exception
    {
        int[] sample = new int[] {0, 1, 2, 3, 4, 5, 6, 7, 8, -6};
        List<Integer> list = new ArrayList<Integer>();
        for (int i : sample)
            list.add(i);
        // use the native TimSort in JDK 7
        Collections.sort(list, new Comparator<Integer>()
        {
            @Override
            public int compare(Integer o1, Integer o2)
            {
                // miss the o1 = o2 case on purpose
                return o1 > o2 ? 1 : o1 == o2 ? 0 : -1;
            }
        });
        
        // List<String> lines = FileUtils.readLines(new File("D:\\test\\0-0-accountdeposit.dat"));
        // FileUtils.writeLines(new File("D:\\test\\b.txt"), "GBK", lines, true);
        // for (String str : lines)
        // {
        // FileUtils.writeStringToFile(new File("D:\\test\\b.txt"), str, "GBK", true);//只有一行记录
        // }
    }
}
