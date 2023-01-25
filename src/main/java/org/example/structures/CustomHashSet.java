package org.example.structures;

import java.util.LinkedList;
import java.util.List;

public class CustomHashSet {
    private List<String>[] array;

    public CustomHashSet() {
        array = new LinkedList[15];
    }

    public CustomHashSet(int size) {
        array = new LinkedList[size];
    }

    private int getBucketIndex(String value) {
        if(value==null){
            return 0;
        }
        return Math.abs(value.hashCode() % (array.length));
    }

    public void add(String value) {
        int bucketIndex = getBucketIndex(value);
        if (array[bucketIndex] == null) {
            array[bucketIndex] = new LinkedList<>();
        }
        for (String element : array[bucketIndex]) {
            if (element.equals(value)) {
                return;
            }
        }
        array[bucketIndex].add(value);
    }

    public boolean contains(String value) {
        int bucketIndex = getBucketIndex(value);
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
