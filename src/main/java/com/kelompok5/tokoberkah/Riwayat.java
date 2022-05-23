package com.kelompok5.tokoberkah;

import com.mysql.jdbc.Connection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.util.StringConverter;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class Riwayat implements Initializable {

    @FXML
    private DatePicker hjexporttgldari;

    @FXML
    private Pane belidetail;

    @FXML
    private Pane exportbeli;

    @FXML
    private Pane exportjual;

    @FXML
    private Pane hbatas;

    @FXML
    private TextField hbcari;

    @FXML
    private Button hbdetail;

    @FXML
    private TableColumn<tbl_transco, Integer> hbdetailharga;

    @FXML
    private Label hbdetailkasir;

    @FXML
    private TableColumn<tbl_transco, String> hbdetailkdbar;

    @FXML
    private Label hbdetailkdtrans;

    @FXML
    private Button hbdetailkembali;

    @FXML
    private TableColumn<tbl_transco, String> hbdetailnamabar;

    @FXML
    private Button hbdetailprint;

    @FXML
    private TableColumn<tbl_transco, Double> hbdetailqty;

    @FXML
    private TableColumn<tbl_transco, String> hbdetailsatuan;

    @FXML
    private TableColumn<tbl_transco, Double> hbdetailtotal;

    @FXML
    private Label hbdetailjam;

    @FXML
    private Label hbdetailgtotal;

    @FXML
    private Button hbexport;

    @FXML
    private Button hbexportexport;

    @FXML
    private TableColumn<?, ?> hbexportkasir;

    @FXML
    private TableColumn<?, ?> hbexportkdtrans;

    @FXML
    private Button hbexportkembali;

    @FXML
    private TableColumn<?, ?> hbexporttgl;

    @FXML
    private TableColumn<?, ?> hbexporttotal;

    @FXML
    private Button hbhps;

    @FXML
    private TableColumn<tbl_hbeli, String> hbjam;

    @FXML
    private Pane hbkanan;

    @FXML
    private TableColumn<tbl_hbeli, String > hbkar;

    @FXML
    private TableColumn<tbl_hbeli, String> hbsup;

    @FXML
    private TableColumn<tbl_hbeli, String> hbkdtrans;

    @FXML
    private Pane hbkiri;

    @FXML
    private Button hbprint;

    @FXML
    private Button hbswitch;

    @FXML
    private Label hbtfjam;

    @FXML
    private Label hbtfkasir;

    @FXML
    private Label hbtfkdtrans;

    @FXML
    private Label hbtfsup;

    @FXML
    private Label hbtftgl;

    @FXML
    private Label hbtftotal;

    @FXML
    private TableColumn<tbl_hbeli, String> hbtgl;

    @FXML
    private TableColumn<tbl_hbeli, Double> hbtotal;

    @FXML
    private Pane hjatas;

    @FXML
    private TextField hjcari;

    @FXML
    private Button hjdetail;

    @FXML
    private TableColumn<tbl_transco, Integer> hjdetailharga;

    @FXML
    private Label hjdetailkasir;

    @FXML
    private TableColumn<tbl_transco, String> hjdetailkdbar;

    @FXML
    private Label hjdetailkdtrans;

    @FXML
    private Button hjdetailkembali;

    @FXML
    private TableColumn<tbl_transco, String> hjdetailnamabar;

    @FXML
    private Button hjdetailprint;

    @FXML
    private TableColumn<tbl_transco, Double> hjdetailqty;

    @FXML
    private TableColumn<tbl_transco, String> hjdetailsatuan;

    @FXML
    private TableColumn<tbl_transco, Double> hjdetailtotal;

    @FXML
    private Label hjdetailjam;

    @FXML
    private Label hjdetailgtotal;

    @FXML
    private Button hjexport;

    @FXML
    private Button hjexportexport;

    @FXML
    private TableColumn<?, ?> hjexportkasir;

    @FXML
    private TableColumn<?, ?> hjexportkdtarns;

    @FXML
    private Button hjexportkembali;

    @FXML
    private TableColumn<?, ?> hjexporttgl;

    @FXML
    private TableColumn<?, ?> hjexporttotal;

    @FXML
    private Button hjhps;

    @FXML
    private TableColumn<tbl_hjual, String> hjjam;

    @FXML
    private Pane hjkanan;

    @FXML
    private TableColumn<tbl_hjual, String> hjkasir;

    @FXML
    private TableColumn<tbl_hjual, String> hjkdtrans;

    @FXML
    private Pane hjkiri;

    @FXML
    private Button hjprint;

    @FXML
    private Button hjretur;

    @FXML
    private Button hjswitch;

    @FXML
    private Label hjtfjam;

    @FXML
    private Label hjtfkasir;

    @FXML
    private Label hjtfkdtrans;

    @FXML
    private Label hjtftgl;

    @FXML
    private Label hjtftotal;

    @FXML
    private TableColumn<tbl_hjual, String> hjtgl;

    @FXML
    private TableColumn<tbl_hjual, Double> hjtotal;

    @FXML
    private Pane jualdetail;

    @FXML
    private Pane returatas;

    @FXML
    private Button returbtn;

    @FXML
    private Button returbtnlanjut;

    @FXML
    private TextField returcari;

    @FXML
    private TableColumn<?, ?> returharga;

    @FXML
    private Pane returkanan;

    @FXML
    private TableColumn<?, ?> returkdbar;

    @FXML
    private Label returkdretur;

    @FXML
    private Label returkembali;

    @FXML
    private Pane returkiri;

    @FXML
    private Pane returlanjutatas;

    @FXML
    private Pane returlanjutbawahkanan;

    @FXML
    private Pane returlanjutbawahkiri;

    @FXML
    private TextField returlanjutcari;

    @FXML
    private Label returlanjuthrg;

    @FXML
    private Label returlanjutjmlbar;

    @FXML
    private Label returlanjutkasir;

    @FXML
    private TableColumn<?, ?> returlanjutkdbar;

    @FXML
    private Label returlanjutkdretur;

    @FXML
    private Label returlanjutkdtrans;

    @FXML
    private Label returlanjutkembali;

    @FXML
    private TableColumn<?, ?> returlanjutnamabar;

    @FXML
    private Button returlanjutprint;

    @FXML
    private TableColumn<?, ?> returlanjutqty;

    @FXML
    private TableColumn<?, ?> returlanjutstatus;

    @FXML
    private Pane returlanjuttengah;

    @FXML
    private Label returlanjuttgl;

    @FXML
    private TableColumn<?, ?> returlanjuttotal;

    @FXML
    private TableColumn<?, ?> returnamabar;

    @FXML
    private TableColumn<?, ?> returqty;

    @FXML
    private TableColumn<?, ?> returstatus;

    @FXML
    private Label returtfharga;

    @FXML
    private Label returtfnamabar;

    @FXML
    private Label returtfqty;

    @FXML
    private Label returtfqtyrtr;

    @FXML
    private Label returtfstatus;

    @FXML
    private Label returtftotal;

    @FXML
    private TableColumn<?, ?> returtotal;

    @FXML
    private TableView<?> tablehbexport;

    @FXML
    private TableView<tbl_hbeli> tablehbeli;

    @FXML
    private TableView<tbl_transco> tablehdetail;

    @FXML
    private TableView<tbl_transco> tablehjdetail;

    @FXML
    private TableView<?> tablehjexport;

    @FXML
    private TableView<tbl_hjual> tablehjual;

    @FXML
    private TableView<?> tableretur;

    @FXML
    private TableView<?> tablereturlanjut;

    @FXML
    private TextField txtnomor;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        settablehjual();
    }

    void setTablehbeli() {
        ObservableList<tbl_hbeli> list = FXCollections.observableArrayList();
        try {
            String sql = "SELECT pembelian.id_pembelian, pembelian.tanggal_transaksi, " +
                    "pembelian.jam_transaksi, pembelian.uang, pembelian.id_pengguna, supplier.nama_supplier " +
                    "from pembelian join supplier on pembelian.id_supplier = supplier.id_supplier;";
            Connection conn = (Connection) Config.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()) {
                list.add(new tbl_hbeli(res.getString(1),
                        res.getString(2),
                        res.getString(3),
                        res.getString(5),
                        res.getString(6),
                        res.getDouble(4)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        hbkdtrans.setCellValueFactory(new PropertyValueFactory<tbl_hbeli, String>("kdtrans"));
        hbtgl.setCellValueFactory(new PropertyValueFactory<tbl_hbeli, String>("tgl"));
        hbjam.setCellValueFactory(new PropertyValueFactory<tbl_hbeli, String>("jam"));
        hbkar.setCellValueFactory(new PropertyValueFactory<tbl_hbeli, String>("kasir"));
        hbsup.setCellValueFactory(new PropertyValueFactory<tbl_hbeli, String>("sup"));
        hbtotal.setCellValueFactory(new PropertyValueFactory<tbl_hbeli, Double>("total"));
        tablehbeli.setItems(list);
    }

    @FXML
    void tablehbeli_onclick(MouseEvent event) {
        ObservableList<tbl_hbeli> list;
        list=tablehbeli.getSelectionModel().getSelectedItems();

        hbtfkdtrans.setText(list.get(0).getKdtrans());
        hbtftgl.setText(list.get(0).getTgl());
        hbtfjam.setText(list.get(0).getJam());
        hbtfkasir.setText(list.get(0).getKasir());
        hbtfsup.setText(list.get(0).getSup());
        String total = String.valueOf(list.get(0).getTotal());
        hbtftotal.setText(total);

    }

    @FXML
    void carisupkey(KeyEvent event) {

    }

    @FXML
    void hbcarikey(KeyEvent event) {
        ObservableList<tbl_hbeli> list = FXCollections.observableArrayList();
        try {
            String sql = "SELECT pembelian.id_pembelian, pembelian.tanggal_transaksi, " +
                    "pembelian.jam_transaksi, pembelian.uang, pembelian.id_pengguna, supplier.nama_supplier " +
                    "from pembelian join supplier on pembelian.id_supplier = supplier.id_supplier " +
                    "where pembelian.id_pembelian like '%" + hbcari.getText() + "%' ;";
            Connection conn = (Connection) Config.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()) {
                list.add(new tbl_hbeli(res.getString(1),
                        res.getString(2),
                        res.getString(3),
                        res.getString(5),
                        res.getString(6),
                        res.getDouble(4)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        hbkdtrans.setCellValueFactory(new PropertyValueFactory<tbl_hbeli, String>("kdtrans"));
        hbtgl.setCellValueFactory(new PropertyValueFactory<tbl_hbeli, String>("tgl"));
        hbjam.setCellValueFactory(new PropertyValueFactory<tbl_hbeli, String>("jam"));
        hbkar.setCellValueFactory(new PropertyValueFactory<tbl_hbeli, String>("kasir"));
        hbsup.setCellValueFactory(new PropertyValueFactory<tbl_hbeli, String>("sup"));
        hbtotal.setCellValueFactory(new PropertyValueFactory<tbl_hbeli, Double>("total"));
        tablehbeli.setItems(list);
    }

    @FXML
    void hbdetailact(ActionEvent event) {
        belidetail.setVisible(true);
        hbdetailkdtrans.setText(hbtfkdtrans.getText());
        hbdetailkasir.setText(hbtfkasir.getText());
        hbdetailjam.setText(hbtfjam.getText());
        hbdetailgtotal.setText(hbtftotal.getText());

        setTablehbdetail();
    }

    void setTablehbdetail() {
            ObservableList<tbl_transco> list = FXCollections.observableArrayList();
            try {
                String sql = "select detail_pembelian.id_barang, barang.nama_barang, " +
                        "detail_pembelian.harga_beli, detail_pembelian.qty, barang.id_satuan, detail_pembelian.harga_total " +
                        "from detail_pembelian join barang on detail_pembelian.id_barang = barang.id_barang"
                        + " where id_pembelian = '" + hbtfkdtrans.getText() + "' ;";
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

        hbdetailkdbar.setCellValueFactory(new PropertyValueFactory<tbl_transco, String>("co_kdbar"));
        hbdetailnamabar.setCellValueFactory(new PropertyValueFactory<tbl_transco, String>("co_namabar"));
        hbdetailharga.setCellValueFactory(new PropertyValueFactory<tbl_transco, Integer>("co_harga"));
        hbdetailqty.setCellValueFactory(new PropertyValueFactory<tbl_transco, Double>("co_qty"));
        hbdetailsatuan.setCellValueFactory(new PropertyValueFactory<tbl_transco, String>("co_satuan"));
        hbdetailtotal.setCellValueFactory(new PropertyValueFactory<tbl_transco, Double>("co_total"));
        tablehdetail.setItems(list);
    }

    @FXML
    void hbdetailkembaliact(ActionEvent event) {
        belidetail.setVisible(false);
    }

    @FXML
    void hbdetailprintact(ActionEvent event) {

    }

    @FXML
    void hbexportact(ActionEvent event) {

    }

    @FXML
    void hbexportexportact(ActionEvent event) {

    }

    @FXML
    void hbexportkembaliact(ActionEvent event) {

    }

    @FXML
    void hbhps(ActionEvent event) {

    }

    @FXML
    void hbprintact(ActionEvent event) {

    }

    @FXML
    void hbswitchact(ActionEvent event) {
        hjatas.setVisible(true);
        hjkanan.setVisible(true);
        hjkiri.setVisible(true);
        hbatas.setVisible(false);
        hbkiri.setVisible(false);
        hbkanan.setVisible(false);
    }
//HISTORY JUALLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL

    void settablehjual() {
        ObservableList<tbl_hjual> list = FXCollections.observableArrayList();
        try {
            String sql = "SELECT * from penjualan ;";
            Connection conn = (Connection) Config.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()) {
                list.add(new tbl_hjual(res.getString("id_penjualan"),
                        res.getString("tanggal_transaksi"),
                        res.getString("jam_transaksi"),
                        res.getString("id_pengguna"),
                        res.getDouble("total_bayar")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        hjkdtrans.setCellValueFactory(new PropertyValueFactory<tbl_hjual, String>("kdtrans"));
        hjtgl.setCellValueFactory(new PropertyValueFactory<tbl_hjual, String>("tgl"));
        hjjam.setCellValueFactory(new PropertyValueFactory<tbl_hjual, String>("jam"));
        hjkasir.setCellValueFactory(new PropertyValueFactory<tbl_hjual, String>("kasir"));
        hjtotal.setCellValueFactory(new PropertyValueFactory<tbl_hjual, Double>("total"));
        tablehjual.setItems(list);
    }

    @FXML
    void tablehjual_onclick(MouseEvent event) {
        ObservableList<tbl_hjual> list;
        list=tablehjual.getSelectionModel().getSelectedItems();

        hjtfkdtrans.setText(list.get(0).getKdtrans());
        hjtftgl.setText(list.get(0).getTgl());
        hjtfjam.setText(list.get(0).getJam());
        hjtfkasir.setText(list.get(0).getKasir());
        String total = String.valueOf(list.get(0).getTotal());
        hjtftotal.setText(total);
    }

    @FXML
    void hjcarikey(KeyEvent event) {
        ObservableList<tbl_hjual> list = FXCollections.observableArrayList();
        try {
            String sql = "SELECT * from penjualan "
                    + "where id_penjualan like '%" + hjcari.getText() + "%'";
            Connection conn = (Connection) Config.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()) {
                list.add(new tbl_hjual(res.getString("id_penjualan"),
                        res.getString("tanggal_transaksi"),
                        res.getString("jam_transaksi"),
                        res.getString("id_pengguna"),
                        res.getDouble("total_bayar")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        hjkdtrans.setCellValueFactory(new PropertyValueFactory<tbl_hjual, String>("kdtrans"));
        hjtgl.setCellValueFactory(new PropertyValueFactory<tbl_hjual, String>("tgl"));
        hjjam.setCellValueFactory(new PropertyValueFactory<tbl_hjual, String>("jam"));
        hjkasir.setCellValueFactory(new PropertyValueFactory<tbl_hjual, String>("kasir"));
        hjtotal.setCellValueFactory(new PropertyValueFactory<tbl_hjual, Double>("total"));
        tablehjual.setItems(list);
    }

    @FXML
    void hjdetailact(ActionEvent event) {
        jualdetail.setVisible(true);
        hjdetailkdtrans.setText(hjtfkdtrans.getText());
        hjdetailkasir.setText(hjtfkasir.getText());
        hjdetailjam.setText(hjtfjam.getText());
        hjdetailgtotal.setText(hjtftotal.getText());

        setTablehjdetail();
    }

    //HISTORY JUAL DETAILLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL

    void setTablehjdetail() {
        ObservableList<tbl_transco> list = FXCollections.observableArrayList();
        try {
            String sql = "select detail_penjualan.id_barang, barang.nama_barang, " +
                    "barang.harga_jual, detail_penjualan.qty, barang.id_satuan, detail_penjualan.harga_total " +
                    "from detail_penjualan join barang on detail_penjualan.id_barang = barang.id_barang"
                    + " where id_penjualan = '" + hjtfkdtrans.getText() + "' ;";
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

        hjdetailkdbar.setCellValueFactory(new PropertyValueFactory<tbl_transco, String>("co_kdbar"));
        hjdetailnamabar.setCellValueFactory(new PropertyValueFactory<tbl_transco, String>("co_namabar"));
        hjdetailharga.setCellValueFactory(new PropertyValueFactory<tbl_transco, Integer>("co_harga"));
        hjdetailqty.setCellValueFactory(new PropertyValueFactory<tbl_transco, Double>("co_qty"));
        hjdetailsatuan.setCellValueFactory(new PropertyValueFactory<tbl_transco, String>("co_satuan"));
        hjdetailtotal.setCellValueFactory(new PropertyValueFactory<tbl_transco, Double>("co_total"));
        tablehjdetail.setItems(list);
    }

    @FXML
    void hjdetailkembaliact(ActionEvent event) {
        jualdetail.setVisible(false);
    }

    @FXML
    void hjdetailprintact(ActionEvent event) {

    }

    //HISTORY EXPORT JUALLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL
    void convertdate() {
        // Converter
        StringConverter<LocalDate> converter = new StringConverter<LocalDate>() {
            DateTimeFormatter dateFormatter =  DateTimeFormatter.ofPattern("dd-MM-yyyy");

            @Override
            public String toString(LocalDate date) {
                if (date != null) {
                    return dateFormatter.format(date);
                } else {
                    return "";
                }
            }
            @Override
            public LocalDate fromString(String string) {
                if (string != null && !string.isEmpty()) {
                    return LocalDate.parse(string, dateFormatter);
                } else {
                    return null;
                }
            }
        };
        hjexporttgldari.setConverter(converter);
        hjexporttgldari.setPromptText("");

        hjexporttgldari.setDayCellFactory(param -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                setDisable(empty || date.compareTo(LocalDate.now()) > 0 );
            }
        });
    }

    @FXML
    void hjexportact(ActionEvent event) {
        exportjual.setVisible(true);
        convertdate();
    }

    @FXML
    void hjexportexportact(ActionEvent event) {

    }

    @FXML
    void hjexportkembaliact(ActionEvent event) {

    }

    @FXML
    void hjhpsact(ActionEvent event) {

    }

    @FXML
    void hjprintact(ActionEvent event) {

    }

    @FXML
    void hjreturact(ActionEvent event) {

    }

    @FXML
    void hjswitchact(ActionEvent event) {
        hbatas.setVisible(true);
        hbkanan.setVisible(true);
        hbkiri.setVisible(true);
        hjatas.setVisible(false);
        hjkiri.setVisible(false);
        hjkanan.setVisible(false);

        setTablehbeli();
    }

    @FXML
    void returbtnact(ActionEvent event) {

    }

    @FXML
    void returbtnlanjut(ActionEvent event) {

    }

    @FXML
    void returcarikey(KeyEvent event) {

    }

    @FXML
    void returkembaliklik(MouseEvent event) {

    }

    @FXML
    void returlanjutkembaliklik(MouseEvent event) {

    }

    @FXML
    void returlanjutprintact(ActionEvent event) {

    }

    @FXML
    void table_karyawanonclick(MouseEvent event) {

    }

    @FXML
    void tablehdetail_onclick(MouseEvent event) {

    }

    @FXML
    void tablehjdetail_onclick(MouseEvent event) {

    }

    @FXML
    void tableretur_onclick(MouseEvent event) {

    }

    @FXML
    void tablereturlanjut(MouseEvent event) {

    }

}
