package com.codegym.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class TestMap {
    public static void main(String[] args) {
        Map<Integer, String> maps = new HashMap<>();

        maps.put(1, "Long");
        maps.put(2, "Toan");
        maps.put(5, "Luc");
        maps.put(7, "Bao");

        // Lấy ra danh sách các key: [1,2,5,7]
        Set<Integer> keys = maps.keySet();
        Iterator<Integer> iterator = keys.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

    }
}
