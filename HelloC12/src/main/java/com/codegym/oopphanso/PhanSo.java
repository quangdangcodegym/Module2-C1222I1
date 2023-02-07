package com.codegym.oopphanso;

public class PhanSo {
    private int tuSo;
    private int mauSo;

    public PhanSo(int tuSo, int mauSo) {
        if (mauSo == 0) {
            System.out.println("Mau so khong duoc bang 0");
        }
        this.tuSo = tuSo;
        this.mauSo = mauSo;
    }
}
