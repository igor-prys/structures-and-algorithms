package org.example.structures;

public class CustomLinkedList<T> {
    private Node firstNode;
    private Node lastNode;
    private int counter = 0;

    public void add(T value) {
        Node newNode = new Node<T>(value);
        if (firstNode == null) {
            firstNode = newNode;
        } else {
            newNode.previousNode = lastNode;
            lastNode.setNextNode(newNode);
        }
        lastNode = newNode;
        counter++;
    }

    public void addByIndex(int index, T value) {
        if (index > counter || index < 0) {
            throw new LinkedListException("Sorry, index bigger than size");
        }
        Node newNode = new Node<T>(value);
        if (index == 0) {
            firstNode.previousNode = newNode;
            newNode.nextNode = firstNode;
            firstNode = newNode;
            counter++;
        } else if (index == counter) {
            lastNode.setNextNode(newNode);
            lastNode = newNode;
            counter++;
        } else {
            int currentIndex = 0;
            Node current = firstNode;
            while (current != null) {
                if (index == currentIndex) {
                    current.getPreviousNode().setNextNode(newNode);
                    newNode.setPreviousNode(current.getPreviousNode());
                    current.setPreviousNode(newNode);
                    newNode.nextNode = current;
                    counter++;
                    return;
                }
                currentIndex++;
                current = current.getNextNode();
            }
        }
    }

    public T getValue(int index) {
        if (index < 0 || index >= counter ) {
            throw new LinkedListException("Sorry, incorrect index");
        }
        Node current = firstNode;
        int currentIndex = 0;
        while (current != null) {
            if (currentIndex == index) {
                return (T) current.getValue();
            }
            current = current.getNextNode();
            currentIndex++;
        }
        return null;
    }

    public void removeElement(int index) {
        if (index >= counter || index < 0) {
            throw new LinkedListException("Sorry, incorrect index");
        }
        if (index == 0) {
            firstNode = firstNode.nextNode;
            firstNode.setPreviousNode(null);
        } else if (index == counter - 1) {
            lastNode = lastNode.previousNode;
            lastNode.nextNode = null;
        } else {
            Node current = firstNode;
            int currentIndex = 0;
            while (current != null) {
                if (currentIndex == index) {
                    current.previousNode.setNextNode(current.nextNode);
                    current.nextNode.setPreviousNode(current.previousNode);
                }
                current = current.nextNode;
                currentIndex++;
            }
        }
        counter--;
    }

    public boolean contain(T elem) {
        Node current = firstNode;
        while (current != null) {
            if (current.value == elem) {
                return true;
            }
            current = current.nextNode;
        }
        return false;
    }

    public int getCounter() {
        return counter;
    }

    public String toString() {
        String result = "[";
        Node current = firstNode;
        while (current != null) {
            result += current.getValue();
            current = current.getNextNode();
            if (current != null) {
                result += ", ";
            }
        }
        return result + "]";
    }


    private class Node<T> {
        private T value;
        private Node nextNode;
        private Node previousNode;

        public Node(T value) {
            this.value = value;
        }

        public T getValue() {
            return value;
        }

        public void setValue(T value) {
            this.value = value;
        }

        public Node getNextNode() {
            return nextNode;
        }

        public void setNextNode(Node nextNode) {
            this.nextNode = nextNode;
        }

        public Node getPreviousNode() {
            return previousNode;
        }

        public void setPreviousNode(Node previousNode) {
            this.previousNode = previousNode;
        }
    }

}
