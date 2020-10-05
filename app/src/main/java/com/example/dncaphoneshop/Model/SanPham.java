package com.example.dncaphoneshop.Model;

public class SanPham {

    private int hinhAnh;
    private String tenSP;
    private String gia;
    private String khuyenMai;

    public SanPham() {
    }

    public SanPham(int hinhAnh, String tenSP, String gia, String khuyenMai) {
        this.hinhAnh = hinhAnh;
        this.tenSP = tenSP;
        this.gia = gia;
        this.khuyenMai = khuyenMai;
    }

    public int getHinhAnh() {
        return hinhAnh;
    }

    public void setHinhAnh(int hinhAnh) {
        this.hinhAnh = hinhAnh;
    }

    public String getTenSP() {
        return tenSP;
    }

    public void setTenSP(String tenSP) {
        this.tenSP = tenSP;
    }

    public String getGia() {
        return gia;
    }

    public void setGia(String gia) {
        this.gia = gia;
    }

    public String getKhuyenMai() {
        return khuyenMai;
    }

    public void setKhuyenMai(String khuyenMai) {
        this.khuyenMai = khuyenMai;
    }
}
