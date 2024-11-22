import java.util.Scanner;

public class Main {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.print("select your choice : \n1) Vectors \n2)Array \n3)LinkedList \n4)Stack \n5)XORLinkedList \n => ");
        int choice = scanner.nextInt();
        System.out.println("\n");
        if (choice == 1) {
            VECTORS.Vectors.vectors() ;
        }
        else if (choice == 2) {
            ARRAY.Array.array() ;
        }
        else if (choice == 3) {
            LINKEDLIST.LinkedList.LinkedList();
        }
        else if (choice == 4) {
            STACK.Stack.stack() ;
        }
        else if (choice == 5) {
            XORLINKEDLIST.XORLinkedList.xorlinkedlist();
        }
        else {
            System.out.println("Invalid choice");
        }

    }
}