package LINKEDLIST;

public class LinkedList {
    public static Node head;
    public static int size;
    public static void LinkedList() {
        LinkedList list = new LinkedList();

        list.add(10);
        list.add(20);
        list.add(30);
        list.add(40);

        System.out.println("Initial LINKEDLIST.LinkedList:");
        list.print();
        list.remove(2);
        System.out.println("After Removing Element at index 2:");
        list.print();
        System.out.println("Element at index 1: " + list.get(1));

        System.out.println("Iterating using Custom Iterator:");
        LinkedListIterator iterator = new LinkedListIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

    public LinkedList() {
        this.head = null;
        this.size = 0;
    }

//*****************************************************************************

    public void add(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

//*****************************************************************************

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        if (index == 0) {
            head = head.next;
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;
    }

//*****************************************************************************

    public int get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of bounds");
        }

        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

//*****************************************************************************

    public int size() {
        return size;
    }

//*****************************************************************************

    public void print() {
        Node current = head;
        System.out.print("[");
        while (current != null) {
            System.out.print(current.data);
            if (current.next != null) {
                System.out.print(", ");
            }
            current = current.next;
        }
        System.out.println("]");
    }

//*****************************************************************************

}
