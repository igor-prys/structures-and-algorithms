package org.example.structures;

import java.util.Arrays;
import java.util.Iterator;
import java.util.Objects;

public class CustomArrayList<T> implements CustomList<T>, Iterable {
    private T[] array;

    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;

    public CustomArrayList(int size) {
        array = (T[]) new Object[size];
    }

    public CustomArrayList() {
        this(DEFAULT_CAPACITY);
    }

    private void grow(int initialCapacity) {
        T[] newArray = (T[]) new Object[initialCapacity * 2];
        System.arraycopy(array, 0, newArray, 0, array.length);
        array = newArray;
    }

    public void add(T value) {
        if (size == array.length) {
            grow(array.length);
        }
        array[size++] = value;
    }

    public void add(T... values) {
        if (size + values.length >= array.length) {
            grow(size + values.length);
        }
        for (int i = 0; i < values.length; i++) {
            array[size++] = values[i];
        }
    }

    public void insert(int index, T value) {
        if (index > size || index < 0) {
            throw new RuntimeException("Incorrect index: " + index);
        }
        int arrayLength = size == array.length ? array.length * 2 : array.length;
        T[] newArray = (T[]) new Object[arrayLength];
        System.arraycopy(array, 0, newArray, 0, index);
        newArray[index] = value;
        System.arraycopy(array, index, newArray, index + 1, size - index);
        array = newArray;
        size++;
    }

    public boolean contains(T value) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(array[i], value)) {
                return true;
            }
        }
        return false;
    }

    public boolean deleteByValue(T value) {
        T[] newArray = (T[]) new Object[array.length];
        int position = 0;
        for (int i = 0; i < size; i++) {
            if (array[i].equals(value)) {
                continue;
            }
            newArray[position++] = array[i];
        }
        if (position != size) {
            size--;
            array = newArray;
            return true;
        }
        return false;
    }

    public void deleteByIndex(int index) {
        if (index >= size || index < 0) {
            throw new RuntimeException("Incorrect index: " + index);
        }
        T[] newArray = (T[]) new Object[array.length];
        System.arraycopy(array, 0, newArray, 0, index);
        System.arraycopy(array, index + 1, newArray, index, size - index);
        size--;
        array = newArray;
    }

    @Override
    public Iterator iterator() {
        return new CustomArrayListIterator();
    }

    public String toString() {
        return Arrays.stream(array).limit(size).
                map(el -> el + "").
                reduce("", (result, element) -> result + element + " ").trim();
    }

    private class CustomArrayListIterator implements Iterator {
        int index = 0;

        public boolean hasNext() {
            return index < size;
        }

        public T next() {
            return array[index++];
        }
    }
}
