package com.codegym.oopthuvien;

import java.util.Date;

public class ThuVien {
    private TaiLieu[] tailieus;

    public ThuVien() {
        tailieus = new TaiLieu[5];
        //Long maTaiLieu, String nhaXuatBan, int soBanPhatHanh, String tenTacGia, int soTrang
        TaiLieu taiLieu1 = new Sach(1L, "Kim Dong", 1000, "Viet Long", 100);
        TaiLieu taiLieu2 = new Sach(2L, "Kim Dong", 1000, "Quang Dang", 100);

        //public Bao(Long maTaiLieu, String nhaXuatBan, int soBanPhatHanh, Date ngayPhatHanh) {
        TaiLieu taiLieu3 = new Bao(3L, "Thanh Nien", 100, new Date());
        TaiLieu taiLieu4 = new Bao(4L, "Bong da", 100, new Date());
        TaiLieu taiLieu5 = new Bao(5L, "Dan tri", 100, new Date());

        tailieus[0] = taiLieu1;
        tailieus[1] = taiLieu2;
        tailieus[2] = taiLieu3;
        tailieus[3] = taiLieu4;
        tailieus[4] = taiLieu5;


    }

    public void hienThiTaiLieu() {
        for (int i = 0; i < tailieus.length; i++) {
            System.out.println(tailieus[i].hienThiThongTin());
        }
    }

    public static void main(String[] args) {
        ThuVien thuVien = new ThuVien();

        thuVien.hienThiTaiLieu();
    }
}
