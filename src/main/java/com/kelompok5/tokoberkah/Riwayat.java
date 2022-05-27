package com.kelompok5.tokoberkah;

import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.events.JFXDialogEvent;
import com.mysql.jdbc.Connection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.effect.BoxBlur;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.StringConverter;

import org.apache.poi.*;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;

public class Riwayat implements Initializable {


    @FXML
    private StackPane stackblur;

    @FXML
    private Pane blur;

    @FXML
    private DatePicker hjexporttgldari;

    @FXML
    private DatePicker hjexporttglsampai;

    @FXML
    private DatePicker hbexporttgldari;

    @FXML
    private DatePicker hbexporttglsampai;

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
    private TableColumn<tbl_hjual, String> hjexportkasir;

    @FXML
    private TableColumn<tbl_hjual, String> hjexportkdtarns;

    @FXML
    private Button hjexportkembali;

    @FXML
    private TableColumn<tbl_hjual, String> hjexporttgl;

    @FXML
    private TableColumn<tbl_hjual, String> hjexportjam;

    @FXML
    private TableColumn<tbl_hjual, Double> hjexporttotal;

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
    private TableView<tbl_hjual> tablehjexport;

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
        BoxBlur blur1 = new BoxBlur(3,3,3);

        JFXDialog dialog = new JFXDialog( stackblur, belidetail, JFXDialog.DialogTransition.TOP);

        dialog.show();
        dialog.setOnDialogClosed((JFXDialogEvent event1) -> {
            blur.setEffect(null);
        });

        hbdetailprint.addEventHandler(MouseEvent.MOUSE_CLICKED,(MouseEvent mouseEvent) -> {
//            dialog.close();
        });
        hbdetailkembali.addEventHandler(MouseEvent.MOUSE_CLICKED,(MouseEvent mouseEvent ) -> {
            dialog.close();
////            blur.setVisible(true);
//            blur.setEffect(null);
//            popupb.setVisible(false);
        });

        blur.setEffect(blur1);
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
        BoxBlur blur1 = new BoxBlur(3,3,3);

        JFXDialog dialog = new JFXDialog( stackblur, exportbeli, JFXDialog.DialogTransition.TOP);

        dialog.show();
        dialog.setOnDialogClosed((JFXDialogEvent event1) -> {
            blur.setEffect(null);
        });

        hbexportexport.addEventHandler(MouseEvent.MOUSE_CLICKED,(MouseEvent mouseEvent) -> {
            dialog.close();
        });
        hbexportkembali.addEventHandler(MouseEvent.MOUSE_CLICKED,(MouseEvent mouseEvent ) -> {
            dialog.close();
////            blur.setVisible(true);
//            blur.setEffect(null);
//            popupb.setVisible(false);
        });

        blur.setEffect(blur1);
        exportbeli.setVisible(true);
        convertdate();

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
        BoxBlur blur1 = new BoxBlur(3,3,3);

        JFXDialog dialog = new JFXDialog( stackblur, jualdetail, JFXDialog.DialogTransition.TOP);

        dialog.show();
        dialog.setOnDialogClosed((JFXDialogEvent event1) -> {
            blur.setEffect(null);
        });

        hjdetailprint.addEventHandler(MouseEvent.MOUSE_CLICKED,(MouseEvent mouseEvent) -> {
            dialog.close();
                });
        hjdetailkembali.addEventHandler(MouseEvent.MOUSE_CLICKED,(MouseEvent mouseEvent ) -> {
            dialog.close();
////            blur.setVisible(true);
//            blur.setEffect(null);
//            popupb.setVisible(false);
        });

        blur.setEffect(blur1);

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
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        String a = sdf.format(hjexporttglsampai.getValue());

