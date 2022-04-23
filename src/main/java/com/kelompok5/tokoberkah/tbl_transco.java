package com.kelompok5.tokoberkah;

public class tbl_transco {
    String co_kdbar,co_namabar;
    int co_harga;
    Double co_qty;
    String co_satuan;
    Double co_total;

    public tbl_transco(String co_kdbar, String co_namabar, int co_harga, Double co_qty, String co_satuan, Double co_total) {
        this.co_kdbar = co_kdbar;
        this.co_namabar = co_namabar;
        this.co_harga = co_harga;
        this.co_qty = co_qty;
        this.co_satuan = co_satuan;
        this.co_total = co_total;
    }

    public String getCo_kdbar() {
        return co_kdbar;
    }

    public void setCo_kdbar(String co_kdbar) {
        this.co_kdbar = co_kdbar;
    }

    public String getCo_namabar() {
        return co_namabar;
    }

    public void setCo_namabar(String co_namabar) {
        this.co_namabar = co_namabar;
    }

    public int getCo_harga() {
        return co_harga;
    }

    public void setCo_harga(int co_harga) {
        this.co_harga = co_harga;
    }

    public Double getCo_qty() {
        return co_qty;
    }

    public void setCo_qty(Double co_qty) {
        this.co_qty = co_qty;
    }

    public String getCo_satuan() {
        return co_satuan;
    }

    public void setCo_satuan(String co_satuan) {
        this.co_satuan = co_satuan;
    }

    public Double getCo_total() {
        return co_total;
    }

    public void setCo_total(Double co_total) {
        this.co_total = co_total;
    }
}
