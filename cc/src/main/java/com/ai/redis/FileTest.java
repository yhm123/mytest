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
     * @Description: TODO(杩欓噷鐢ㄤ竴鍙ヨ瘽鎻忚堪杩欎釜鏂规硶鐨勪綔鐢�
     * @Author: Administrator
     * @Since: 2014-11-28涓嬪崍02:53:54
     * @param args
     * @throws IOException
     */
    public static void main(String[] args)
        throws Exception
    {
        FileTest test = new FileTest();
        Person p1 = test.new Person();
        p1.setAge(5);
        p1.setGrade(6);
        Person p2 = test.new Person();
        p2.setAge(8);
        p2.setGrade(3);
        Person p3 = test.new Person();
        p3.setAge(4);
        p3.setGrade(7);
        List<Person> list = new ArrayList<Person>();
        list.add(p1);
        list.add(p2);
        list.add(p3);
        for (int i = 0, len = list.size(); i < len; i++)
        {
            System.out.println(list.get(i));
        }
        // use the native TimSort in JDK 7
        Collections.sort(list, new Compare());
        for (int i = 0, len = list.size(); i < len; i++)
        {
            System.out.println(list.get(i));
        }
        // List<String> lines = FileUtils.readLines(new File("D:\\test\\0-0-accountdeposit.dat"));
        // FileUtils.writeLines(new File("D:\\test\\b.txt"), "GBK", lines, true);
        // for (String str : lines)
        // {
        // FileUtils.writeStringToFile(new File("D:\\test\\b.txt"), str, "GBK", true);//鍙湁涓�璁板綍
        // }
    }
    
    class Person
    {
        private int age;
        
        private int grade;
        
        public int getAge()
        {
            return age;
        }
        
        public void setAge(int age)
        {
            this.age = age;
        }
        
        public int getGrade()
        {
            return grade;
        }
        
        public void setGrade(int grade)
        {
            this.grade = grade;
        }
        
        @Override
        public String toString()
        {
            return "age=" + age + ";grade=" + grade;
        }
    }
    
    static class Compare implements Comparator<Object>
    {
        @Override
        public int compare(Object o1, Object o2)
        {
            Person p1 = (Person)o1;
            Person p2 = (Person)o2;
            if (p1.getAge() < p2.getAge() && p1.getGrade() < p2.getGrade())
            {
                return -1;
            }
            else if (p1.getAge() > p2.getAge() && p1.getGrade() > p2.getGrade())
            {
                return 1;
            }
            else
            {
                return 0;
            }
        }
    }
}
