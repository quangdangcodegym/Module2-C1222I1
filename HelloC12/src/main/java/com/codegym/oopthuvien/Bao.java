package com.codegym.oopthuvien;

import java.util.Date;

public class Bao extends TaiLieu{
    private Date ngayPhatHanh;

    public Date getNgayPhatHanh() {
        return ngayPhatHanh;
    }

    public void setNgayPhatHanh(Date ngayPhatHanh) {
        this.ngayPhatHanh = ngayPhatHanh;
    }

    public Bao(Date ngayPhatHanh) {
        this.ngayPhatHanh = ngayPhatHanh;
    }

    public Bao(Long maTaiLieu, String nhaXuatBan, int soBanPhatHanh, Date ngayPhatHanh) {
        super(maTaiLieu, nhaXuatBan, soBanPhatHanh);
        this.ngayPhatHanh = ngayPhatHanh;
    }

    @Override
    public String hienThiThongTin() {
        return String.format("Báo: matailieu %s ngayphathanh: %s", this.getMaTaiLieu(), this.ngayPhatHanh);
    }
}
