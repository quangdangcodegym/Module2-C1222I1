package com.codegym.iofile;



import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class IOFileMain {
    public static void main(String[] args) {

        List<Integer> numbers = readNumbersFromFile("data.txt");
        // numbers = [1,1,2]= > [1,1,2,4]
        addTotalToLastNumbers(numbers);
        writeNumberToFile(numbers, "data.txt");
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
