package org.example;

import org.example.structures.DynamicStack;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        DynamicStack<Integer> ds = new DynamicStack<>();
        ds.push(1);
        ds.push(2);
        ds.push(3);
        ds.push(4);
        System.out.println(ds);
        Stack<String>stack=new Stack<>();
        stack.push("1");
        stack.push("2");
        System.out.println(stack.pop());
        System.out.println(stack);
        System.out.println(stack);
    }
}