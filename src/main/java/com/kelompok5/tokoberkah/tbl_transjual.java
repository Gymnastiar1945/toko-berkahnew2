package com.kelompok5.tokoberkah;

public class tbl_transjual {
    String jkdbar,jnamabar;
    int jharga;
    Double jqty;
    String jsatuan;
    Double jtotal;

    public tbl_transjual(String jkdbar, String jnamabar, int jharga, Double jqty, String jsatuan, Double jtotal) {
        this.jkdbar = jkdbar;
        this.jnamabar = jnamabar;
        this.jharga = jharga;
        this.jqty = jqty;
        this.jsatuan = jsatuan;
        this.jtotal = jtotal;
    }

    public String getJkdbar() {
        return jkdbar;
    }

    public void setJkdbar(String jkdbar) {
        this.jkdbar = jkdbar;
    }

    public String getJnamabar() {
        return jnamabar;
    }

    public void setJnamabar(String jnamabar) {
        this.jnamabar = jnamabar;
    }

    public int getJharga() {
        return jharga;
    }

    public void setJharga(int jharga) {
        this.jharga = jharga;
    }

    public Double getJqty() {
        return jqty;
    }

    public void setJqty(Double jqty) {
        this.jqty = jqty;
    }

    public String getJsatuan() {
        return jsatuan;
    }

    public void setJsatuan(String jsatuan) {
        this.jsatuan = jsatuan;
    }

    public Double getJtotal() {
        return jtotal;
    }

    public void setJtotal(Double jtotal) {
        this.jtotal = jtotal;
    }
}
