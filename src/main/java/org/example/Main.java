package org.example;

import org.example.structures.CustomLinkedList;
import org.example.structures.CustomStack;

import java.util.Iterator;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        CustomStack<Integer> cs = new CustomStack<>();
        cs.push(1);
        cs.push(2);
        cs.push(3);
        cs.push(4);
        cs.push(5);
        cs.push(6);
        while (!cs.isEmpty()) {
            System.out.print(cs.pull() + " ");
        }
    }
}