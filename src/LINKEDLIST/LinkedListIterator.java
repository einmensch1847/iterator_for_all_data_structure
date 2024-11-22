package LINKEDLIST;

import java.util.NoSuchElementException;

public class LinkedListIterator {
    private Node currentNode;

    public LinkedListIterator() {
        this.currentNode = LinkedList.head;
    }

    public boolean hasNext() {
        return currentNode != null;
    }

    public int next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more elements in the list");
        }
        int data = currentNode.data;
        currentNode = currentNode.next;
        return data;
    }
}