package com.codegym.iofile;



import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class IOFileMain {
    private static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        do{
            // numbers = [1,1,2]= > [1,1,2,4]
            System.out.println("Moi chọn chức năng: ");
            System.out.println("1. Thêm tổng các số ở trước vào cuối file");
            System.out.println("2. Thêm số lớn nhất ở trước vào cuối file");

            int actionMenu = Integer.parseInt(scanner.nextLine());
            switch (actionMenu) {
                case 1:
                    addTotalToLastNumbersView();
                    break;
                case 2:
                    addMaxToLastNumbersView();
                    break;
                default:

            }
        }while (true);

    }

    private static void addTotalToLastNumbersView() {
        List<Integer> numbers1 = readNumbersFromFile("data.txt");
        addTotalToLastNumbers(numbers1);
        writeNumberToFile(numbers1,"data.txt");
    }

    private static void addMaxToLastNumbersView() {
        List<Integer> numbers = readNumbersFromFile("data.txt");
        addMaxToLastNumbers(numbers);
        writeNumberToFile(numbers,"data.txt");
    }

    private static void addMaxToLastNumbers(List<Integer> numbers) {
        int max = numbers.get(0);
        for (int i = 0; i < numbers.size(); i++) {
            if (numbers.get(i) >= max) {
                max = numbers.get(i);
            }
        }
        numbers.add(max);
    }

    private static void addTotalToLastNumbers(List<Integer> numbers) {
        int total = 0;
        for (int i = 0; i < numbers.size(); i++) {
            total += numbers.get(i);
        }
        numbers.add(total);
    }

    public static List<Integer> readNumbersFromFile(String fileName) {
        List<Integer> numbers  = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(fileName);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = null;
            while ( (line = bufferedReader.readLine()) != null) {
                numbers.add(Integer.parseInt(line));
            }


            fileReader.close();
            bufferedReader.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
        return numbers;
    }


    public static void writeNumberToFile(List<Integer> numbers, String fileName) {
        try {
            FileWriter fileWriter = new FileWriter("data.txt");
            for (int i = 0; i < numbers.size(); i++) {
                fileWriter.write(numbers.get(i) + "" );
                if (i != numbers.size() - 1) {
                    fileWriter.write("\n");
                }
            }
            fileWriter.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
    /**
    public static void basicWriteFile() {
        try {
//            FileWriter fileWriter = new FileWriter("data.txt");


            File testFolder = new File("D:\\Quangcodegym\\test");
            if (!testFolder.exists()) {
                testFolder.mkdir();
            }

            File file = new File(testFolder.getAbsolutePath() + "\\data.txt");
            FileWriter fileWriter = new FileWriter(file);
            fileWriter.write("Hello C12");
            fileWriter.write("\n");

            char[] cbuffs = {'q', 'u', 'a', 'n', 'g'};
            fileWriter.write(cbuffs);

            fileWriter.write("\n");
            fileWriter.write(cbuffs, 2, 2);

            fileWriter.close();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

    public static void basicFileReader() {
        try {
            FileReader fileReader = new FileReader("data.txt");
//            System.out.println((char) fileReader.read());
//            System.out.println((char) fileReader.read());
//            System.out.println(fileReader.read());

            String str = "";
            int temp = -1;
            while ((temp = fileReader.read())!=-1){
                str += (char)temp;
            }
            System.out.println(str);

        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }

     **/
}
