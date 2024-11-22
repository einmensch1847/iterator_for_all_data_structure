package STACK;

import java.util.NoSuchElementException;

public class StackIterator {
    private Node currentNode;

    public StackIterator() {
        this.currentNode = Stack.top;
    }

    public boolean hasNext() {
        return currentNode != null;
    }

    public int next() {
        if (!hasNext()) {
            throw new NoSuchElementException("No more elements in the stack");
        }
        int data = currentNode.data;
        currentNode = currentNode.next;
        return data;
    }
}
