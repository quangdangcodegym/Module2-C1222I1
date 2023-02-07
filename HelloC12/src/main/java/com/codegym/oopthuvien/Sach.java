package com.codegym.oopthuvien;

public class Sach extends TaiLieu{
    private String tenTacGia;
    private int soTrang;

    public Sach() {

    }

    @Override
    public String hienThiThongTin() {
        return String.format("Sách: matailieu %s tenTacGia: %s", this.getMaTaiLieu(), this.tenTacGia);
    }

    public Sach(Long maTaiLieu, String nhaXuatBan, int soBanPhatHanh, String tenTacGia, int soTrang) {
        super(maTaiLieu, nhaXuatBan, soBanPhatHanh);
        this.tenTacGia = tenTacGia;
        this.soTrang = soTrang;
    }

    public Sach(String tenTacGia, int soTrang) {
        this.tenTacGia = tenTacGia;
        this.soTrang = soTrang;
    }

    public String getTenTacGia() {
        return tenTacGia;
    }

    public void setTenTacGia(String tenTacGia) {
        this.tenTacGia = tenTacGia;
    }

    public int getSoTrang() {
        return soTrang;
    }

    public void setSoTrang(int soTrang) {
        this.soTrang = soTrang;
    }
}
