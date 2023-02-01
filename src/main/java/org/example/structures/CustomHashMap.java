package org.example.structures;

import java.util.*;

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
        int arrayBuketIndex = calculateBuketIndex(key);
        if (array[arrayBuketIndex] == null) {
            array[arrayBuketIndex] = new LinkedList<>();
        }
        for (Node node : array[arrayBuketIndex]) {
            if (Objects.equals(node.key, key)) {
                node.value = value;
                return;
            }
        }
        array[arrayBuketIndex].add(newNode);
        size++;
    }

    public S get(T key) {
        int arrayBuketIndex = calculateBuketIndex(key);
        for (Node node : array[arrayBuketIndex]) {
            if (Objects.equals(node.key, key)) {
                return node.value;
            }
        }
        return null;
    }

    public boolean containsKey(T key) {
        int arrayBuketIndex = calculateBuketIndex(key);
        if (array[arrayBuketIndex] == null) {
            return false;
        }
        for (Node node : array[arrayBuketIndex]) {
            if (Objects.equals(node.key, key)) {
                return true;
            }
        }
        return false;
    }

    public Set<Node> getNodes() {
        Set<Node> nodes = new HashSet<>();
        for (int i = 0; i < array.length; i++) {
            if (array[i] == null) {
                continue;
            }
            for (Node node : array[i]) {
                nodes.add(node);
            }
        }
        return nodes;
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

    public class Node {
        T key;
        S value;

        public Node(T key, S value) {
            this.key = key;
            this.value = value;
        }
    }
}