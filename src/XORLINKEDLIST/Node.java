package XORLINKEDLIST;

class Node {
    int data;
    int xorAddress;

    Node(int data) {
        this.data = data;
        this.xorAddress = 0;
    }
}