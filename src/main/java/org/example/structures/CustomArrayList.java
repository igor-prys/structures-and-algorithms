package org.example.structures;

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

    public boolean contain(String value) {
        for (int i = 0; i < capacity; i++) {
            if (array[i].equals(value)) {
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
        if (index >= capacity) {
            throw new RuntimeException("Incorrect index: " + index);
        }
        int position = 0;
        String[] newArray = new String[array.length];
        for (int i = 0; i < capacity; i++) {
            if (i == index) {
                continue;
            }
            newArray[position++] = array[i];
        }
        capacity--;
        array = newArray;
    }

    public Iterator createIterator() {
        return new CustomArrayListIterator();
    }

    public String toString() {
        String result = "";
        for (int i = 0; i < capacity; i++) {
            result += array[i] + " ";
        }
        return result.trim();
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
