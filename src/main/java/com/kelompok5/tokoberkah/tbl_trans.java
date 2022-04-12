package com.kelompok5.tokoberkah;

public class tbl_trans {
    int no;
    String idPenjualan, tanggal, jam;
    int ttl_byr;
    String kasir;

    public tbl_trans(int no, String idPenjualan, String tanggal, String jam, int ttl_byr, String kasir) {
        this.no = no;
        this.idPenjualan = idPenjualan;
        this.tanggal = tanggal;
        this.jam = jam;
        this.ttl_byr = ttl_byr;
        this.kasir = kasir;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getIdPenjualan() {
        return idPenjualan;
    }

    public void setIdPenjualan(String idPenjualan) {
        this.idPenjualan = idPenjualan;
    }

    public String getTanggal() {
        return tanggal;
    }

    public void setTanggal(String tanggal) {
        this.tanggal = tanggal;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    public int getTtl_byr() {
        return ttl_byr;
    }

    public void setTtl_byr(int ttl_byr) {
        this.ttl_byr = ttl_byr;
    }

    public String getKasir() {
        return kasir;
    }

    public void setKasir(String kasir) {
        this.kasir = kasir;
    }
}
