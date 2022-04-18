package com.kelompok5.tokoberkah;

public class tbl_dbbarang {
    int colno;
    String colbar, colnama, colktgr;
    Double colqty;
    String colsatuan;

    public tbl_dbbarang(int colno, String colbar, String colnama, String colktgr, Double colqty, String colsatuan) {
        this.colno = colno;
        this.colbar = colbar;
        this.colnama = colnama;
        this.colktgr = colktgr;
        this.colqty = colqty;
        this.colsatuan = colsatuan;
    }

    public int getColno() {
        return colno;
    }

    public void setColno(int colno) {
        this.colno = colno;
    }

    public String getColbar() {
        return colbar;
    }

    public void setColbar(String colbar) {
        this.colbar = colbar;
    }

    public String getColnama() {
        return colnama;
    }

    public void setColnama(String colnama) {
        this.colnama = colnama;
    }

    public String getColktgr() {
        return colktgr;
    }

    public void setColktgr(String colktgr) {
        this.colktgr = colktgr;
    }

    public Double getColqty() {
        return colqty;
    }

    public void setColqty(Double colqty) {
        this.colqty = colqty;
    }

    public String getColsatuan() {
        return colsatuan;
    }

    public void setColsatuan(String colsatuan) {
        this.colsatuan = colsatuan;
    }
}
