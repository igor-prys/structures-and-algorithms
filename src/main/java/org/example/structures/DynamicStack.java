package org.example.structures;

import java.util.ArrayList;
import java.util.List;

public class DynamicStack<T> {
    private final List<T> list = new ArrayList<>();
    private int counter = 0;

    public void push(T t) {
        list.add(t);
        counter++;
    }

    public T pop() {
        return list.get(--counter);
    }

    public T peek() {
        return list.get(counter - 1);
    }

    public boolean isEmpty() {
        return counter == 0;
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < counter; i++) {
            result += list.get(i) + " ";
        }
        return result.trim();
    }
}
