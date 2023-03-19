package org.example.structures;

import java.util.Arrays;
import java.util.Objects;

public class CustomArrayList implements IteratorCreator {
    private String[] array;

    private int capacity = 0;
    private static final int SIZE = 10;


    public CustomArrayList(int size) {
        array = new String[size];
    }

    public CustomArrayList() {
        this(SIZE);
    }

    public void add(String value) {
        if (capacity == array.length) {
            String[] newArray = new String[array.length * 2];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
        array[capacity++] = value;
    }

    public void add(String... values) {
        if (capacity + values.length >= array.length) {
            String[] newArray = new String[(capacity + values.length) * 2];
            for (int i = 0; i < capacity; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
        for (int i = 0; i < values.length; i++) {
            array[capacity++] = values[i];
        }
    }

    public void insert(int index, String value) {
        if (index > capacity || index < 0) {
            throw new RuntimeException("Incorrect index: " + index);
        }
        int arrayLength = capacity == array.length ? array.length * 2 : array.length;
        String[] newArray = new String[arrayLength];
        System.arraycopy(array, 0, newArray, 0, index);
        newArray[index] = value;
        System.arraycopy(array, index, newArray, index + 1, capacity - index);
        array = newArray;
        capacity++;
    }

    public boolean contains(String value) {
        for (int i = 0; i < capacity; i++) {
            if (Objects.equals(array[i], value)) {
                return true;
            }
        }
        return false;
    }

    public void deleteByValue(String value) {
        String[] newArray = new String[array.length];
        int position = 0;
        for (int i = 0; i < capacity; i++) {
            if (array[i].equals(value)) {
                continue;
            }
            newArray[position++] = array[i];
        }
        if (position != capacity) {
            capacity--;
            array = newArray;
        }
    }

    public void deleteByIndex(int index) {
        if (index >= capacity || index < 0) {
            throw new RuntimeException("Incorrect index: " + index);
        }
        String[] newArray = new String[array.length];
        System.arraycopy(array, 0, newArray, 0, index);
        System.arraycopy(array, index + 1, newArray, index, capacity - index);
        capacity--;
        array = newArray;
    }

    public Iterator createIterator() {
        return new CustomArrayListIterator();
    }

    public String toString() {
        return Arrays.stream(array).limit(capacity).
                reduce("", (result, element) -> result + element + " ").trim();
    }

    private class CustomArrayListIterator implements Iterator {
        int index = 0;

        public boolean hasNext() {
            return index < capacity;
        }

        public String next() {
            return array[index++];
        }
    }
}
