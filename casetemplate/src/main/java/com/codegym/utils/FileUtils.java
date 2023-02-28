package com.codegym.utils;

import com.codegym.model.Customer;
import com.codegym.model.CustomerType;
import com.codegym.model.Product;
import com.codegym.service.file.IModel;

import java.io.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

public class FileUtils {
    public static <T> void writeDataToFile(String path, List<T> list){
        try {
            FileWriter fileWriter = new FileWriter(path);
            for (int i = 0; i < list.size(); i++) {
                T item = list.get(i);
                fileWriter.write(item.toString());
                if (i != list.size()) {
                    fileWriter.write("\n");
                }
            }
            fileWriter.close();
        } catch (IOException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
    }
    public static <T> void writeDataToFileAppend(String path, List<T> list, boolean append){
        try {
            FileWriter fileWriter = new FileWriter(path, append);
            for (int i = 0; i < list.size(); i++) {
                T item = list.get(i);
                fileWriter.write(item.toString());
                if (i != list.size()) {
                    fileWriter.write("\n");
                }
            }
            fileWriter.close();
        } catch (IOException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
    }
    public static <T> List<T> readDataFromFile(String path, Class<T> tClass){
        try {
            FileReader fileReader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line = null;
            List<T> list = new ArrayList<>();
            while ((line = bufferedReader.readLine()) != null) {
                // line: 1L,Quang Dang,0399578134,28 NTP,20-12-2023 08:00,0,NORMAL
                Customer c = new Customer();
                IModel<T> iModel = (IModel<T>) tClass.getDeclaredConstructor().newInstance();

                list.add(iModel.parseData(line));
            }
            fileReader.close();
            bufferedReader.close();

            return list;
        } catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        } catch (InvocationTargetException e) {
            throw new RuntimeException(e);
        } catch (InstantiationException e) {
            throw new RuntimeException(e);
        } catch (IllegalAccessException e) {
            throw new RuntimeException(e);
        } catch (NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
        return null;
    }
}
