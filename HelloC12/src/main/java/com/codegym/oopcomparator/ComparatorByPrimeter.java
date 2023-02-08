package com.codegym.oopcomparator;

public class ComparatorByPrimeter implements MyComparator<Geometric>{
    @Override
    public int compareTo(Geometric o1, Geometric o2) {
        if (o1.getPrimeter() > o2.getPrimeter()) {
            return 1;
        } else if (o1.getPrimeter() == o2.getPrimeter()) {
            return 0;
        } else {
            return -1;
        }
    }
}
