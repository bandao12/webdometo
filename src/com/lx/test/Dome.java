package com.lx.test;/**
 * @Author zhangliao
 * @Date 2018-11-23
 */

import com.lx.bean.Person;
import com.lx.bean.Student;

import javax.swing.*;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 *@author xigua

 */
public class Dome {
   private  final static String NAME="李四";
   public void test(){
       new Thread(new Runnable() {
           @Override
           public void run() {
               System.out.println("11111");
           }
       }).start();
       new Thread(()-> {System.out.println("我是另外一个线程");
           System.out.println("222222");}).start();

       List list=new ArrayList();
       list.add(1);
       list.add(2);
       list.add(31);
       list.forEach(t -> System.out.println(t));


       Runnable runnable=new Runnable() {
           @Override
           public void run() {

           }
       };
       Runnable runnable1=() -> System.out.println("111");
       runnable1.run();

   }


    public static void main(String[] args) {
      /* String[] list={"bbb","aaa","bi","ai"};
       for (int i=0;i<list.length;i++){
           System.out.println(list[i]);
       }
       System.out.println("排序前=====================");
       Arrays.sort(list,(String a,String b) -> (a.compareTo(b)));
       System.out.println("排序后=====================");
       for (int i=0;i<list.length;i++){
            System.out.println(list[i]);
       }*/
       /*List<Integer> list=new ArrayList();
       list.add(100);
       list.add(200);
       list.add(300);
       System.out.println("list ================");
       list.forEach(System.out::println);
       List list1=list.stream().map(a-> a+.12*a).collect(Collectors.toList());
       System.out.println("list1 ==============");
       list1.forEach(System.out::println);
       List list2=list.stream().filter(a -> a!=null && a>100).map(b -> b+.30*b).collect(Collectors.toList());
       System.out.println("list2 ==============");
       list2.forEach(a -> System.out.println(a));
       list.stream().filter(a -> (a!=null && a>200)).forEach(System.out::println);*/
       List<Student> list=new ArrayList();
       Student student=new Student();
       student.setId(1);
       student.setName("张三");
       student.setSex("M");
       Student student1=new Student();
       student1.setId(2);
       student1.setName("李四");
       student1.setSex("M");
       Student student2=new Student();
       student2.setId(3);
       student2.setName("小白");
       student2.setSex("S");
       list.add(student);
       list.add(student1);
       list.add(student2);
       List<Student> list1=list.stream().filter(t -> t!=null && t.getId()!=2).collect(Collectors.toList());
       List<String> list2=list.stream().map(t ->t.getSex()).collect(Collectors.toList());
       list2.forEach(t -> System.out.println(t));
       list1.forEach(t -> System.out.println(t.toString()));
       List<Person> personList=list.stream().map(t ->{
           Person person=new Person();
           person.setId(t.getId());
           person.setName(t.getName());
           if(NAME.equals(t.getName())){
               person.setSex("MS");
           }
           return person;
       }).collect(Collectors.toList());
       personList.forEach(t -> System.out.println(t.toString()));
       List<Student> list3=list.stream().filter(t -> t!=null && NAME.equals(t.getName())).map(t ->getStu(t.getName(),list)).collect(Collectors.toList());
       list3.forEach(t -> System.out.println("11111"+t.toString()));
       System.out.println(list3.size());
    }

    public static void  get(List list, Predicate predicate){
        list.stream().filter(t -> predicate.test(t)).forEach(t -> {
            System.out.println(t);
        });
    }
    public static String dome(){
        return null;
    }
    public static Student getStu(String name,List<Student> list){
       Student student1=null;
       for(Student student:list){
           if(NAME.equals(student.getName())){
               student1=new Student();
               student1.setId(student.getId());
               student1.setSex(student.getSex());
               student1.setName(student.getName());
           }
       }
       return student1;
    }
}
