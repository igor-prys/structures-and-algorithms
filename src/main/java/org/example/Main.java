package org.example;

import org.example.structures.CustomLinkedList;

import java.util.LinkedList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        CustomLinkedList <Integer> list=new CustomLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(5);
        list.addByIndex(4,4);
        System.out.println(list);
        System.out.println(list.getCounter());
        System.out.println();

        List<Integer>list1=new LinkedList<>();
        list1.add(1);
        list1.add(2);
        list1.add(3);
        list1.add(5);
        list1.add(4,4);
        System.out.println(list1);
        System.out.println(list1.size());

    }
}