package com.kelompok5.tokoberkah;

public class tbl_gudang {
    String kdbar,namabar, ktgr ;
    Double qty;
    String satuan;
    int harga;

    public tbl_gudang(String kdbar, String namabar, String ktgr, Double qty, String satuan, int harga) {
        this.kdbar = kdbar;
        this.namabar = namabar;
        this.ktgr = ktgr;
        this.qty = qty;
        this.satuan = satuan;
        this.harga = harga;
    }

    public String getKdbar() {
        return kdbar;
    }

    public void setKdbar(String kdbar) {
        this.kdbar = kdbar;
    }

    public String getNamabar() {
        return namabar;
    }

    public void setNamabar(String namabar) {
        this.namabar = namabar;
    }

    public String getKtgr() {
        return ktgr;
    }

    public void setKtgr(String ktgr) {
        this.ktgr = ktgr;
    }

    public Double getQty() {
        return qty;
    }

    public void setQty(Double qty) {
        this.qty = qty;
    }

    public String getSatuan() {
        return satuan;
    }

    public void setSatuan(String satuan) {
        this.satuan = satuan;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }
}