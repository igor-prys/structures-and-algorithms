package org.example;

import org.example.structures.CustomLinkedList;

import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        CustomLinkedList<String> linkedList = new CustomLinkedList<>();
        linkedList.add("Hello");
        linkedList.add("world");
        linkedList.add("!");
        Iterator iterator = linkedList.iterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
        for (String s : linkedList) {
            System.out.print(s + " ");
        }
    }
}