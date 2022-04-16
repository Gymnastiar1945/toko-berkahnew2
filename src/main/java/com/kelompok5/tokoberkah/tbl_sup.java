package com.kelompok5.tokoberkah;

public class tbl_sup {
    String idsup, namasup, nomorsup, alamatsup;

    public tbl_sup(String idsup, String namasup, String nomorsup, String alamatsup) {
        this.idsup = idsup;
        this.namasup = namasup;
        this.nomorsup = nomorsup;
        this.alamatsup = alamatsup;
    }

    public String getIdsup() {
        return idsup;
    }

    public void setIdsup(String idsup) {
        this.idsup = idsup;
    }

    public String getNamasup() {
        return namasup;
    }

    public void setNamasup(String namasup) {
        this.namasup = namasup;
    }

    public String getNomorsup() {
        return nomorsup;
    }

    public void setNomorsup(String nomorsup) {
        this.nomorsup = nomorsup;
    }

    public String getAlamatsup() {
        return alamatsup;
    }

    public void setAlamatsup(String alamatsup) {
        this.alamatsup = alamatsup;
    }
}
