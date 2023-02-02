package org.example.structures;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class CustomHashMap<T, S> {
    private List<Node>[] array;
    private static final int DEFAULT_CAPACITY = 15;

    private int size = 0;

    public CustomHashMap(int capacity) {
        array = new LinkedList[capacity];
    }

    public CustomHashMap() {
        this(DEFAULT_CAPACITY);
    }

    private int calculateBuketIndex(T key) {
        return key != null ? key.hashCode() % array.length : 0;
    }

    public void add(T key, S value) {
        Node newNode = new Node(key, value);
        int buketIndex = calculateBuketIndex(key);
        if (array[buketIndex] == null) {
            array[buketIndex] = new LinkedList<>();
        }
        for (Node node : array[buketIndex]) {
            if (Objects.equals(node.key, key)) {
                node.value = value;
                return;
            }
        }
        array[buketIndex].add(newNode);
        size++;
    }

    public S get(T key) {
        int buketIndex = calculateBuketIndex(key);
        for (Node node : array[buketIndex]) {
            if (Objects.equals(node.key, key)) {
                return node.value;
            }
        }
        return null;
    }

    public boolean containsKey(T key) {
        int buketIndex = calculateBuketIndex(key);
        if (array[buketIndex] == null) {
            return false;
        }
        for (Node node : array[buketIndex]) {
            if (Objects.equals(node.key, key)) {
                return true;
            }
        }
        return false;
    }

    public int getSize() {
        return size;
    }

    public String toString() {
        String result = "";
        for (List<Node> list : array) {
            if (list == null) {
                continue;
            }
            for (Node node : list) {
                result += node.key + ": " + node.value + "; ";
            }
        }
        return result.trim();
    }

    private class Node {
        T key;
        S value;

        public Node(T key, S value) {
            this.key = key;
            this.value = value;
        }
    }
}