package com.kelompok5.tokoberkah;

public class tbl_transpopjual {
    String popjkdbar, popjnamabar;
    int popjharga;
    Double popjqty;
    String popjsatuan;

    public tbl_transpopjual(String popjkdbar, String popjnamabar, int popjharga, Double popjqty, String popjsatuan) {
        this.popjkdbar = popjkdbar;
        this.popjnamabar = popjnamabar;
        this.popjharga = popjharga;
        this.popjqty = popjqty;
        this.popjsatuan = popjsatuan;
    }

    public String getPopjkdbar() {
        return popjkdbar;
    }

    public void setPopjkdbar(String popjkdbar) {
        this.popjkdbar = popjkdbar;
    }

    public String getPopjnamabar() {
        return popjnamabar;
    }

    public void setPopjnamabar(String popjnamabar) {
        this.popjnamabar = popjnamabar;
    }

    public int getPopjharga() {
        return popjharga;
    }

    public void setPopjharga(int popjharga) {
        this.popjharga = popjharga;
    }

    public Double getPopjqty() {
        return popjqty;
    }

    public void setPopjqty(Double popjqty) {
        this.popjqty = popjqty;
    }

    public String getPopjsatuan() {
        return popjsatuan;
    }

    public void setPopjsatuan(String popjsatuan) {
        this.popjsatuan = popjsatuan;
    }
}
