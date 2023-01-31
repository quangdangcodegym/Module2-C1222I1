package com.codegym;

import java.util.Scanner;

public class ArrayJava {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        /**
        // let arr = new Array();
        // let arr1 = [2,5,7,8]; ["Quang", "Nhat"];
        int a = 5;
        // mảng là một biến tham chiếu tới 1 loạt giá trị liên tiếp nhau
        int[] arr = {5, 7, 8, 10};
        arr[1] = 10;    // cập nhật giá trị ở vị tri thu 1
        int [] arr1;
        int[] number1 = new int[3]; // khởi tạo mảng có kích thước 3 phàn tử
        System.out.println("Giá trị của arr: " + arr);
         **/

        int [] numbers = createArray(5);

        System.out.println(printArray(numbers));
        deleteElementFromIndex(numbers, 1);
        System.out.println(printArray(numbers));
    }

    public static int findMaxIndex(int[] numbers) {
        int max = numbers[0];
        int indexMax = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (max < numbers[i]) {
                max = numbers[i];
                indexMax = i;
            }
        }
        return indexMax;
    }

    public static void reverseArray(int[] numbers) {
        for (int i = 0; i < numbers.length / 2; i++) {
            int temp = numbers[i];
            numbers[i] = numbers[numbers.length - i - 1];
            numbers[numbers.length - i - 1] = temp;
        }
    }

    public static void deleteElementFromIndex(int [] numbers, int index) {
        for (int i = index; i < numbers.length-1; i++) {
            numbers[i] = numbers[i + 1];
        }
        numbers[numbers.length-1] = 0;
    }
    public static int sumNFirstElementOdd(int[] numbers, int nFristElement) {
        int sum = 0;
        int count  = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 != 0) {
                count++;
                if (count <= nFristElement) {
                    sum += numbers[i];
                }else{
                    break;
                }

            }
        }
        return sum;
    }
    public static int[] createArray(int size) {
//        int[] numbers = new int[size];
//        System.out.println("Nhập giá trị cho mảng: ");
//        for (int i = 0; i < numbers.length; i++) {
//            numbers[i] = scanner.nextInt();
//        }
//        return numbers;
        int[] numbers = {2, 6, 7, 10, 5};
        return numbers;
    }

    public static int sumArray(int[] numbers) {
        int sum = 0;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] % 2 != 0) {
                sum += numbers[i];
            }
        }
        return sum;
    }
    // Hàm là chỉ thực hiện 1 nhiệm vụ
    public static String printArray(int[] numbers) {
        String str = "[";
        for (int i = 0; i < numbers.length; i++) {
            str += numbers[i];
            if (i != numbers.length - 1) {
                str += ",";
            }
        }
        str += "]";
        return str;
    }
}
