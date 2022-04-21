package com.kelompok5.tokoberkah;

import com.mysql.jdbc.Connection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Objects;
import java.util.Optional;
import java.util.ResourceBundle;

public class Transaksi implements Initializable {
    @FXML
    private Button bcaribar;

    @FXML
    private Button bcheckout;

    @FXML
    private Button beditbar;

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
    private Label btfnamabar;

    @FXML
    private TextField btfqty;

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
    private TableView<tbl_transco> co_table;

    @FXML
    private Label co_tgl;

    @FXML
    private TableColumn<tbl_transco, Integer> co_total;

    @FXML
    private Button jcaribar;

    @FXML
    private Button jcheckout;

    @FXML
    private Button jeditbar;

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
    private Button jswitch;

    @FXML
    private TextField jtfharga;

    @FXML
    private TextField jtfkdbar;

    @FXML
    private TextField jtfkdbat;

    @FXML
    private TextField jtfnamabar;

    @FXML
    private TextField jtfqty;

    @FXML
    private TextField jtfsatuan;

    @FXML
    private TextField jtftotal;

    @FXML
    private Label jtgl;

    @FXML
    private TableColumn<tbl_transjual, Integer> jtotal;

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
    private Button popjtambahbar;

    @FXML
    private TextField popjualcari;

    @FXML
    private Pane popupbeli;

