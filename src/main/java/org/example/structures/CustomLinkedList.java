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
            newNode.previousNode=lastNode;
            lastNode.setNextNode(newNode);
        }
        lastNode = newNode;
        counter++;
    }

    public void addByIndex(int index,T value) {
        if (index >counter) {
            throw new LinkedListException("Sorry, index bigger than size");
        }
        Node newNode = new Node<T>(value);
        if(index==0){
            firstNode.previousNode=newNode;
            newNode.nextNode=firstNode;
            firstNode=newNode;
            counter++;
        }
        else if (index == counter) {
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
                   newNode.nextNode=current;
                }
                currentIndex++;
                current=current.getNextNode();
            }
            counter++;
        }
    }

//    public T getValue(int index){
//
//    }

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
