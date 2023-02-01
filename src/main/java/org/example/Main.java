package org.example;

import org.example.structures.CustomLinkedList;
import org.example.structures.JavaAlikeHashSet;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
//        CustomLinkedList <Integer> list=new CustomLinkedList<>();
//        list.add(1);
//        list.add(2);
//        list.add(3);
//        list.add(5);
//        list.addByIndex(3,4);
//        list.removeElement(4);
//        System.out.println(list);
//        System.out.println(list.getCounter());
//        System.out.println(list.contain(8));
//
//       // System.out.println("Value "+list.getValue(4));
//        System.out.println();
//
//        List<Integer>list1=new LinkedList<>();
//        list1.add(1);
//        list1.add(2);
//        list1.add(3);
//        list1.add(5);
//        list1.add(3,4);
//        list1.remove(4);
//        System.out.println(list1);
//        System.out.println(list1.size());
//        System.out.println();
//
//        Map<Integer,String>map=new HashMap<>();
//        map.put(1,"a");
//        map.put(2,null);
//        System.out.println(map.containsKey(3));
//        System.out.println(map.get(3));
        JavaAlikeHashSet<String>jahs=new JavaAlikeHashSet<>(15);
        jahs.add(null);
        jahs.add("bbbbb");
        System.out.println(jahs);
    }
}