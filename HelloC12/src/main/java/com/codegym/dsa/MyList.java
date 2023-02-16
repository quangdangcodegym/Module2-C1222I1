package com.codegym.dsa;

import java.util.Arrays;

public class MyList<E> {
    private int size;
    private static final int DEFAULT_CAPACITY = 5;
    private Object elements[];

    public MyList() {
        elements = new Object[DEFAULT_CAPACITY];
    }
    private void ensureCapa() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
    }
    public void add(E e) {
        if (size == elements.length) {
            ensureCapa();
        }
//        elements[size++] = e;
        elements[size] = e;
        size++;
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Vuot qua kich thuoc mang roi ku");
        }
        return (E) elements[index];
    }

    public void remove(int index) {

    }

    public MyList<E> subList(int from, int to) {
        MyList<E> results = new MyList<>();

        for (int i = from; i <= to; i++) {
            results.add(this.get(i));
        }
        return results;
    }

    public void addAll(MyList<E> listNew) {
        for (int i = 0; i < listNew.getSize(); i++) {
            this.add(listNew.get(i));
        }
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Object[] getElements() {
        return elements;
    }

    public void setElements(Object[] elements) {
        this.elements = elements;
    }

    // [3,1,8]
    @Override
    public String toString() {

        /**
         size: 4
         elements= [3,1,7,8, null];
         */
        String str = "[";
        for (int i = 0; i < size; i++) {
            str+= elements[i];
            if (i == size - 1) {
                str += "]";
            }else{
                str += ",";
            }
        }
        return str ;
    }
}
