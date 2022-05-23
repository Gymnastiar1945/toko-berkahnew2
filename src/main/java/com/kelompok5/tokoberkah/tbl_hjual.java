package com.kelompok5.tokoberkah;

public class tbl_hjual {
    String kdtrans, tgl, jam, kasir;
    Double total;

    public tbl_hjual(String kdtrans, String tgl, String jam, String kasir, Double total) {
        this.kdtrans = kdtrans;
        this.tgl = tgl;
        this.jam = jam;
        this.kasir = kasir;
        this.total = total;
    }

    public String getKdtrans() {
        return kdtrans;
    }

    public void setKdtrans(String kdtrans) {
        this.kdtrans = kdtrans;
    }

    public String getTgl() {
        return tgl;
    }

    public void setTgl(String tgl) {
        this.tgl = tgl;
    }

    public String getJam() {
        return jam;
    }

    public void setJam(String jam) {
        this.jam = jam;
    }

    public String getKasir() {
        return kasir;
    }

    public void setKasir(String kasir) {
        this.kasir = kasir;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