        hjexporttgldari.setDayCellFactory(param -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                setDisable(empty || date.compareTo(LocalDate.now()) > 0 );
            }
        });

        hjexporttglsampai.setConverter(converter);
        hjexporttglsampai.setPromptText("");

        hjexporttglsampai.setDayCellFactory(param -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                setDisable(empty || date.compareTo(LocalDate.now()) > 0 );
            }
        });

        hbexporttgldari.setConverter(converter);
        hbexporttgldari.setPromptText("");

        hbexporttgldari.setDayCellFactory(param -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                setDisable(empty || date.compareTo(LocalDate.now()) > 0 );
            }
        });

        hbexporttglsampai.setConverter(converter);
        hbexporttglsampai.setPromptText("");

        hbexporttglsampai.setDayCellFactory(param -> new DateCell() {
            @Override
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                setDisable(empty || date.compareTo(LocalDate.now()) > 0 );
            }
        });
    }

    void setTablehjexport() {
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

        hjexportkdtarns.setCellValueFactory(new PropertyValueFactory<tbl_hjual, String>("kdtrans"));
        hjexporttgl.setCellValueFactory(new PropertyValueFactory<tbl_hjual, String>("tgl"));
        hjexportjam.setCellValueFactory(new PropertyValueFactory<tbl_hjual, String>("jam"));
        hjexportkasir.setCellValueFactory(new PropertyValueFactory<tbl_hjual, String>("kasir"));
        hjexporttotal.setCellValueFactory(new PropertyValueFactory<tbl_hjual, Double>("total"));
        tablehjexport.setItems(list);
    }

    @FXML
    void hjexportact(ActionEvent event) {
        BoxBlur blur1 = new BoxBlur(3,3,3);

        JFXDialog dialog = new JFXDialog( stackblur, exportjual, JFXDialog.DialogTransition.TOP);

        dialog.show();
        dialog.setOnDialogClosed((JFXDialogEvent event1) -> {
            blur.setEffect(null);
        });

        hjexportexport.addEventHandler(MouseEvent.MOUSE_CLICKED,(MouseEvent mouseEvent) -> {
            dialog.close();
        });
        hjexportkembali.addEventHandler(MouseEvent.MOUSE_CLICKED,(MouseEvent mouseEvent ) -> {
            dialog.close();
////            blur.setVisible(true);
//            blur.setEffect(null);
//            popupb.setVisible(false);
        });

        blur.setEffect(blur1);
        exportjual.setVisible(true);
        convertdate();
        setTablehjexport();
    }

    @FXML
    void jtglupdatetable(Event event) {
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
//        String date1 = sdf.format(hjexporttgldari.getValue());
//        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd");
//        String date2 = sdf1.format(hjexporttglsampai.getValue());
        LocalDate date1 = hjexporttgldari.getValue();
        LocalDate date2 = hjexporttglsampai.getValue();
//        System.out.println(hjexporttgldari.getValue());
        ObservableList<tbl_hjual> list = FXCollections.observableArrayList();
        try {
            String sql = "SELECT * from penjualan " +
                    "where tanggal_transaksi BETWEEN '"+date1+"' AND '"+date2+"' ;";
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

        hjexportkdtarns.setCellValueFactory(new PropertyValueFactory<tbl_hjual, String>("kdtrans"));
        hjexporttgl.setCellValueFactory(new PropertyValueFactory<tbl_hjual, String>("tgl"));
        hjexportjam.setCellValueFactory(new PropertyValueFactory<tbl_hjual, String>("jam"));
        hjexportkasir.setCellValueFactory(new PropertyValueFactory<tbl_hjual, String>("kasir"));
        hjexporttotal.setCellValueFactory(new PropertyValueFactory<tbl_hjual, Double>("total"));
        tablehjexport.setItems(list);
    }

    @FXML
    void hjexportexportact(ActionEvent event) {
        LocalDate date1 = hjexporttgldari.getValue();
        LocalDate date2 = hjexporttglsampai.getValue();
        try {
            String sql = "SELECT * from penjualan " +
                    "where tanggal_transaksi BETWEEN '" + date1 + "' AND '" + date2 + "' ;";
            Connection conn = (Connection) Config.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);

            HSSFWorkbook workbook = new HSSFWorkbook();
            HSSFSheet sheet = workbook.createSheet("Report Penjualan");
            HSSFRow header = sheet.createRow(0);
            header.createCell(0).setCellValue("Kode Transaksi");
            header.createCell(1).setCellValue("Tanggal");
            header.createCell(2).setCellValue("Jam");
            header.createCell(3).setCellValue("Nama Kasir");
            header.createCell(4).setCellValue("Total Pembayaran");

            int index = 1;
            while (res.next()) {
                HSSFRow row = sheet.createRow(index);
                row.createCell(0).setCellValue(res.getString("id_penjualan"));
                row.createCell(1).setCellValue(res.getString("tanggal_transaksi"));
                row.createCell(2).setCellValue(res.getString("jam_transaksi"));
                row.createCell(3).setCellValue(res.getString("id_pengguna"));
                row.createCell(4).setCellValue(res.getDouble("total_bayar"));
                index++;
            }

            FileOutputStream fileout = new FileOutputStream("Export Riwayat Penjualan.xls");
            workbook.write(fileout);
            fileout.close();

            res.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
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

    //MENUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUUU

    @FXML
    void menudashklik(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

}
