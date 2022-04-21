package com.kelompok5.tokoberkah;

public class tbl_transbeli {
  String bkdbar,bnamabar;
  int bharga;
  Double bqty, btotal;

    public tbl_transbeli(String bkdbar, String bnamabar, int bharga, Double bqty, Double btotal) {
        this.bkdbar = bkdbar;
        this.bnamabar = bnamabar;
        this.bharga = bharga;
        this.bqty = bqty;
        this.btotal = btotal;
    }

    public String getBkdbar() {
        return bkdbar;
    }

    public void setBkdbar(String bkdbar) {
        this.bkdbar = bkdbar;
    }

    public String getBnamabar() {
        return bnamabar;
    }

    public void setBnamabar(String bnamabar) {
        this.bnamabar = bnamabar;
    }

    public int getBharga() {
        return bharga;
    }

    public void setBharga(int bharga) {
        this.bharga = bharga;
    }

    public Double getBqty() {
        return bqty;
    }

    public void setBqty(Double bqty) {
        this.bqty = bqty;
    }

    public Double getBtotal() {
        return btotal;
    }

    public void setBtotal(Double btotal) {
        this.btotal = btotal;
    }
}
