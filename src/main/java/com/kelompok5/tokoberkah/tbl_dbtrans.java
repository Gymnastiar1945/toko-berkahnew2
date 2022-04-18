package com.kelompok5.tokoberkah;

public class tbl_dbtrans {
    int no;
    String idPenjualan, jam;
    int ttl_byr;
    String kasir;

    public tbl_dbtrans(int no, String idPenjualan, String jam, int ttl_byr, String kasir) {
        this.no = no;
        this.idPenjualan = idPenjualan;
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
