package XORLINKEDLIST;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

public class XORLinkedList {
    public static void xorlinkedlist(){
        XORLinkedList list = new XORLinkedList();

        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        System.out.println("Initial XOR LinkedList:");
        list.print();

        System.out.println("Removed Last Element: " + list.removeLast());
        list.print();

        System.out.println("List Size: " + list.size());
    }

    private Node head;
    private Node tail;
    private int size;

    private Map<Integer, Node> addressMap = new HashMap<>();

    public XORLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    private int getAddress(Node node) {
        return node == null ? 0 : System.identityHashCode(node);
    }

    private Node getNodeByAddress(int address) {
        return addressMap.get(address);
    }

    public void add(int value) {
        Node newNode = new Node(value);
        int newNodeAddress = getAddress(newNode);

        addressMap.put(newNodeAddress, newNode);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            int tailAddress = getAddress(tail);
            newNode.xorAddress = tailAddress;
            tail.xorAddress ^= newNodeAddress;
            tail = newNode;
        }

        size++;
    }

    public int removeLast() {
        if (tail == null) {
            throw new NoSuchElementException("List is empty");
        }

        int tailAddress = getAddress(tail);
        int prevAddress = tail.xorAddress;
        Node prev = getNodeByAddress(prevAddress);

        int value = tail.data;

        if (prev == null) {
            head = null;
            tail = null;
        } else {
            prev.xorAddress ^= tailAddress;
            tail = prev;
        }

        addressMap.remove(tailAddress);
        size--;

        return value;
    }

    public void print() {
        Node current = head;
        int prevAddress = 0;
        int nextAddress;

        System.out.print("[");
        while (current != null) {
            System.out.print(current.data);

            nextAddress = current.xorAddress ^ prevAddress;
            prevAddress = getAddress(current);
            current = getNodeByAddress(nextAddress);

            if (current != null) {
                System.out.print(", ");
            }
        }
        System.out.println("]");
    }

    public int size() {
        return size;
    }
}
