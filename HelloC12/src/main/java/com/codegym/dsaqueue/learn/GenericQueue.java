package com.codegym.dsaqueue.learn;

import java.util.LinkedList;

public class GenericQueue<E> {
    private LinkedList<E> elements;

    public GenericQueue() {
        elements = new LinkedList<>();
    }

    public void enqueue(E e) {
        elements.addLast(e);
    }
    public E dequeue(){
        return elements.removeFirst();
    }
    public int getSize(){
        return elements.size();
    }
    public boolean isEmpty(){
        return elements.size() == 0;
    }

}