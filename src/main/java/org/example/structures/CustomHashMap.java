package org.example.structures;

import java.util.LinkedList;
import java.util.List;

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

    public void add(T key, S value) {
        Node newNode = new Node(key, value);
        int arrayBuket = key.hashCode() % array.length;
        if (array[arrayBuket] == null) {
            array[arrayBuket] = new LinkedList<>();
        }
        for (Node node : array[arrayBuket]) {
            if (node.getKey().equals(key)) {
                node.setValue(value);
                return;
            }
        }
        array[arrayBuket].add(newNode);
        size++;
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
                result += node.key+": "+node.value + "; ";
            }
        }
        return result;
    }

    class Node {
        private T key;
        private S value;

        public Node(T key, S value) {
            this.key = key;
            this.value = value;
        }

        public T getKey() {
            return key;
        }

        public S getValue() {
            return value;
        }

        public void setValue(S value) {
            this.value = value;
        }
    }
}