    @FXML
    private Pane popupjual;

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
        setmainbeli();
    }

    //BELIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII

    void setmainbeli() {
        beliatas.setVisible(true);
        belikanan.setVisible(true);
        belikiri.setVisible(true);
        setBkdtrans();
        setBtgl();
        setBsup();
        setTablebeli();
    }

    void setBkdtrans() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("ddMMyyyy-");
        LocalDateTime tanggal = LocalDateTime.now();
        String a = (dtf.format(tanggal));
        try {
            //--> melakukan eksekusi query untuk mengambil data dari tabel
            String sql = "SELECT MAX(id_pembelian) FROM pembelian ;" ;
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            java.sql.ResultSet rs = pst.executeQuery(sql);
            while (rs.next()) {
                if (rs.getString(1) == null) {
                    bkdtrans.setText("TB-"+a+"001");
                } else {
                    rs.last();
                    String auto = rs.getString(1);
                    auto = auto.replace("TB-"+a,"");
                    int auto_id = Integer.parseInt(auto) +1;
                    String no = String.valueOf(auto_id);
                    int NomorJual = no.length();
                    //MENGATUR jumlah 0
                    for (int j = 0; j < 3 - NomorJual; j++) {
                        no = "0" + no;
                    }
                    bkdtrans.setText("TB"+a+no);
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
        btgl.setText(aa+" "+mm+" "+yyyy);
    }

    void setBsup(){
        ObservableList<String> list = FXCollections.observableArrayList();
        try {
            String sql = "select * from supplier";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet res=stm.executeQuery(sql);
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
                    "cart_pembelian.harga_beli, cart_pembelian.qty, cart_pembelian.harga_total " +
                    "from cart_pembelian join barang on cart_pembelian.id_barang = barang.id_barang"
                    + " where id_pembelian = '"+bkdtrans.getText()+"' ;" ;
            Connection conn = (Connection) Config.configDB();
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet res=stm.executeQuery(sql);
            while(res.next()){
                list.add(new tbl_transbeli(res.getString(1),
                        res.getString(2),
                        res.getInt(3),
                        res.getDouble(4),
                        res.getDouble(5)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        bkdbar.setCellValueFactory(new PropertyValueFactory<tbl_transbeli, String>("bkdbar"));
        bnamabar.setCellValueFactory(new PropertyValueFactory<tbl_transbeli, String>("bnamabar"));
        bharga.setCellValueFactory(new PropertyValueFactory<tbl_transbeli, Integer>("bharga"));
        bqty.setCellValueFactory(new PropertyValueFactory<tbl_transbeli, Double>("bqty"));
        btotal.setCellValueFactory(new PropertyValueFactory<tbl_transbeli, Double>("btotal"));
        tablebeli.setItems(list);
    }

    @FXML
    void tablebeliklik(MouseEvent event) {
        ObservableList<tbl_transbeli> list;
        list=tablebeli.getSelectionModel().getSelectedItems();

        btfkdbar.setText(list.get(0).getBkdbar());
        btfnamabar.setText(list.get(0).getBnamabar());
        String hrg = String.valueOf(list.get(0).getBharga());
        btfharga.setText(hrg);
        String qty = String.valueOf(list.get(0).getBqty());
        btfqty.setText(qty);
        String tot = String.valueOf(list.get(0).getBtotal());
        btftotal.setText(tot);
    }

    @FXML
    void bcaribaract(ActionEvent event) {
        popupbeli.setVisible(true);
        setTablepopbeli();
    }

    @FXML
    void bcheckoutact(ActionEvent event) {

    }

    @FXML
    void beditbaract(ActionEvent event) {
        try {
            String sqll = "UPDATE cart_pembelian "
                    + "SET harga_beli = '"+btfharga.getText()
                    +"', qty = '" +btfqty.getText()
                    +"', harga_total = '"+btftotal.getText()
                    +"' WHERE cart_pembelian.id_barang = '"+btfkdbar.getText()+"'";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.PreparedStatement pstl=conn.prepareStatement(sqll);
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
            alert.setContentText("apakah anda yakin ingin menghapus Data pembelian barang dengan Kode "+btfkdbar.getText()+"?");
            Optional<ButtonType> action = alert.showAndWait();

            if (action.get() == ButtonType.OK) {
                try {
                    String sql ="DELETE FROM cart_pembelian where id_barang='"+btfkdbar.getText()+"'";
                    java.sql.Connection conn=(Connection)Config.configDB();
                    java.sql.PreparedStatement pst=conn.prepareStatement(sql);
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

    }

    @FXML
    void btambahbaract(ActionEvent event) {
        if (bkdbar.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle(" kosong");
            alert.setHeaderText("Kode Barang masih Kosong");
            alert.setContentText("Pilih Barang terlebih dahulu!");
            alert.showAndWait();
        } else {
            try {
                String sqll = "INSERT INTO `cart_pembelian` (`id_pembelian`, `id_barang`, `harga_beli`, `qty`, `harga_total`)" +
                        " VALUES ('"+bkdtrans.getText()+"', '"
                        +btfkdbar.getText()+"', '"
                        +btfharga.getText()+"', '"
                        +btfqty.getText()+"', '"
                        +btftotal.getText()+"'); ";
                java.sql.Connection conn=(Connection)Config.configDB();
                java.sql.PreparedStatement pstl=conn.prepareStatement(sqll);
                pstl.execute();
//                Alert alert = new Alert(Alert.AlertType.INFORMATION);
//                alert.setTitle("Berhasil");
//                alert.setHeaderText("Data berhasil disimpan");
//                alert.setContentText("Data Barang dengan Kode "+bkdbar.getText()+" berhasil disimpan");
//                alert.showAndWait();
//                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//                stage.close();
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Gagal");
                alert.setHeaderText("Data gagal ditambah!");
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }
            bkosong();
            setTablebeli();

        }
    }

    void bkosong() {
        btfkdbar.setText("");
        btfnamabar.setText(null);
        btfharga.setText(null);
        btfqty.setText(null);
        btftotal.setText(null);

    }

    //CHECKOUTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT
    @FXML
    void co_back1act(ActionEvent event) {

    }

    @FXML
    void co_backact(ActionEvent event) {

    }

    @FXML
    void co_printact(ActionEvent event) {

    }


    //JUALLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLLL
    @FXML
    void jcaribaract(ActionEvent event) {

    }

    @FXML
    void jcheckoutact(ActionEvent event) {

    }

    @FXML
    void jeditbaract(ActionEvent event) {

    }

    @FXML
    void jhpsbaract(ActionEvent event) {

    }

    @FXML
    void jswitchact(ActionEvent event) {

    }

    //POPUP BELIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIIII

    private void setTablepopbeli() {
        ObservableList<tbl_transpopbeli> list = FXCollections.observableArrayList();
        try {
            String sql = "select barang.id_barang, barang.nama_barang, jumlah, satuan.satuan"
                    + " from barang join satuan on barang.id_satuan = satuan.id_satuan ;" ;
            Connection conn = (Connection) Config.configDB();
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet res=stm.executeQuery(sql);
            while(res.next()){
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

    }

    @FXML
    void popbendact(ActionEvent event) {
        popupbeli.setVisible(false);
    }

    @FXML
    void popbtambahbaract(ActionEvent event) {
        ObservableList<tbl_transpopbeli> list;
        list=tablepopbeli.getSelectionModel().getSelectedItems();

        if (String.valueOf(list) == "[]") {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Kode kosong");
            alert.setHeaderText("Kode Barang masih Kosong");
            alert.setContentText("Pilih dahulu Kode barang dari tabel");
            alert.showAndWait();
        } else {
            btfkdbar.setText(list.get(0).getPopbkdbar());
            btfnamabar.setText(list.get(0).getPopbnamabar());
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
            double qty = Double.parseDouble(btfqty.getText()), tot = hrg*qty;
            btftotal.setText(String.valueOf(tot));
        }
    }

    @FXML
    void popjendact(ActionEvent event) {

    }

    @FXML
    void popjtambahbaract(ActionEvent event) {

    }



    @FXML
    void tablejualklik(MouseEvent event) {

    }

    @FXML
    void tablepopbeliklik(MouseEvent event) {

    }

    @FXML
    void tablepopjualklik(MouseEvent event) {

    }

}
