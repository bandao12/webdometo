package com.lx.bean;/**
 * @Author zhangliao
 * @Date 2018-11-30
 */

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;

/**
 *@author xigua

 */
public class Person {
    public int id;
    public String name;
    public String sex;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                '}';
    }

    public static void main(String[] args) {
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM");
        try {
            Long time=sdf.parse("2018-03").getTime()-sdf.parse("2016-09").getTime();
            long days = time / (1000 * 60 * 60 * 24);
            //System.out.println((float) (days/30)/12);

        }catch (ParseException e){

        }
        Person person=new Person();
        person.setId(1);
        person.setSex("M");
        person.setName("张三");
        Person person1=new Person();
        person1.setId(2);
        person1.setSex("S");
        person1.setName("张三");
        List<Person> list=new ArrayList();
        list.add(person);
        list.add(person1);
        list.forEach(n -> System.out.println(n.toString()));
        Map<Integer,String> map=list.stream().collect(Collectors.toMap(Person::getId,Person::getName));
        for (int a:map.keySet()){
            System.out.println(map.get(a));
        }
        System.out.println("map"+map);
        Map<String,String> map1=list.stream().collect(Collectors.toMap(n-> n.getName(),n-> n.getSex(),(a,b) -> b));
        for (String a:map1.keySet()){
            System.out.println(map1.get(a));
        }
        System.out.println("map1"+map1);

    }
}
