package com.codegym.oopthuvien;

public abstract class TaiLieu {
    private Long maTaiLieu;
    private String nhaXuatBan;
    private int soBanPhatHanh;

    public TaiLieu(Long maTaiLieu, String nhaXuatBan, int soBanPhatHanh) {
        this.maTaiLieu = maTaiLieu;
        this.nhaXuatBan = nhaXuatBan;
        this.soBanPhatHanh = soBanPhatHanh;
    }
    public TaiLieu() {

    }

    public Long getMaTaiLieu() {
        return maTaiLieu;
    }

    public void setMaTaiLieu(Long maTaiLieu) {
        this.maTaiLieu = maTaiLieu;
    }

    public String getNhaXuatBan() {
        return nhaXuatBan;
    }

    public void setNhaXuatBan(String nhaXuatBan) {
        this.nhaXuatBan = nhaXuatBan;
    }

    public int getSoBanPhatHanh() {
        return soBanPhatHanh;
    }

    public void setSoBanPhatHanh(int soBanPhatHanh) {
        this.soBanPhatHanh = soBanPhatHanh;
    }

    public abstract String hienThiThongTin();
}
