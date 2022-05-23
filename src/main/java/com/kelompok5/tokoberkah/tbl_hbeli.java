package com.kelompok5.tokoberkah;

public class tbl_hbeli {
    String kdtrans, tgl, jam, kasir, sup;
    Double total;

    public tbl_hbeli(String kdtrans, String tgl, String jam, String kasir, String sup, Double total) {
        this.kdtrans = kdtrans;
        this.tgl = tgl;
        this.jam = jam;
        this.kasir = kasir;
        this.sup = sup;
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

    public String getSup() {
        return sup;
    }

    public void setSup(String sup) {
        this.sup = sup;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }
}
