package com.codegym.oopcomparator;


import com.codegym.oopcomparator.animal.Animal;
import com.codegym.oopcomparator.animal.Chicken;

public class ComparatorByChickenWeight implements MyComparator<Chicken> {
    @Override
    public int compareTo(Chicken a1, Chicken a2) {
        if (a1.layCanNang() > a2.layCanNang()) {
            return 1;
        }else if(a1.layCanNang() == a2.layCanNang()){
            return 0;
        }else {
            return -1;
        }
    }
}
