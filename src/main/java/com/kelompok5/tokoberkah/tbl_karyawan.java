package com.kelompok5.tokoberkah;

public class tbl_karyawan {
    String idkar;
    String namakar;
    String nomorkar;
    String alamatkar;
    String jeniskar;
    String pwkar;

    public tbl_karyawan(String idkar, String namakar, String nomorkar, String alamatkar, String jeniskar, String pwkar) {
        this.idkar = idkar;
        this.namakar = namakar;
        this.nomorkar = nomorkar;
        this.alamatkar = alamatkar;
        this.jeniskar = jeniskar;
        this.pwkar = pwkar;
    }

    public String getIdkar() {
        return idkar;
    }

    public void setIdkar(String idkar) {
        this.idkar = idkar;
    }

    public String getNamakar() {
        return namakar;
    }

    public void setNamakar(String namakar) {
        this.namakar = namakar;
    }

    public String getNomorkar() {
        return nomorkar;
    }

    public void setNomorkar(String nomorkar) {
        this.nomorkar = nomorkar;
    }

    public String getAlamatkar() {
        return alamatkar;
    }

    public void setAlamatkar(String alamatkar) {
        this.alamatkar = alamatkar;
    }

    public String getJeniskar() {
        return jeniskar;
    }

    public void setJeniskar(String jeniskar) {
        this.jeniskar = jeniskar;
    }

    public String getPwkar() {
        return pwkar;
    }

    public void setPwkar(String pwkar) {
        this.pwkar = pwkar;
    }
}