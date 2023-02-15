package com.codegym.dsaqueue.learn;

public class MyPriorityQueue<E extends Comparable<E>> {
    private Heap<E> heap;
    public MyPriorityQueue(){
        heap = new Heap<>();
    }
    public void enqueue(E e){
        heap.add(e);
    }
    public E dequeue(){
        return heap.remove();
    }
    public boolean isEmpty(){
        return heap.getSize() == 0;
    }
}
