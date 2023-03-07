package org.example.structures;

import java.util.Iterator;

public class CustomLinkedList<T> implements Iterable<T> {
    private Node firstNode;
    private Node lastNode;
    private int length = 0;

    public void add(T value) {
        Node newNode = new Node<T>(value);
        if (firstNode == null) {
            firstNode = newNode;
        } else {
            newNode.previousNode = lastNode;
            lastNode.nextNode = newNode;
        }
        lastNode = newNode;
        length++;
    }

    public void addByIndex(int index, T value) {
        if (index > length || index < 0) {
            throw new LinkedListException("Sorry, index bigger than size");
        }
        Node newNode = new Node<T>(value);
        if (index == 0) {
            firstNode.previousNode = newNode;
            newNode.nextNode = firstNode;
            firstNode = newNode;
        } else if (index == length) {
            lastNode.nextNode = newNode;
            lastNode = newNode;
        } else {
            int currentIndex = 0;
            Node current = firstNode;
            while (current != null) {
                if (index == currentIndex) {
                    current.previousNode.nextNode = newNode;
                    newNode.previousNode = current.previousNode;
                    current.previousNode = newNode;
                    newNode.nextNode = current;
                    return;
                }
                currentIndex++;
                current = current.nextNode;
            }
        }
        length++;
    }

    private void validateIndex(int index) {
        if (index >= length || index < 0) {
            throw new LinkedListException("Sorry, incorrect index");
        }
    }

    public T getValue(int index) {
        validateIndex(index);
        Node current = firstNode;
        int currentIndex = 0;
        while (current != null) {
            if (currentIndex == index) {
                return (T) current.value;
            }
            current = current.nextNode;
            currentIndex++;
        }
        return null;
    }

    public void removeElement(int index) {
        validateIndex(index);
        if (index == 0) {
            firstNode = firstNode.nextNode;
            firstNode.previousNode = null;
        } else if (index == length - 1) {
            lastNode = lastNode.previousNode;
            lastNode.nextNode = null;
        } else {
            Node current = firstNode;
            int currentIndex = 0;
            while (current != null) {
                if (currentIndex == index) {
                    current.previousNode.nextNode = current.nextNode;
                    current.nextNode.previousNode = current.previousNode;
                }
                current = current.nextNode;
                currentIndex++;
            }
        }
        length--;
    }

    public boolean contains(T elem) {
        Node current = firstNode;
        while (current != null) {
            if (current.value == elem) {
                return true;
            }
            current = current.nextNode;
        }
        return false;
    }

    public int getLength() {
        return length;
    }

    public String toString() {
        String result = "[";
        Node current = firstNode;
        while (current != null) {
            result += current.value;
            current = current.nextNode;
            if (current != null) {
                result += ", ";
            }
        }
        return result + "]";
    }


    private class Node<T> {
        public T value;
        public Node nextNode;
        public Node previousNode;

        public Node(T value) {
            this.value = value;
        }


    }

    class LinkedListIterator implements Iterator<T> {
        private Node current = firstNode;

        public boolean hasNext() {
            return current != null;
        }

        public T next() {
            Node temp = current;
            current = current.nextNode;
            return (T) temp.value;
        }
    }

    public Iterator iterator() {
        return new LinkedListIterator();
    }
}





