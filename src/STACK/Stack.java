package STACK;

public class Stack {
    public static Node top;
    public static int size;

    public static void stack() {
        Stack stack = new Stack();

        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);

        System.out.println("Initial STACK.Stack:");
        stack.print();

        System.out.println("Popped Element: " + stack.pop());
        stack.print();

        System.out.println("Iterating through STACK.Stack:");
        StackIterator iterator = new StackIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }

//*****************************************************************************

    public Stack() {
        this.top = null;
        this.size = 0;
    }

//*****************************************************************************

    public void push(int value) {
        Node newNode = new Node(value);
        newNode.next = top;
        top = newNode;
        size++;
    }

//*****************************************************************************

    public int pop() {
        if (isEmpty()) {
            throw new IllegalStateException("STACK.Stack is empty");
        }
        int value = top.data;
        top = top.next;
        size--;
        return value;
    }

//*****************************************************************************

    public boolean isEmpty() {
        return top == null;
    }

//*****************************************************************************

    public int size() {
        return size;
    }

//*****************************************************************************

    public void print() {
        System.out.print("STACK.Stack elements: ");
        StackIterator iterator = new StackIterator();
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }

//*****************************************************************************

}
