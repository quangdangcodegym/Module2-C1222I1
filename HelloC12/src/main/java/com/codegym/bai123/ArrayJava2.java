package com.codegym.bai123;

import org.w3c.dom.css.CSSStyleDeclaration;

import java.util.Arrays;

public class ArrayJava2 {

    public static void main(String[] args) {
        int[] numbers = {5, 4, 6, 7, 1};
        /**
        int [] numberCopys = Arrays.copyOf(numbers, numbers.length + 3);
        System.out.println(Arrays.toString(numberCopys));

         addElement(numbers, 5);
         int[] subArrays = subArray(numbers, 1, 3);
         int total = sum(subArrays);
         System.out.println("Tổng các phần tử của mảng con: " + total);

         int [] numberNews = addElementAtIndex(numbers, 2, 5);
         System.out.println(Arrays.toString(numberNews));
         **/

        int[] subs = {4};
        boolean check = checkSubArray(numbers, subs);
        System.out.println("Mảng con: " + check);


    }

    // Bài 3: Thêm 1 phần tử vào mảng cuối mảng
    public static int [] addElement(int[] numbers, int value) {
        /**
        int[] numberNews = new int[numbers.length + 1];

        for (int i = 0; i < numbers.length; i++) {
            numberNews[i] = numbers[i];
        }
         **/
        int [] numberNews = Arrays.copyOf(numbers, numbers.length + 1);
        numberNews[numberNews.length - 1] = value;
        System.out.println(Arrays.toString(numberNews));

        return numberNews;
    }

    /**
        Bài 2: Lấy mảng con từ vị trí from đến to
                {5, 4, 6, 7, 1}; from: 1 -> to: 3
     **/
    public static int [] subArray(int [] numbers, int from, int to) {
        // mảng con thu được [] = {4,6,7}
        int[] results = new int[to - from + 1];
        for (int i = from; i <= to; i++) {
            results[i-from] = numbers[i];
        }
        // 1 hàm nên thực hiện 1 nhiệm vụ
//        System.out.println("Mảng con: " + Arrays.toString(results));
        return results;
    }

    public static int sum(int[] nunmbers) {
        int sum = 0;
        for (int i = 0; i < nunmbers.length; i++) {
            sum += nunmbers[i];
        }
        return sum;
    }

    public static int[] addElementAtIndex(int[] number, int index, int value) {
        /**
         B1: tạo ra 1 mảng mới có numberNews: number.lenght+1 phần tử
         B2: sao chép các giá trị trong mảng cũ từ vị trí 0-> index-1
         B3: Tại vị trí index gán bằng value
         B4: sao chép các giá trị trong mảng cũ từ vị trí index+1-> numberNews.length-1
         */
        int [] numberNews = new int[number.length + 1];
        for (int i = 0; i <= index - 1; i++) {
            numberNews[i] = number[i];
        }
        numberNews[index] = value;
        for (int j = index + 1; j < numberNews.length; j++) {
            numberNews[j] = number[j-1];
        }

        return numberNews;
    }

    // {5, 4, 6, 7, 1}; có chứa mảng {4, 6, 8}
    // Kĩ thuật dăt cờ hiệu
    public static boolean checkSubArray(int[] original, int[] subs) {
        for (int i = 0; i < original.length; i++) {
            boolean flag = true;
            if (original[i] == subs[0]) {
                for (int j = 1; j < subs.length; j++) {
                    if (original[i + j] != subs[j]) {
                        flag = false;
                        break;
                    }
                }
                if (flag == true) {
                    return true;
                }
            }
        }
        return false;
    }

}
