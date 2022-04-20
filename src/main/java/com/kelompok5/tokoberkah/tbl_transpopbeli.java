package com.kelompok5.tokoberkah;

public class tbl_transpopbeli {
    String popbkdbar, popbnamabar;
    Double popbqty;
    String popbsatuan;

    public tbl_transpopbeli(String popbkdbar, String popbnamabar, Double popbqty, String popbsatuan) {
        this.popbkdbar = popbkdbar;
        this.popbnamabar = popbnamabar;
        this.popbqty = popbqty;
        this.popbsatuan = popbsatuan;
    }

    public String getPopbkdbar() {
        return popbkdbar;
    }

    public void setPopbkdbar(String popbkdbar) {
        this.popbkdbar = popbkdbar;
    }

    public String getPopbnamabar() {
        return popbnamabar;
    }

    public void setPopbnamabar(String popbnamabar) {
        this.popbnamabar = popbnamabar;
    }

    public Double getPopbqty() {
        return popbqty;
    }

    public void setPopbqty(Double popbqty) {
        this.popbqty = popbqty;
    }

    public String getPopbsatuan() {
        return popbsatuan;
    }

    public void setPopbsatuan(String popbsatuan) {
        this.popbsatuan = popbsatuan;
    }
}