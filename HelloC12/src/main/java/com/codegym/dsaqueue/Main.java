package com.codegym.dsaqueue;

import com.codegym.dsaqueue.learn.GenericQueue;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        /**
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(5);
        stack.push(8);
        stack.push(9);


        System.out.println(stack.pop());      // 9
        System.out.println(stack.peek());       //8
        System.out.println(stack.pop());

         **/

        /**
        Queue<String> queue  = new PriorityQueue<>();


        queue.offer("Nhat");
        queue.offer("Luc");
        queue.offer("Ai");
        queue.offer("Toan");
        queue.offer("Quang");


        System.out.println(queue.element());
        System.out.println(queue.element());

        while (!queue.isEmpty()) {
            System.out.println(queue.poll());
        }
         **/

        /**
        int[] numbers = {2, 1, 7, 9, 4};
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < numbers.length; i++) {
            stack.push(numbers[i]);
        }

        int i=0;
        while (!stack.isEmpty()) {
            numbers[i] = stack.pop();
            i++;
        }
        System.out.println(Arrays.toString(numbers));
         **/

        System.out.println(toBinaryString(17));
    }

    public static String toBinaryString(int number) {
        Stack<Integer> stack = new Stack<>();
        int _du;
        while (number  != 0 ) {
            _du = number%2;
            number = number/2;
            stack.push(_du);
        }

        String str = "";
        while (!stack.isEmpty()) {
            str += stack.pop();
        }
        return str;
    }
}
