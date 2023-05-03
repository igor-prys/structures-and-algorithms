package org.example;

import org.example.structures.DynamicStack;

public class Main {
    public static void main(String[] args) {
        DynamicStack<Integer> ds = new DynamicStack<>();
        ds.push(1);
        ds.push(2);
        ds.push(3);
        ds.push(4);
        System.out.println(ds);
    }
}