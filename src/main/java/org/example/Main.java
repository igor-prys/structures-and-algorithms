package org.example;

import org.example.structures.CustomLinkedList;
import org.example.structures.Iterator;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        CustomLinkedList<String> linkedList = new CustomLinkedList<>();
        linkedList.add("Hello");
        linkedList.add("world");
        linkedList.add("!");
        Iterator iterator = linkedList.getIterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
    }
}