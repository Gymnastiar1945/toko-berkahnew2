package com.kelompok5.tokoberkah;

import com.mysql.jdbc.Connection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.view.JasperViewer;


import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class Transaksi implements Initializable {

    Integer popjtfhrg;

    Double popjtfqtyy;

    @FXML
    private Label transakasi;

    @FXML
    private Button bcaribar;

    @FXML
    private Button bcheckout;

    @FXML
    private Button beditbar;

    @FXML
    private Pane blur;

    @FXML
    private Pane beliatas;

    @FXML
    private Pane belikanan;

    @FXML
    private Pane belikiri;

    @FXML
    private TableColumn<tbl_transbeli, Integer> bharga;

    @FXML
    private Button bhpsbar;

    @FXML
    private TableColumn<tbl_transbeli, String> bkdbar;

    @FXML
    private Label bkdtrans;

    @FXML
    private TableColumn<tbl_transbeli, String> bnamabar;

    @FXML
    private TableColumn<tbl_transbeli, String> bsatuan;

    @FXML
    private TableColumn<tbl_transbeli, Double> bqty;

    @FXML
    private ComboBox<String> bsup;

    @FXML
    private Button bswitch;

    @FXML
    private Button btambahbar;

    @FXML
    private TextField btfharga;

    @FXML
    private Label btfkdbar;

    @FXML
    private TextField btfkdbat;

    @FXML
    private Label btfnamabar;

    @FXML
    private TextField btfqty;

    @FXML
    private Label btfsatuan;

    @FXML
    private Label btftotal;

    @FXML
    private Label btgl;

    @FXML
    private TableColumn<tbl_transbeli, Double> btotal;

    @FXML
    private Pane checkoutatas;

    @FXML
    private Pane checkoutbawahkanan;

    @FXML
    private Pane checkoutbawahkiri;

    @FXML
    private Pane checkouttengah;

    @FXML
    private Button co_back;

    @FXML
    private Button co_back1;

    @FXML
    private TableColumn<tbl_transco, Integer> co_harga;

    @FXML
    private Label co_isilblkanan;

    @FXML
    private TextField co_isilblkiri;

    @FXML
    private TableColumn<tbl_transco, String> co_kdbar;

    @FXML
    private Label co_kdtrans;

    @FXML
    private Label co_lblgtot;

    @FXML
    private Label co_lblkanan;

    @FXML
    private Label co_lblkiri;

    @FXML
    private TableColumn<tbl_transco, String> co_namabar;

    @FXML
    private Button co_print;

    @FXML
    private TableColumn<tbl_transco, Double> co_qty;

    @FXML
    private TableColumn<tbl_transco, String> co_satuan;

    @FXML
    private TableView<tbl_transco> co_table;

    @FXML
    private Label co_tgl;

    @FXML
    private TableColumn<tbl_transco, Double> co_total;

    @FXML
    private Button jcaribar;

    @FXML
    private Button jcheckout;

    @FXML
    private Button jeditbar;

    @FXML
    private Label jgatot;

    @FXML
    private TableColumn<tbl_transjual, Integer> jharga;

    @FXML
    private Button jhpsbar;

    @FXML
    private TableColumn<tbl_transjual, String> jkdbar;

    @FXML
    private Label jkdtrans;

    @FXML
    private TableColumn<tbl_transjual, String> jnamabar;

    @FXML
    private TableColumn<tbl_transjual, Double> jqty;

    @FXML
    private TableColumn<tbl_transjual, String> jsatuan;

    @FXML
    private Button jswitch;

    @FXML
    private Label jtfharga;

    @FXML
    private Label jtfkdbar;

    @FXML
    private TextField jtfkdbat;

    @FXML
    private Label jtfnamabar;

    @FXML
    private TextField jtfqty;

    @FXML
    private Label jtfsatuan;

    @FXML
    private Label jtftotal;

    @FXML
    private Label jtgl;

    @FXML
    private TableColumn<tbl_transjual, Double> jtotal;

    @FXML
    private Pane jualatas;

    @FXML
    private Pane jualkanan;

    @FXML
    private Pane jualkiri;

    @FXML
    private TextField popbelicari;

    @FXML
    private Button popbend;

    @FXML
    private TableColumn<tbl_transpopbeli, String> popbkdbar;

    @FXML
    private TableColumn<tbl_transpopbeli, String> popbnamabar;

    @FXML
    private TableColumn<tbl_transpopbeli, Double> popbqty;

    @FXML
    private TableColumn<tbl_transpopbeli, String> popbsatuan;

    @FXML
    private Button popbtambahbar;

    @FXML
    private Button popjend;

    @FXML
    private TableColumn<tbl_transpopjual, Integer> popjharga;

    @FXML
    private TableColumn<tbl_transpopjual, String> popjkdbar;

    @FXML
    private TableColumn<tbl_transpopjual, String> popjnamabar;

    @FXML
    private TableColumn<tbl_transpopjual, Double> popjqty;

    @FXML
    private TableColumn<tbl_transpopjual, String> popjsatuan;

    @FXML
    private Button popjtambahbar;

    @FXML
    private Label poptfjnamabar;

    @FXML
    private TextField poptfjqty;

    @FXML
    private Label poptfjsat;

    @FXML
    private Label poptfjtot;

    @FXML
    private TextField popjualcari;

    @FXML
    private Pane popupbeli;

    @FXML
    private Pane popupjual;

    @FXML
    private Label menudash;

    @FXML
    private TableView<tbl_transbeli> tablebeli;

    @FXML
    private TableView<tbl_transjual> tablejual;

    @FXML
    private TableView<tbl_transpopbeli> tablepopbeli;

    @FXML
    private TableView<tbl_transpopjual> tablepopjual;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        setmainbeli();
        setmainjual();
    }

    //BELIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII

    void setmainbeli() {
        beliatas.setVisible(true);
        belikanan.setVisible(true);
        belikiri.setVisible(true);
        jualatas.setVisible(false);
        jualkanan.setVisible(false);
        jualkiri.setVisible(false);
        transakasi.setText("   Transaksi Pembelian");
        btfkdbat.requestFocus();
        setBkdtrans();
        setBtgl();
        setBsup();
        setTablebeli();
        cekcartbeli();
    }

    void cekcartbeli() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyyy-");
        LocalDateTime tanggal = LocalDateTime.now();
        String a = (dtf.format(tanggal));
        try {
            //--> melakukan eksekusi query untuk mengambil data dari tabel
            String sql = "SELECT MAX(id_pembelian) FROM cart_pembelian " +
                    "WHERE id_pembelian like '%" + a + "%' ;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            java.sql.ResultSet rs = pst.executeQuery(sql);
            while (rs.next()) {
                if (rs.getString(1) == null) {
                    try {
                        String sqll = "TRUNCATE TABLE cart_pembelian;";
                        java.sql.Connection connn = (Connection) Config.configDB();
                        java.sql.PreparedStatement pstl = connn.prepareStatement(sqll);
                        pstl.execute();
                    } catch (Exception e) {
                    }
                } else {
//                    System.out.println("kosong");
                }
            }
            rs.close();
        } catch(Exception e){
            e.printStackTrace();
        }

    }

    void setBkdtrans() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyyy-");
        LocalDateTime tanggal = LocalDateTime.now();
        String a = (dtf.format(tanggal));
        DateTimeFormatter dtff = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime tanggall = LocalDateTime.now();
        String aa = (dtff.format(tanggall));
        try {
            //--> melakukan eksekusi query untuk mengambil data dari tabel
            String sql = "SELECT MAX(id_pembelian) FROM pembelian " +
                    "WHERE tanggal_transaksi = '" + aa + "' ;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            java.sql.ResultSet rs = pst.executeQuery(sql);
            while (rs.next()) {
                if (rs.getString(1) == null) {
                    bkdtrans.setText("TB-" + a + "001");
                } else {
                    rs.last();
                    String auto = rs.getString(1);
                    auto = auto.replace("TB-" + a, "");
                    int auto_id = Integer.parseInt(auto) + 1;
                    String no = String.valueOf(auto_id);
                    int NomorJual = no.length();
                    //MENGATUR jumlah 0
                    for (int j = 0; j < 3 - NomorJual; j++) {
                        no = "0" + no;
                    }
                    bkdtrans.setText("TB-" + a + no);
                }
            }
            rs.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void setBtgl() {
        String mm = "";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM");
        LocalDateTime tanggal = LocalDateTime.now();
        String a = (dtf.format(tanggal));
        DateTimeFormatter dtff = DateTimeFormatter.ofPattern("dd");
        LocalDateTime tanggall = LocalDateTime.now();
        String aa = (dtff.format(tanggall));
        DateTimeFormatter dtfff = DateTimeFormatter.ofPattern("yyyy");
        LocalDateTime tanggalll = LocalDateTime.now();
        String yyyy = (dtfff.format(tanggalll));
        int b = Integer.parseInt(a);
        switch (b) {
            case 1:
                mm = ("Januari");
                break;
            case 2:
                mm = ("Februari");
                break;
            case 3:
                mm = ("Maret");
                break;
            case 4:
                mm = ("April");
                break;
            case 5:
                mm = ("Mei");
                break;
            case 6:
                mm = ("Juni");
                break;
            case 7:
                mm = ("Juli");
                break;
            case 8:
                mm = ("Agustus");
                break;
            case 9:
                mm = ("September");
                break;
            case 10:
                mm = ("Oktober");
                break;
            case 11:
                mm = ("November");
                break;
            case 12:
                mm = ("Desember");
                break;
        }
        btgl.setText(aa + " " + mm + " " + yyyy);
    }

    void setBsup() {
        ObservableList<String> list = FXCollections.observableArrayList();
        try {
            String sql = "select * from supplier";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()) {
                list.add(res.getString("nama_supplier"));
            }
        } catch (Exception e) {
        }
        bsup.setItems(list);
    }

    void setTablebeli() {
        ObservableList<tbl_transbeli> list = FXCollections.observableArrayList();
        try {
            String sql = "select cart_pembelian.id_barang, barang.nama_barang, " +
                    "cart_pembelian.harga_beli, cart_pembelian.qty, barang.id_satuan, cart_pembelian.harga_total " +
                    "from cart_pembelian join barang on cart_pembelian.id_barang = barang.id_barang"
                    + " where id_pembelian = '" + bkdtrans.getText() + "' ;";
            Connection conn = (Connection) Config.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()) {
                list.add(new tbl_transbeli(res.getString(1),
                        res.getString(2),
                        res.getInt(3),
                        res.getDouble(4),
                        res.getString(5),
                        res.getDouble(6)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        bkdbar.setCellValueFactory(new PropertyValueFactory<tbl_transbeli, String>("bkdbar"));
        bnamabar.setCellValueFactory(new PropertyValueFactory<tbl_transbeli, String>("bnamabar"));
        bharga.setCellValueFactory(new PropertyValueFactory<tbl_transbeli, Integer>("bharga"));
        bqty.setCellValueFactory(new PropertyValueFactory<tbl_transbeli, Double>("bqty"));
        bsatuan.setCellValueFactory(new PropertyValueFactory<tbl_transbeli, String>("bsatuan"));
        btotal.setCellValueFactory(new PropertyValueFactory<tbl_transbeli, Double>("btotal"));
        tablebeli.setItems(list);
    }

    @FXML
    void tablebeliklik(MouseEvent event) {
        ObservableList<tbl_transbeli> list;
        list = tablebeli.getSelectionModel().getSelectedItems();

        btfkdbar.setText(list.get(0).getBkdbar());
        btfnamabar.setText(list.get(0).getBnamabar());
        String hrg = String.valueOf(list.get(0).getBharga());
        btfharga.setText(hrg);
        String qty = String.valueOf(list.get(0).getBqty());
        btfqty.setText(qty);
        try {
            String sql = "SELECT satuan from satuan "
                    + "where id_satuan = '" + list.get(0).getBsatuan() + "';";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            java.sql.ResultSet rs = pst.executeQuery(sql);
            rs.next();
            btfsatuan.setText(rs.getString("satuan"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        String tot = String.valueOf(list.get(0).getBtotal());
        btftotal.setText(tot);
    }

    @FXML
    void bcaribaract(ActionEvent event) {
        blur.setVisible(true);
        popupbeli.setVisible(true);
        setTablepopbeli();
    }

    @FXML
    void bbarcodekey(KeyEvent event) {
        try {
            String sql = "select barang.id_barang, barang.nama_barang, satuan.satuan"
                    + " from barang join satuan on barang.id_satuan = satuan.id_satuan " +
                    "WHERE barcode = '" + btfkdbat.getText() + "' ;";
            Connection conn = (Connection) Config.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            res.next() ;
            btfkdbar.setText(res.getString(1));
            btfnamabar.setText(res.getString(2));
            btfsatuan.setText(res.getString(3));

        } catch (SQLException e) {
        }
    }

    @FXML
    void bbarcodeact(ActionEvent event) {
        if (!btfkdbar.getText().equals("")) {
            btfharga.requestFocus();
        } else {

        }
    }

    @FXML
    void bcheckoutact(ActionEvent event) {
        String tbl = String.valueOf(tablebeli.getItems());
        if (tbl == "[]") {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle(" kosong");
            alert.setHeaderText("Barang masih Kosong");
            alert.setContentText("Tambahkan dahulu barang yang ingin dibeli!");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Konfirmasi Checkout");
            alert.setHeaderText(null);
            alert.setContentText("apakah anda yakin untuk konfirmasi pembelian?");
            Optional<ButtonType> action = alert.showAndWait();

            if (action.get() == ButtonType.OK) {
                bcekout();
                maincobeli();
            }
        }

    }

    void bcekout() {
        String sup = "";
        try {
            String sql = "SELECT id_supplier from supplier "
                    + "where nama_supplier = '" + bsup.getSelectionModel().getSelectedItem() + "';";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            java.sql.ResultSet rs = pst.executeQuery(sql);
            rs.next();
            sup = rs.getString(1);

        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            String sqll = "insert into pembelian (id_pembelian, tanggal_transaksi, jam_transaksi, "
                    + "uang, id_pengguna, id_supplier) " +
                    "values ('" + bkdtrans.getText() + "', CURRENT_DATE, CURRENT_TIME, 0, "
                    + "'agim', '" + sup + "') ;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstl = conn.prepareStatement(sqll);
            pstl.execute();
//            Alert alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.setTitle("Berhasil");
//            alert.setHeaderText("Data berhasil disimpan");
//            alert.setContentText("Data Barang dengan Kode " + bkdtrans.getText() + " berhasil disimpan");
//            alert.showAndWait();
            String sql = "insert into detail_pembelian (`id_pembelian`, `id_barang`, "
                    + "`harga_beli`, `qty`, `harga_total`) "
                    + "SELECT id_pembelian, id_barang, harga_beli, qty, harga_total FROM cart_pembelian ;";
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Gagal");
            alert.setHeaderText("Data gagal disimpan!");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
        try {
            String sql = "TRUNCATE TABLE cart_pembelian;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
        } catch (Exception e) {
        }
    }

    @FXML
    void beditbaract(ActionEvent event) {
        if (btfkdbar.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle(" kosong");
            alert.setHeaderText("Kode Barang masih Kosong");
            alert.setContentText("Pilih dahulu barang yang ingin diedit!");
            alert.showAndWait();
        } else {
            try {
                String sqll = "UPDATE cart_pembelian "
                        + "SET harga_beli = '" + btfharga.getText()
                        + "', qty = '" + btfqty.getText()
                        + "', harga_total = '" + btftotal.getText()
                        + "' WHERE cart_pembelian.id_barang = '" + btfkdbar.getText() + "'";
                java.sql.Connection conn = (Connection) Config.configDB();
                java.sql.PreparedStatement pstl = conn.prepareStatement(sqll);
                pstl.execute();
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Gagal");
                alert.setHeaderText("Data gagal diedit!");
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }
            bkosong();
            setTablebeli();
        }
    }

    @FXML
    void bhpsbaract(ActionEvent event) {
        if (btfkdbar.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Kode kosong");
            alert.setHeaderText("Kode Barang masih Kosong");
            alert.setContentText("Pilih dahulu barang yang ingin dihapus");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Konfirmasi Hapus");
            alert.setHeaderText(null);
            alert.setContentText("apakah anda yakin ingin menghapus Data pembelian barang dengan Kode " + btfkdbar.getText() + "?");
            Optional<ButtonType> action = alert.showAndWait();

            if (action.get() == ButtonType.OK) {
                try {
                    String sql = "DELETE FROM cart_pembelian where id_barang='" + btfkdbar.getText() + "'";
                    java.sql.Connection conn = (Connection) Config.configDB();
                    java.sql.PreparedStatement pst = conn.prepareStatement(sql);
                    pst.execute();
                } catch (Exception e) {
                    Alert newalert = new Alert(Alert.AlertType.WARNING);
                    newalert.setTitle("Gagal");
                    newalert.setHeaderText("penghapusan data pembelian barang gagal");
                    newalert.setContentText(e.getMessage());
                    newalert.showAndWait();
                }
            }
            setTablebeli();
            bkosong();
        }
    }

    @FXML
    void bswitchact(ActionEvent event) {
        setmainjual();
    }

    @FXML
    void btambahbaract(ActionEvent event) {
        setbtambahbar();
    }
    void setbtambahbar() {
        if (btfkdbar.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("kosong");
            alert.setHeaderText("Kode Barang masih Kosong");
            alert.setContentText("Pilih Barang terlebih dahulu!");
            alert.showAndWait();
        } else {
            String bar = "";
            Double harga = null, hrg, qty;
            try {
                String sqll = "SELECT id_barang, harga_beli FROM cart_pembelian where id_barang='" + btfkdbar.getText() + "' ;";
                java.sql.Connection conn = (Connection) Config.configDB();
                java.sql.Statement stm = conn.createStatement();
                java.sql.ResultSet res = stm.executeQuery(sqll);
                res.next();
                bar = res.getString("id_barang");
                harga = res.getDouble("harga_beli");
            } catch (Exception e) {
            }
            if (bar.equals(btfkdbar.getText())) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Barang sudah ada");
                alert.setHeaderText("Barang sudah ada dalam keranjang!");
                alert.setContentText("Apakah anda ingin menambahkan kuantitasnya saja?");
                Optional<ButtonType> action = alert.showAndWait();

                if (action.get() == ButtonType.OK) {
                    qty = Double.parseDouble(btfqty.getText());
                    hrg = harga * qty;
                    try {
                        String sqll = "UPDATE cart_pembelian "
                                + "SET qty = qty+" + btfqty.getText()
                                + ", harga_total = harga_total+" + hrg
                                + " WHERE cart_pembelian.id_barang = '" + btfkdbar.getText() + "'";
                        java.sql.Connection conn = (Connection) Config.configDB();
                        java.sql.PreparedStatement pstl = conn.prepareStatement(sqll);
                        pstl.execute();
                    } catch (Exception e) {
                        Alert newalert = new Alert(Alert.AlertType.WARNING);
                        newalert.setTitle("Gagal");
                        newalert.setHeaderText("Data gagal diedit!");
                        newalert.setContentText(e.getMessage());
                        newalert.showAndWait();
                    }
                    bkosong();
                    setTablebeli();
                } else {

                }
            } else {
                try {
                    String sqll = "INSERT INTO `cart_pembelian` (`id_pembelian`, `id_barang`, `harga_beli`, `qty`, `harga_total`)" +
                            " VALUES ('" + bkdtrans.getText() + "', '"
                            + btfkdbar.getText() + "', '"
                            + btfharga.getText() + "', '"
                            + btfqty.getText() + "', '"
                            + btftotal.getText() + "'); ";
                    java.sql.Connection conn = (Connection) Config.configDB();
                    java.sql.PreparedStatement pstl = conn.prepareStatement(sqll);
                    pstl.execute();
                } catch (Exception e) {
                    Alert newalert = new Alert(Alert.AlertType.WARNING);
                    newalert.setTitle("Gagal");
                    newalert.setHeaderText("Data gagal ditambah!");
                    newalert.setContentText(e.getMessage());
                    newalert.showAndWait();
                }
                bkosong();
                setTablebeli();
            }

        }
    }

    void bkosong() {
        btfkdbar.setText("");
        btfnamabar.setText(null);
        btfkdbat.setText(null);
        btfharga.setText(null);
        btfqty.setText(null);
        btfsatuan.setText(null);
        btftotal.setText(null);
        btfkdbat.requestFocus();
    }

    //CHECKOUT BELIIIIIIIII

    void maincobeli() {
        setCo_tablebeli();
        setlblcobeli();
    }

    @FXML
    void co_back1act(ActionEvent event) {
        checkoutatas.setVisible(false);
        checkouttengah.setVisible(false);
        checkoutbawahkanan.setVisible(false);
        checkoutbawahkiri.setVisible(false);
        setmainjual();
        try {
            String sql = "TRUNCATE TABLE cart_penjualan;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
        } catch (Exception e) {
        }
    }

    @FXML
    void co_backact(ActionEvent event) {
        checkoutatas.setVisible(false);
        checkouttengah.setVisible(false);
        checkoutbawahkanan.setVisible(false);
        checkoutbawahkiri.setVisible(false);
        setmainbeli();
        try {
            String sql = "TRUNCATE TABLE cart_pembelian;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
        } catch (Exception e) {
        }
    }



    void setCo_tablebeli() {
        ObservableList<tbl_transco> list = FXCollections.observableArrayList();
        try {
            String sql = "select detail_pembelian.id_barang, barang.nama_barang, " +
                    "detail_pembelian.harga_beli, detail_pembelian.qty, barang.id_satuan, detail_pembelian.harga_total " +
                    "from detail_pembelian join barang on detail_pembelian.id_barang = barang.id_barang"
                    + " where id_pembelian = '" + bkdtrans.getText() + "' ;";
            Connection conn = (Connection) Config.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()) {
                list.add(new tbl_transco(res.getString(1),
                        res.getString(2),
                        res.getInt(3),
                        res.getDouble(4),
                        res.getString(5),
                        res.getDouble(6)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        co_kdbar.setCellValueFactory(new PropertyValueFactory<tbl_transco, String>("co_kdbar"));
        co_namabar.setCellValueFactory(new PropertyValueFactory<tbl_transco, String>("co_namabar"));
        co_harga.setCellValueFactory(new PropertyValueFactory<tbl_transco, Integer>("co_harga"));
        co_qty.setCellValueFactory(new PropertyValueFactory<tbl_transco, Double>("co_qty"));
        co_satuan.setCellValueFactory(new PropertyValueFactory<tbl_transco, String>("co_satuan"));
        co_total.setCellValueFactory(new PropertyValueFactory<tbl_transco, Double>("co_total"));
        co_table.setItems(list);
    }

    void setlblcobeli() {
        checkoutatas.setVisible(true);
        checkouttengah.setVisible(true);
        checkoutbawahkanan.setVisible(true);
        checkoutbawahkiri.setVisible(true);
        co_print.setVisible(false);
        beliatas.setVisible(false);
        belikanan.setVisible(false);
        belikiri.setVisible(false);
        co_back.setVisible(true);
        co_back1.setVisible(false);
        co_kdtrans.setText(bkdtrans.getText());
        co_tgl.setText(btgl.getText());
        co_isilblkiri.setVisible(false);
        co_lblkiri.setText("Supplier : " + bsup.getSelectionModel().getSelectedItem());
        co_lblkanan.setText("Total Barang");
        try {
            String sql = "SELECT uang from pembelian" +
                    " WHERE id_pembelian = '" + co_kdtrans.getText() + "' ;";
            Connection conn = (Connection) Config.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            res.next();
            co_lblgtot.setText("Rp. " + res.getString("uang"));
        } catch (SQLException e) {
            e.printStackTrace();
        }
        try {
            String sql = "SELECT COUNT(id_barang) as totbar from detail_pembelian" +
                    " WHERE id_pembelian = '" + co_kdtrans.getText() + "' ;";
            Connection conn = (Connection) Config.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            res.next();
            co_isilblkanan.setText(res.getString("totbar"));
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }

    //CHECKOUT JUALLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL

    void setmaincojual() {
        setlblcojual();
        setCo_tablejual();
    }
    void setCo_tablejual() {
        ObservableList<tbl_transco> list = FXCollections.observableArrayList();
        try {
            String sql = "select detail_penjualan.id_barang, barang.nama_barang, " +
                    "barang.harga_jual, detail_penjualan.qty, barang.id_satuan, detail_penjualan.harga_total " +
                    "from detail_penjualan join barang on detail_penjualan.id_barang = barang.id_barang"
                    + " where id_penjualan = '" + jkdtrans.getText() + "' ;";
            Connection conn = (Connection) Config.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()) {
                list.add(new tbl_transco(res.getString(1),
                        res.getString(2),
                        res.getInt(3),
                        res.getDouble(4),
                        res.getString(5),
                        res.getDouble(6)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        co_kdbar.setCellValueFactory(new PropertyValueFactory<tbl_transco, String>("co_kdbar"));
        co_namabar.setCellValueFactory(new PropertyValueFactory<tbl_transco, String>("co_namabar"));
        co_harga.setCellValueFactory(new PropertyValueFactory<tbl_transco, Integer>("co_harga"));
        co_qty.setCellValueFactory(new PropertyValueFactory<tbl_transco, Double>("co_qty"));
        co_satuan.setCellValueFactory(new PropertyValueFactory<tbl_transco, String>("co_satuan"));
        co_total.setCellValueFactory(new PropertyValueFactory<tbl_transco, Double>("co_total"));
        co_table.setItems(list);
    }

    void setlblcojual() {
        checkoutatas.setVisible(true);
        checkouttengah.setVisible(true);
        checkoutbawahkanan.setVisible(true);
        checkoutbawahkiri.setVisible(true);
        co_print.setVisible(true);
        jualatas.setVisible(false);
        jualkanan.setVisible(false);
        jualkiri.setVisible(false);
        beliatas.setVisible(false);
        belikanan.setVisible(false);
        belikiri.setVisible(false);
        co_back.setVisible(false);
        co_back1.setVisible(true);
        co_kdtrans.setText(jkdtrans.getText());
        co_tgl.setText(jtgl.getText());
        co_isilblkiri.setVisible(true);
        try {
            String sql = "SELECT total_bayar from penjualan" +
                    " WHERE id_penjualan = '" + co_kdtrans.getText() + "' ;";
            Connection conn = (Connection) Config.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            res.next();
            co_lblgtot.setText("Rp. " + res.getString(1));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void co_isilblkirikey(KeyEvent event) {
        if (co_isilblkiri.getText().equals("")) {

        } else {
            String total = co_lblgtot.getText();
            total = total.replace("Rp. ", "");
            int ttl = Integer.parseInt(total), uang = Integer.parseInt(co_isilblkiri.getText());
            int kembalian = uang - ttl;
            co_isilblkanan.setText("Rp. " + kembalian);
        }
    }

    @FXML
    void co_printact(ActionEvent event) {
        String balik = co_isilblkanan.getText();
        balik = balik.replace("Rp. ", "");
        try {
            String sqll = "UPDATE penjualan "
                    + "SET uang = '" + co_isilblkiri.getText()
                    + "', kembalian = '" +balik
                    + "' WHERE penjualan.id_penjualan = '" + jkdtrans.getText() + "'";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstl = conn.prepareStatement(sqll);
            pstl.execute();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Gagal");
            alert.setHeaderText("Data gagal diedit!");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }

        try {
            java.sql.Connection conn=(Connection)Config.configDB();
//        String namafile = "src/kasir/report.jrxml";
            InputStream report = getClass().getResourceAsStream("report/trans.jasper");
            HashMap param = new HashMap();
            param.put("kd_trans", co_kdtrans.getText());
//        File file = new File(namafile);
//        JasperDesign jd = JRXmlLoader.load(namafile);
//        JasperReport jr = JasperCompileManager.compileReport(jd);
            JasperPrint jp = JasperFillManager.fillReport(report,param,conn);
            JasperViewer.viewReport(jp, false);
        } catch(Exception e) {
            e.printStackTrace();
        }
    }

    //JUALLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL

    void setmainjual() {
        jualatas.setVisible(true);
        jualkanan.setVisible(true);
        jualkiri.setVisible(true);
        beliatas.setVisible(false);
        belikanan.setVisible(false);
        belikiri.setVisible(false);
        transakasi.setText("   Transaksi Penjualan");
        jtfkdbat.requestFocus();

        setJtgl();
        setJkdtrans();
        setTablejual();
        cekcartjual();
    }

    void cekcartjual() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyyy-");
        LocalDateTime tanggal = LocalDateTime.now();
        String a = (dtf.format(tanggal));
        try {
            //--> melakukan eksekusi query untuk mengambil data dari tabel
            String sql = "SELECT MAX(id_penjualan) FROM cart_penjualan " +
                    "WHERE id_penjualan like '%" + a + "%' ;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            java.sql.ResultSet rs = pst.executeQuery(sql);
            while (rs.next()) {
                if (rs.getString(1) == null) {
                    try {
                        String sqll = "TRUNCATE TABLE cart_penjualan;";
                        java.sql.Connection connn = (Connection) Config.configDB();
                        java.sql.PreparedStatement pstl = connn.prepareStatement(sqll);
                        pstl.execute();
                    } catch (Exception e) {
                    }
                } else {
//                    System.out.println("kosong");
                }
            }
            rs.close();
        } catch(Exception e){
            e.printStackTrace();
        }

    }

    void setJkdtrans() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyyy-");
        LocalDateTime tanggal = LocalDateTime.now();
        String a = (dtf.format(tanggal));
        DateTimeFormatter dtff = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime tanggall = LocalDateTime.now();
        String aa = (dtff.format(tanggall));
        try {
            //--> melakukan eksekusi query untuk mengambil data dari tabel
            String sql = "SELECT MAX(id_penjualan) FROM penjualan " +
                    "WHERE tanggal_transaksi = '" + aa + "' ;" ;
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            java.sql.ResultSet rs = pst.executeQuery(sql);
            while (rs.next()) {
                if (rs.getString(1) == null) {
                    jkdtrans.setText("TR-" + a + "001");
                } else {
                    rs.last();
                    String auto = rs.getString(1);
                    auto = auto.replace("TR-" + a, "");
                    int auto_id = Integer.parseInt(auto) + 1;
                    String no = String.valueOf(auto_id);
                    int NomorJual = no.length();
                    //MENGATUR jumlah 0
                    for (int j = 0; j < 3 - NomorJual; j++) {
                        no = "0" + no;
                    }
                    jkdtrans.setText("TR-" + a + no);
                }
            }
            rs.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    void setJtgl() {
        String mm = "";
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM");
        LocalDateTime tanggal = LocalDateTime.now();
        String a = (dtf.format(tanggal));
        DateTimeFormatter dtff = DateTimeFormatter.ofPattern("dd");
        LocalDateTime tanggall = LocalDateTime.now();
        String aa = (dtff.format(tanggall));
        DateTimeFormatter dtfff = DateTimeFormatter.ofPattern("yyyy");
        LocalDateTime tanggalll = LocalDateTime.now();
        String yyyy = (dtfff.format(tanggalll));
        int b = Integer.parseInt(a);
        switch (b) {
            case 1:
                mm = ("Januari");
                break;
            case 2:
                mm = ("Februari");
                break;
            case 3:
                mm = ("Maret");
                break;
            case 4:
                mm = ("April");
                break;
            case 5:
                mm = ("Mei");
                break;
            case 6:
                mm = ("Juni");
                break;
            case 7:
                mm = ("Juli");
                break;
            case 8:
                mm = ("Agustus");
                break;
            case 9:
                mm = ("September");
                break;
            case 10:
                mm = ("Oktober");
                break;
            case 11:
                mm = ("November");
                break;
            case 12:
                mm = ("Desember");
                break;
        }
        jtgl.setText(aa + " " + mm + " " + yyyy);
    }

    void setTablejual() {
        ObservableList<tbl_transjual> list = FXCollections.observableArrayList();
        try {
            String sql = "select cart_penjualan.id_barang, barang.nama_barang, barang.harga_jual, " +
                    "cart_penjualan.qty, barang.id_satuan, cart_penjualan.harga_total " +
                    "from cart_penjualan join barang on cart_penjualan.id_barang = barang.id_barang"
                    + " where id_penjualan = '" + jkdtrans.getText() + "' ;";
            Connection conn = (Connection) Config.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()) {
                list.add(new tbl_transjual(res.getString(1),
                        res.getString(2),
                        res.getInt(3),
                        res.getDouble(4),
                        res.getString(5),
                        res.getDouble(6)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        jkdbar.setCellValueFactory(new PropertyValueFactory<tbl_transjual, String>("jkdbar"));
        jnamabar.setCellValueFactory(new PropertyValueFactory<tbl_transjual, String>("jnamabar"));
        jharga.setCellValueFactory(new PropertyValueFactory<tbl_transjual, Integer>("jharga"));
        jqty.setCellValueFactory(new PropertyValueFactory<tbl_transjual, Double>("jqty"));
        jsatuan.setCellValueFactory(new PropertyValueFactory<tbl_transjual, String>("jsatuan"));
        jtotal.setCellValueFactory(new PropertyValueFactory<tbl_transjual, Double>("jtotal"));
        tablejual.setItems(list);

        try {
            String sql = "SELECT sum(harga_total) as total from cart_penjualan "
                    + "where id_penjualan = '"+jkdtrans.getText()+"' ;";
            java.sql.Connection conn = (Connection) Config.configDB();
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery(sql);
            rs.next();
                jgatot.setText("Rp. "+rs.getInt("total"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void jcaribaract(ActionEvent event) {
        blur.setVisible(true);
        popupjual.setVisible(true);
        setTablepopjual();

    }

    @FXML
    void jbarcodekey(KeyEvent event) {
        try {
            String sql = "select barang.id_barang, barang.nama_barang, barang.harga_jual, satuan.satuan"
                    + " from barang join satuan on barang.id_satuan = satuan.id_satuan " +
                    "WHERE barcode = '" + jtfkdbat.getText() + "' ;";
            Connection conn = (Connection) Config.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            res.next() ;
                jtfkdbar.setText(res.getString(1));
                        jtfnamabar.setText(res.getString(2));
                        jtfharga.setText(String.valueOf(res.getInt(3)));
                        jtfsatuan.setText(res.getString(4));
                        jtfqty.setText("1");

                double qty = Double.parseDouble(jtfqty.getText()), hrg = Double.parseDouble(jtfharga.getText());
                Double tot = hrg * qty;
                jtftotal.setText(String.valueOf(tot));
        } catch (SQLException e) {
        }
    }

    @FXML
    void jbarcodeact(ActionEvent event) {
        System.out.println(jtfkdbat.getText());

        String bar = "", kd = jtfkdbar.getText();
        try {
            String sqll = "SELECT id_barang FROM cart_penjualan where id_barang='" + kd + "' ;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sqll);
            res.next();
            bar = res.getString("id_barang");
        } catch (Exception e) {
        }
        if (bar.equals(kd)) {
                try {
                    String sqll = "UPDATE cart_penjualan "
                            + "SET qty = qty+" + jtfqty.getText()
                            + ", harga_total = harga_total+" + jtftotal.getText()
                            + " WHERE cart_penjualan.id_barang = '" + kd + "'";
                    java.sql.Connection conn = (Connection) Config.configDB();
                    java.sql.PreparedStatement pstl = conn.prepareStatement(sqll);
                    pstl.execute();
                    jkosong();
                    setTablejual();
                } catch (Exception e) {
                    Alert newalert = new Alert(Alert.AlertType.WARNING);
                    newalert.setTitle("Gagal");
                    newalert.setHeaderText("Data gagal diedit!");
                    newalert.setContentText(e.getMessage());
                    newalert.showAndWait();
                }
        } else {
            try {
                String sqll = "INSERT INTO `cart_penjualan` (`id_penjualan`, `id_barang`, `qty`, `harga_total`)" +
                        " VALUES ('" + jkdtrans.getText() + "', '"
                        + kd + "', '"
                        + jtfqty.getText() + "', '"
                        + jtftotal.getText() + "'); ";
                java.sql.Connection conn = (Connection) Config.configDB();
                java.sql.PreparedStatement pstl = conn.prepareStatement(sqll);
                pstl.execute();
                jkosong();
                setTablejual();
            } catch (Exception e) {
                Alert newalert = new Alert(Alert.AlertType.WARNING);
                newalert.setTitle("Gagal");
                newalert.setHeaderText("Data gagal ditambah!");
                newalert.setContentText(e.getMessage());
                newalert.showAndWait();
            }
        }

    }

    @FXML
    void jcheckoutact(ActionEvent event) {
        String tbl = String.valueOf(tablejual.getItems());
        if (tbl == "[]") {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle(" kosong");
            alert.setHeaderText("Barang masih Kosong");
            alert.setContentText("Tambahkan dahulu barang yang ingin dijual!");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Konfirmasi Checkout");
            alert.setHeaderText(null);
            alert.setContentText("apakah anda yakin untuk konfirmasi penjualan?");
            Optional<ButtonType> action = alert.showAndWait();

            if (action.get() == ButtonType.OK) {
                jcekout();
                setmaincojual();
            }
        }

    }

    void jcekout() {
        try {
            String sqll = "insert into penjualan (id_penjualan, tanggal_transaksi, jam_transaksi, "
                    + "total_bayar, uang, kembalian, id_pengguna) " +
                    "values ('" + jkdtrans.getText() + "', CURRENT_DATE, CURRENT_TIME, 0, 0, 0, "
                    + "'agim') ;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstl = conn.prepareStatement(sqll);
            pstl.execute();
//            Alert alert = new Alert(Alert.AlertType.INFORMATION);
//            alert.setTitle("Berhasil");
//            alert.setHeaderText("Data berhasil disimpan");
//            alert.setContentText("Data Barang dengan Kode " + bkdtrans.getText() + " berhasil disimpan");
//            alert.showAndWait();
            String sql = "insert into detail_penjualan (`id_penjualan`, `id_barang`, "
                    + " `qty`, `harga_total`) "
                    + "SELECT id_penjualan, id_barang, qty, harga_total FROM cart_penjualan ;";
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Gagal");
            alert.setHeaderText("Data gagal disimpan!");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
        try {
            String sql = "TRUNCATE TABLE cart_penjualan;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            pst.execute();
        } catch (Exception e) {
        }
    }

    @FXML
    void jeditbaract(ActionEvent event) {
        if (jtfkdbar.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle(" kosong");
            alert.setHeaderText("Kode Barang masih Kosong");
            alert.setContentText("Pilih dahulu barang yang ingin diedit!");
            alert.showAndWait();
        } else {
            try {
                String sqll = "UPDATE cart_penjualan "
                        + "SET qty = '" + jtfqty.getText()
                        + "', harga_total = '" + jtftotal.getText()
                        + "' WHERE cart_penjualan.id_barang = '" + jtfkdbar.getText() + "'";
                java.sql.Connection conn = (Connection) Config.configDB();
                java.sql.PreparedStatement pstl = conn.prepareStatement(sqll);
                pstl.execute();
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Gagal");
                alert.setHeaderText("Data gagal diedit!");
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }
            jkosong();
            setTablejual();
        }
    }

    void jkosong() {
        jtfkdbar.setText("");
        jtfkdbat.setText("");
        jtfnamabar.setText(null);
        jtfharga.setText(null);
        jtfqty.setText(null);
        jtfsatuan.setText(null);
        jtftotal.setText(null);
    }

    @FXML
    void jtfqtykey(KeyEvent event) {
        if (Objects.equals(jtfkdbar.getText(), "")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Barang kosong");
            alert.setHeaderText(null);
            alert.setContentText("Barang belum dipilih");
        } else {
            double qty = Double.parseDouble(jtfqty.getText()), hrg = Double.parseDouble(jtfharga.getText());
            Double tot = hrg * qty;
            jtftotal.setText(String.valueOf(tot));
        }
    }

    @FXML
    void jhpsbaract(ActionEvent event) {
        if (jtfkdbar.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Kode kosong");
            alert.setHeaderText("Kode Barang masih Kosong");
            alert.setContentText("Pilih dahulu barang yang ingin dihapus");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Konfirmasi Hapus");
            alert.setHeaderText(null);
            alert.setContentText("apakah anda yakin ingin menghapus barang dengan Kode " + jtfkdbar.getText() + " dari keranjang?");
            Optional<ButtonType> action = alert.showAndWait();

            if (action.get() == ButtonType.OK) {
                try {
                    String sql = "DELETE FROM cart_penjualan where id_barang='" + jtfkdbar.getText() + "'";
                    java.sql.Connection conn = (Connection) Config.configDB();
                    java.sql.PreparedStatement pst = conn.prepareStatement(sql);
                    pst.execute();
                    setTablejual();
                    jkosong();
                } catch (Exception e) {
                    Alert newalert = new Alert(Alert.AlertType.WARNING);
                    newalert.setTitle("Gagal");
                    newalert.setHeaderText("penghapusan data pembelian barang gagal");
                    newalert.setContentText(e.getMessage());
                    newalert.showAndWait();
                }
            }
        }
    }

    @FXML
    void jswitchact(ActionEvent event) {
        setmainbeli();
    }

    //POPUP BELIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII

    private void setTablepopbeli() {
        ObservableList<tbl_transpopbeli> list = FXCollections.observableArrayList();
        try {
            String sql = "select barang.id_barang, barang.nama_barang, jumlah, satuan.satuan"
                    + " from barang join satuan on barang.id_satuan = satuan.id_satuan ;";
            Connection conn = (Connection) Config.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()) {
                list.add(new tbl_transpopbeli(res.getString(1),
                        res.getString(2),
                        res.getDouble(3),
                        res.getString(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        popbkdbar.setCellValueFactory(new PropertyValueFactory<tbl_transpopbeli, String>("popbkdbar"));
        popbnamabar.setCellValueFactory(new PropertyValueFactory<tbl_transpopbeli, String>("popbnamabar"));
        popbqty.setCellValueFactory(new PropertyValueFactory<tbl_transpopbeli, Double>("popbqty"));
        popbsatuan.setCellValueFactory(new PropertyValueFactory<tbl_transpopbeli, String>("popbsatuan"));
        tablepopbeli.setItems(list);
    }

    @FXML
    void popbelicarikey(KeyEvent event) {
        ObservableList<tbl_transpopbeli> list = FXCollections.observableArrayList();
        try {
            String sql = "select barang.id_barang, barang.nama_barang, jumlah, satuan.satuan"
                    + " from barang join satuan on barang.id_satuan = satuan.id_satuan " +
                    "WHERE nama_barang like '%" + popbelicari.getText() + "%' ;";
            Connection conn = (Connection) Config.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()) {
                list.add(new tbl_transpopbeli(res.getString(1),
                        res.getString(2),
                        res.getDouble(3),
                        res.getString(4)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        popbkdbar.setCellValueFactory(new PropertyValueFactory<tbl_transpopbeli, String>("popbkdbar"));
        popbnamabar.setCellValueFactory(new PropertyValueFactory<tbl_transpopbeli, String>("popbnamabar"));
        popbqty.setCellValueFactory(new PropertyValueFactory<tbl_transpopbeli, Double>("popbqty"));
        popbsatuan.setCellValueFactory(new PropertyValueFactory<tbl_transpopbeli, String>("popbsatuan"));
        tablepopbeli.setItems(list);
    }

    @FXML
    void popbendact(ActionEvent event) {
        blur.setVisible(false);
        popupbeli.setVisible(false);
    }

    @FXML
    void popbtambahbaract(ActionEvent event) {
        ObservableList<tbl_transpopbeli> list;
        list = tablepopbeli.getSelectionModel().getSelectedItems();

        if (String.valueOf(list) == "[]") {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Kode kosong");
            alert.setHeaderText("Kode Barang masih Kosong");
            alert.setContentText("Pilih dahulu Kode barang dari tabel");
            alert.showAndWait();
        } else {
            btfkdbar.setText(list.get(0).getPopbkdbar());
            btfnamabar.setText(list.get(0).getPopbnamabar());
            btfsatuan.setText(list.get(0).getPopbsatuan());
            blur.setVisible(false);
            popupbeli.setVisible(false);
        }
    }

    @FXML
    void btfqtykey(KeyEvent event) {
        if (Objects.equals(btfharga.getText(), "")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Harga kosong");
            alert.setHeaderText(null);
            alert.setContentText("Form harga belum diisi");
        } else {
            int hrg = Integer.parseInt(btfharga.getText());
            double qty = Double.parseDouble(btfqty.getText()), tot = hrg * qty;
            btftotal.setText(String.valueOf(tot));
        }
    }

    @FXML
    void btfqtyact(ActionEvent event) {
        setbtambahbar();
    }

    //POPUP JUALLLLLLLLLLLLLLLLLLLLLLLLLLL

    private void setTablepopjual() {
        ObservableList<tbl_transpopjual> list = FXCollections.observableArrayList();
        try {
            String sql = "select barang.id_barang, barang.nama_barang, barang.harga_jual, barang.jumlah, satuan.satuan"
                    + " from barang join satuan on barang.id_satuan = satuan.id_satuan ;";
            Connection conn = (Connection) Config.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()) {
                list.add(new tbl_transpopjual(res.getString(1),
                        res.getString(2),
                        res.getInt(3),
                        res.getDouble(4),
                        res.getString(5)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        popjkdbar.setCellValueFactory(new PropertyValueFactory<tbl_transpopjual, String>("popjkdbar"));
        popjnamabar.setCellValueFactory(new PropertyValueFactory<tbl_transpopjual, String>("popjnamabar"));
        popjharga.setCellValueFactory(new PropertyValueFactory<tbl_transpopjual, Integer>("popjharga"));
        popjqty.setCellValueFactory(new PropertyValueFactory<tbl_transpopjual, Double>("popjqty"));
        popjsatuan.setCellValueFactory(new PropertyValueFactory<tbl_transpopjual, String>("popjsatuan"));
        tablepopjual.setItems(list);
    }

    @FXML
    void popjualcarikey(KeyEvent event) {
        ObservableList<tbl_transpopjual> list = FXCollections.observableArrayList();
        try {
            String sql = "select barang.id_barang, barang.nama_barang, barang.harga_jual, barang.jumlah, satuan.satuan"
                    + " from barang join satuan on barang.id_satuan = satuan.id_satuan " +
                    "WHERE nama_barang like '%" + popjualcari.getText() + "%';";
            Connection conn = (Connection) Config.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()) {
                list.add(new tbl_transpopjual(res.getString(1),
                        res.getString(2),
                        res.getInt(3),
                        res.getDouble(4),
                        res.getString(5)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        popjkdbar.setCellValueFactory(new PropertyValueFactory<tbl_transpopjual, String>("popjkdbar"));
        popjnamabar.setCellValueFactory(new PropertyValueFactory<tbl_transpopjual, String>("popjnamabar"));
        popjharga.setCellValueFactory(new PropertyValueFactory<tbl_transpopjual, Integer>("popjharga"));
        popjqty.setCellValueFactory(new PropertyValueFactory<tbl_transpopjual, Double>("popjqty"));
        popjsatuan.setCellValueFactory(new PropertyValueFactory<tbl_transpopjual, String>("popjsatuan"));
        tablepopjual.setItems(list);
    }

    @FXML
    void popjendact(ActionEvent event) {
        blur.setVisible(false);
        popupjual.setVisible(false);
    }

    @FXML
    void popjtambahbaract(ActionEvent event) {
        ObservableList<tbl_transpopjual> list;
        list = tablepopjual.getSelectionModel().getSelectedItems();

        if (poptfjnamabar.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Barang kosong");
            alert.setHeaderText(null);
            alert.setContentText("Pilih dahulu barang dari tabel");
            alert.showAndWait();
        } else {
            if (popjtfqtyy < Double.parseDouble(poptfjqty.getText())) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Barang Lebih");
                alert.setHeaderText(null);
                alert.setContentText("Jumlah lebih dari kuantitas");
                alert.showAndWait();
            } else {
                String kd = list.get(0).getPopjkdbar();
                btfnamabar.setText(list.get(0).getPopjnamabar());
                btfsatuan.setText(list.get(0).getPopjsatuan());

                String bar = "";
                try {
                    String sqll = "SELECT id_barang FROM cart_penjualan where id_barang='" + kd + "' ;";
                    java.sql.Connection conn = (Connection) Config.configDB();
                    java.sql.Statement stm = conn.createStatement();
                    java.sql.ResultSet res = stm.executeQuery(sqll);
                    res.next();
                    bar = res.getString("id_barang");
                } catch (Exception e) {
                }
                if (bar.equals(kd)) {
                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Barang sudah ada");
                    alert.setHeaderText("Barang sudah ada dalam keranjang!");
                    alert.setContentText("Apakah anda ingin menambahkan kuantitasnya saja?");
                    Optional<ButtonType> action = alert.showAndWait();

                    if (action.get() == ButtonType.OK) {
                        try {
                            String sqll = "UPDATE cart_penjualan "
                                    + "SET qty = qty+" + poptfjqty.getText()
                                    + ", harga_total = harga_total+" + poptfjtot.getText()
                                    + " WHERE cart_penjualan.id_barang = '" + kd + "'";
                            java.sql.Connection conn = (Connection) Config.configDB();
                            java.sql.PreparedStatement pstl = conn.prepareStatement(sqll);
                            pstl.execute();
                            popjkosong();
                            setTablejual();
                            blur.setVisible(false);
                            popupjual.setVisible(false);
                        } catch (Exception e) {
                            Alert newalert = new Alert(Alert.AlertType.WARNING);
                            newalert.setTitle("Gagal");
                            newalert.setHeaderText("Data gagal diedit!");
                            newalert.setContentText(e.getMessage());
                            newalert.showAndWait();
                        }
                    } else {

                    }
                } else {
                    try {
                        String sqll = "INSERT INTO `cart_penjualan` (`id_penjualan`, `id_barang`, `qty`, `harga_total`)" +
                                " VALUES ('" + jkdtrans.getText() + "', '"
                                + kd + "', '"
                                + poptfjqty.getText() + "', '"
                                + poptfjtot.getText() + "'); ";
                        java.sql.Connection conn = (Connection) Config.configDB();
                        java.sql.PreparedStatement pstl = conn.prepareStatement(sqll);
                        pstl.execute();
                        popjkosong();
                        setTablejual();
                        blur.setVisible(false);
                        popupjual.setVisible(false);
                    } catch (Exception e) {
                        Alert newalert = new Alert(Alert.AlertType.WARNING);
                        newalert.setTitle("Gagal");
                        newalert.setHeaderText("Data gagal ditambah!");
                        newalert.setContentText(e.getMessage());
                        newalert.showAndWait();
                    }
                }

            }
        }
    }

    @FXML
    void tablejualklik(MouseEvent event) {
        ObservableList<tbl_transjual> list;
        list = tablejual.getSelectionModel().getSelectedItems();

        jtfkdbar.setText(list.get(0).getJkdbar());
        jtfnamabar.setText(list.get(0).getJnamabar());
        try {
            String sql = "SELECT barcode from barang "
                    + "where id_barang = '" + list.get(0).getJkdbar() + "';";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            java.sql.ResultSet rs = pst.executeQuery(sql);
            while (rs.next()) {
                jtfkdbat.setText(rs.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        String hrg = String.valueOf(list.get(0).getJharga());
        jtfharga.setText(hrg);
        String qty = String.valueOf(list.get(0).getJqty());
        jtfqty.setText(qty);
        try {
            String sql = "SELECT satuan from satuan "
                    + "where id_satuan = '" + list.get(0).getJsatuan() + "';";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            java.sql.ResultSet rs = pst.executeQuery(sql);
            rs.next();
            jtfsatuan.setText(rs.getString("satuan"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
        String tot = String.valueOf(list.get(0).getJtotal());
        jtftotal.setText(tot);
    }

    @FXML
    void tablepopbeliklik(MouseEvent event) {

    }

    @FXML
    void tablepopjualklik(MouseEvent event) {
        ObservableList<tbl_transpopjual> list;
        list = tablepopjual.getSelectionModel().getSelectedItems();

        poptfjnamabar.setText(list.get(0).getPopjnamabar());
        popjtfhrg = list.get(0).getPopjharga();
        popjtfqtyy = list.get(0).getPopjqty();
        poptfjsat.setText(list.get(0).getPopjsatuan());

    }

    @FXML
    void poptfjqtyklik(KeyEvent event) {
        if (Objects.equals(poptfjnamabar.getText(), "")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Barang kosong");
            alert.setHeaderText(null);
            alert.setContentText("Barang belum dipilih");
        } else {
            double qty = Double.parseDouble(poptfjqty.getText());
            Double tot = popjtfhrg * qty;
            poptfjtot.setText(String.valueOf(tot));
        }

    }

    void popjkosong() {
        poptfjnamabar.setText("");
        poptfjqty.setText(null);
        poptfjsat.setText(null);
        poptfjtot.setText(null);
    }

    //MENUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUU

    @FXML
    void menudashklik(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void logoutklik(MouseEvent event) {

    }

    @FXML
    void menugudangklik(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("gudang.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void menukarklik(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("karyawan.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void menureturklik(MouseEvent event) {

    }

    @FXML
    void menuriwayatklik(MouseEvent event) {

    }

    @FXML
    void menusetklik(MouseEvent event) {

    }

    @FXML
    void menutransklik(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("transaksi.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
