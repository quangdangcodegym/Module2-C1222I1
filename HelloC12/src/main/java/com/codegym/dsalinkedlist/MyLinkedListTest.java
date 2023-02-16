package com.codegym.dsalinkedlist;

public class MyLinkedListTest {
    public static void main(String[] args) {
        MyLinkedList<Integer> linkedList = new MyLinkedList(5);
        linkedList.add(2, 9);
        linkedList.addFirst(2);
        linkedList.addFirst(1);
        linkedList.addFirst(6);


        linkedList.printList();
    }
}
