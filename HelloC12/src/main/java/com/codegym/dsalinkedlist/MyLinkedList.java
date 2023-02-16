package com.codegym.dsalinkedlist;

public class MyLinkedList<E> {

    private  Node head;
    private  int numNodes;


    MyLinkedList(Object data) {
        head = new Node(data);
        numNodes++;
    }
    public void addFirst(Object data) {
        Node temp = head;
        head = new Node(data);
        head.next = temp;
        numNodes++;
    }

    public void addLast(Object data) {
        Node lastNode = this.get(numNodes - 1);
        lastNode.next = new Node(data);
    }
    public void printList() {
        Node temp = head;
        while(temp != null) {
            System.out.println(temp.data);
            temp = temp.next;
        }
    }

    public void add(int index, Object data) {
        Node temp = head;
        Node holder;

        for(int i=0; i < index-1 && temp.next != null; i++) {
            temp = temp.next;
        }
        holder = temp.next;
        temp.next = new Node(data);
        temp.next.next = holder;
        numNodes = numNodes+1;
    }

    public Node get(int index) {
        Node temp = head;
        for (int i = 0; i < index && temp.next != null; i++) {
            temp = temp.next;
        }
        return temp;
    }

    // nested class, lop long lop
    private class Node {
        private Node next;
        private Object data;

        public Node(Object data) {
            this.data = data;
        }

        public Object getData() {
            return this.data;
        }
    }
}
