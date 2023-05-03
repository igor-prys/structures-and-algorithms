package org.example.structures;

public class CustomStack<T> {
    private final T[] array;
    private int counter = 0;

    public CustomStack(int size) {
        array = (T[]) new Object[size];
    }

    public CustomStack() {
        this(10);
    }

    public void push(T value) {
        if (counter == array.length) {
            throw new RuntimeException("Stack is full");
        } else {
            array[counter++] = value;
        }
    }

    public T pull() {
        if (counter == 0) {
            throw new RuntimeException("Stack is empty");
        }
        return array[--counter];
    }

    public T top() {
        return array[counter - 1];
    }

    public boolean isEmpty() {
        return counter == 0;
    }

    public boolean isFull() {
        return counter == array.length;
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < counter; i++) {
            result += array[i] + " ";
        }
        return result.trim();
    }
}
