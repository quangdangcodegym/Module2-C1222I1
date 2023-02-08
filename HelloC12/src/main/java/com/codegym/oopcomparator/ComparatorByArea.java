package com.codegym.oopcomparator;

public class ComparatorByArea implements MyComparator<Geometric>{
    @Override
    public int compareTo(Geometric g1, Geometric g2) {

        if (g1.getArea() > g2.getArea()) {
            return 1;
        }else{
            if (g1.getArea() == g2.getArea()) {
                return 0;
            }
        }
        return -1;
    }

    /**
     * g1 > g2 return 1
     * g1 == g2 return 0
     * g1 < g2 return -1
     * @param g1
     * @param g2
     * @return
     */


}
