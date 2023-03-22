package org.example.structures;

import java.util.Arrays;
import java.util.Objects;

public class CustomArrayList<T> implements CustomList<T>, IteratorCreator {
    private T[] array;

    private int capacity = 0;
    private static final int SIZE = 10;


    public CustomArrayList(int size) {
        array = (T[]) new Object[SIZE];
    }

    public CustomArrayList() {
        this(SIZE);
    }

    public void add(T value) {
        if (capacity == array.length) {
            T[] newArray = (T[]) new Object[array.length * 2];
            for (int i = 0; i < array.length; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
        array[capacity++] = value;
    }

    public void add(T... values) {
        if (capacity + values.length >= array.length) {
            T[] newArray = (T[]) new Object[(capacity + values.length) * 2];
            for (int i = 0; i < capacity; i++) {
                newArray[i] = array[i];
            }
            array = newArray;
        }
        for (int i = 0; i < values.length; i++) {
            array[capacity++] = values[i];
        }
    }

    public void insert(int index, T value) {
        if (index > capacity || index < 0) {
            throw new RuntimeException("Incorrect index: " + index);
        }
        int arrayLength = capacity == array.length ? array.length * 2 : array.length;
        T[] newArray = (T[]) new Object[arrayLength];
        System.arraycopy(array, 0, newArray, 0, index);
        newArray[index] = value;
        System.arraycopy(array, index, newArray, index + 1, capacity - index);
        array = newArray;
        capacity++;
    }

    public boolean contains(T value) {
        for (int i = 0; i < capacity; i++) {
            if (Objects.equals(array[i], value)) {
                return true;
            }
        }
        return false;
    }

    public boolean deleteByValue(T value) {
        T[] newArray = (T[]) new Object[array.length];
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
            return true;
        }
        return false;
    }

    public void deleteByIndex(int index) {
        if (index >= capacity || index < 0) {
            throw new RuntimeException("Incorrect index: " + index);
        }
        T[] newArray = (T[]) new Object[array.length];
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
                map(el -> el + "").
                reduce("", (result, element) -> result + element + " ").trim();
    }

    private class CustomArrayListIterator implements Iterator {
        int index = 0;

        public boolean hasNext() {
            return index < capacity;
        }

        public T next() {
            return array[index++];
        }
    }
}
