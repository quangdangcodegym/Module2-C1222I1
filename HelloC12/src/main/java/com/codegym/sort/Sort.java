package com.codegym.sort;

import java.util.Arrays;

public class Sort {
    public static void main(String[] args) {
        int [] numbers = {64, 25, 12, 22, 11, 3};
        bubleSort(numbers);
        System.out.println(Arrays.toString(numbers));
    }

    public static void selectionSort(int[] numbers) {
        //{64, 12 25, 12, 22, 11};
        int minIndex, min;
        for (int i = 0; i < numbers.length - 1; i++) {
            minIndex = i;
            min = numbers[minIndex];
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[j] > min) {
                    minIndex = j;
                    min = numbers[minIndex];
                }
            }
            int temp = numbers[i];
            numbers[i] = numbers[minIndex];
            numbers[minIndex] = temp;
        }
    }

    public static void bubleSort(int[] numbers) {
        for (int i = 0; i < numbers.length - 1; i++) {
            for (int j = 0; j < numbers.length - i - 1; j++) {
                if (numbers[j] > numbers[j + 1]) {
                    int temp = numbers[j+1];
                    numbers[j+1] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
    }

    public static void interchangeSort(int [] numbers){
        for (int i = 0; i < numbers.length-1; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                if (numbers[i] > numbers[j]) {
                    int temp = numbers[i];
                    numbers[i] = numbers[j];
                    numbers[j] = temp;
                }
            }
        }
    }
}
