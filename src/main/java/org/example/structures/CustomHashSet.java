package org.example.structures;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class CustomHashSet <T> {
    private List<T>[] array;
    private static final int ARRAY_CAPACITY = 15;

    public CustomHashSet() {
        array = new LinkedList[ARRAY_CAPACITY];
    }

    public CustomHashSet(int size) {
        array = new LinkedList[size];
    }

    private int calculateBucketIndex(T value) {
        if (value == null) {
            return 0;
        }
        return Math.abs(value.hashCode() % (array.length));
    }

    public void add(T value) {
        int bucketIndex = calculateBucketIndex(value);
        if (array[bucketIndex] == null) {
            array[bucketIndex] = new LinkedList<>();
        }
        for (T element : array[bucketIndex]) {
            if (Objects.equals(element,value)) {
                return;
            }
        }
        array[bucketIndex].add(value);
    }

    public boolean contains(T value) {
        int bucketIndex = calculateBucketIndex(value);
        if (array[bucketIndex] == null) return false;

        for (T element : array[bucketIndex]) {
            if (value.equals(element)) return true;
        }
        return false;
    }

    public int getSize() {
        int counter = 0;
        for (List<T> list : array) {
            counter += list.size();
        }
        return counter;
    }

    public String toString() {
        return Arrays.stream(array).filter(bucket->bucket!=null).
                flatMap(bucket->bucket.stream()).
                map(element->element+"").
                reduce("",(result,element)->result+element+" ").trim();
    }
}
