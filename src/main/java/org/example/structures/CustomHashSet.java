package org.example.structures;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class CustomHashSet {
    private List<String>[] array;
    private static final int ARRAY_CAPACITY = 15;

    public CustomHashSet() {
        array = new LinkedList[ARRAY_CAPACITY];
    }

    public CustomHashSet(int size) {
        array = new LinkedList[size];
    }

    private int calculateBucketIndex(String value) {
        if (value == null) {
            return 0;
        }
        return Math.abs(value.hashCode() % (array.length));
    }

    public void add(String value) {
        int bucketIndex = calculateBucketIndex(value);
        if (array[bucketIndex] == null) {
            array[bucketIndex] = new LinkedList<>();
        }
        for (String element : array[bucketIndex]) {
            if (Objects.equals(element,value)) {
                return;
            }
        }
        array[bucketIndex].add(value);
    }

    public boolean contains(String value) {
        int bucketIndex = calculateBucketIndex(value);
        if (array[bucketIndex] == null) return false;

        for (String element : array[bucketIndex]) {
            if (value.equals(element)) return true;
        }
        return false;
    }

    public int getSize() {
        int counter = 0;
        for (List<String> list : array) {
            counter += list.size();
        }
        return counter;
    }

    public String toString() {
        String result = "";
        for (List<String> list : array) {
            if (list == null) {
                continue;
            }
            for (String element : list) {
                result += element + " ";
            }
        }
        return result.trim();
    }
}
