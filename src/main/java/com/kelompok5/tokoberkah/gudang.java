package com.kelompok5.tokoberkah;

import com.mysql.jdbc.Connection;
import com.jfoenix.controls.JFXCheckBox;
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
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

public class gudang implements Initializable {


    @FXML
    private Pane panebaratas;

    @FXML
    private Pane panetabbar;

    @FXML
    private Pane panebarkanan;

    @FXML
    private Pane panebarkiri;

    @FXML
    private TableView<tbl_gudang> table_bar;

    @FXML
    private TableColumn<tbl_gudang, String> kdbar;

    @FXML
    private TableColumn<tbl_gudang, String> namabar;

    @FXML
    private TableColumn<tbl_gudang, String> ktgr;

    @FXML
    private TableColumn<tbl_gudang, Double> qty;

    @FXML
    private TableColumn<tbl_gudang, String> satuan;

    @FXML
    private TableColumn<tbl_gudang, Integer> hargabeli;

    @FXML
    private TableColumn<tbl_gudang, Integer> harga;

    @FXML
    private Button lhtsup;

    @FXML
    private Button editbar;

    @FXML
    private Button hpsbar;

    @FXML
    private Button tmbhbar;

    @FXML
    private Label jmlbar;

    @FXML
    private Label labelharga;

    @FXML
    private Label labelkdbar;

    @FXML
    private Label labelnamabar;

    @FXML
    private Label labelqty;

    @FXML
    private TextField caribar;

    //menu
    @FXML
    private Label logout;

    @FXML
    private Label menudash;

    @FXML
    private Label menugudang;

    @FXML
    private Label menukar;

    @FXML
    private Label menuretur;

    @FXML
    private Label menuriwayat;

    @FXML
    private Label menuset;

    @FXML
    private Label menutrans;

    //sup
    @FXML
    private Pane panesupatas;

    @FXML
    private Pane panesupkanan;

    @FXML
    private Pane panesupkiri;

    @FXML
    private Button btneditsup;

    @FXML
    private Button btnhpssup;

    @FXML
    private Button btntmbhsup;

    @FXML
    private Button clear;

    @FXML
    private TableView<tbl_sup> table_sup;

    @FXML
    private TableColumn<tbl_sup, String> idsup;

    @FXML
    private TableColumn<tbl_sup, String> namasup;

    @FXML
    private TableColumn<tbl_sup, String> nomorsup;

    @FXML
    private TableColumn<tbl_sup, String> alamatsup;

    @FXML
    private TextField txtalamatsup;

    @FXML
    private TextField txtidsup;

    @FXML
    private TextField txtnamasup;

    @FXML
    private TextField txtnomorsup;

    @FXML
    private TextField carisup;

    @FXML
    private Label back;

    @FXML
    private Pane blur;

    @FXML
    private Pane popupb;

    @FXML
    private Pane popupbedit;

    @FXML
    private Label pkdbar;

    @FXML
    private Label pkdbar1;

    @FXML
    private Label judul;

    @FXML
    private Label rtr;

    @FXML
    private CheckBox check;

    @FXML
    private TextField pkdbat;

    @FXML
    private TextField pnamabar;

    @FXML
    private TextField phargabar;

    @FXML
    private ComboBox<String> pktgr;

    @FXML
    private TextField pqty;

    @FXML
    private ComboBox<String> psatuan;

    @FXML
    private CheckBox check1;

    @FXML
    private TextField pkdbat1;

    @FXML
    private TextField pnamabar1;

    @FXML
    private TextField phargabar1;

    @FXML
    private ComboBox<String> pktgr1;

    @FXML
    private TextField pqty1;

    @FXML
    private ComboBox<String> psatuan1;

    @FXML
    private Button btneditbar;

    @FXML
    private Button cancel;

    @FXML
    private Button cancel1;

    @FXML
    private Button btntambahbar;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        panesupatas.setVisible(false);
        panesupkiri.setVisible(false);
        panesupkanan.setVisible(false);
        blur.setVisible(false);
        popupb.setVisible(false);
        table_bar();
        setJmlbar();
        setTable_sup();
        isisatuan();
        isiktgr();
    }

    @FXML
    private void table_bar(){
        ObservableList<tbl_gudang> list = FXCollections.observableArrayList();
        try {
            String sql = "select barang.id_barang, barang.nama_barang, kategori.jenis, jumlah, satuan.satuan, barang.harga_beli, barang.harga_jual "
                    + "from barang join kategori on barang.id_kategori = kategori.id_kategori "
                    + "join satuan on barang.id_satuan = satuan.id_satuan ;" ;
            Connection conn = (Connection) Config.configDB();
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet res=stm.executeQuery(sql);
            while(res.next()){
                list.add(new tbl_gudang(res.getString(1),
                        res.getString(2),
                        res.getString(3),
                        res.getDouble(4),
                        res.getString(5),
                        res.getInt(6),
                        res.getInt(7)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        kdbar.setCellValueFactory(new PropertyValueFactory<tbl_gudang, String>("kdbar"));
        namabar.setCellValueFactory(new PropertyValueFactory<tbl_gudang, String>("namabar"));
        ktgr.setCellValueFactory(new PropertyValueFactory<tbl_gudang, String>("ktgr"));
        qty.setCellValueFactory(new PropertyValueFactory<tbl_gudang, Double>("qty"));
        satuan.setCellValueFactory(new PropertyValueFactory<tbl_gudang, String>("satuan"));
        hargabeli.setCellValueFactory(new PropertyValueFactory<tbl_gudang, Integer>("hb"));
        harga.setCellValueFactory(new PropertyValueFactory<tbl_gudang, Integer>("harga"));
        table_bar.setItems(list);
    }

    @FXML
    void caribarkey(KeyEvent event) {
        ObservableList<tbl_gudang> list = FXCollections.observableArrayList();
        try {
            String sql = "select barang.id_barang, barang.nama_barang, kategori.jenis, jumlah, satuan.satuan, barang.harga_beli, barang.harga_jual "
                    + "from barang join kategori on barang.id_kategori = kategori.id_kategori "
                    + "join satuan on barang.id_satuan = satuan.id_satuan "
                    + "where nama_barang like '%" + caribar.getText() + "%'" ;
            Connection conn = (Connection) Config.configDB();
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet res=stm.executeQuery(sql);
            while(res.next()){
                list.add(new tbl_gudang(res.getString(1),
                        res.getString(2),
                        res.getString(3),
                        res.getDouble(4),
                        res.getString(5),
                        res.getInt(6),
                        res.getInt(7)));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        kdbar.setCellValueFactory(new PropertyValueFactory<tbl_gudang, String>("kdbar"));
        namabar.setCellValueFactory(new PropertyValueFactory<tbl_gudang, String>("namabar"));
        ktgr.setCellValueFactory(new PropertyValueFactory<tbl_gudang, String>("ktgr"));
        qty.setCellValueFactory(new PropertyValueFactory<tbl_gudang, Double>("qty"));
        satuan.setCellValueFactory(new PropertyValueFactory<tbl_gudang, String>("satuan"));
        hargabeli.setCellValueFactory(new PropertyValueFactory<tbl_gudang, Integer>("hb"));
        harga.setCellValueFactory(new PropertyValueFactory<tbl_gudang, Integer>("harga"));
        table_bar.setItems(list);
    }

    @FXML
    void editbarklik(ActionEvent event) {
        if (labelkdbar.getText() == ""){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Kode kosong");
            alert.setHeaderText("Barang belum dipilih");
            alert.setContentText("Pilih dahulu barang yang ingin diedit");
            alert.showAndWait();
        } else {
            ObservableList<tbl_gudang> list;
            list=table_bar.getSelectionModel().getSelectedItems();

            pkdbar1.setText(list.get(0).getKdbar());
            pnamabar1.setText(list.get(0).getNamabar());
            pktgr1.setValue(list.get(0).getKtgr());
            String hrg = String.valueOf(list.get(0).getHarga());
            phargabar1.setText(hrg);
            String jml = String.valueOf(list.get(0).getQty());
            pqty1.setText(jml);
            psatuan1.setValue(list.get(0).getSatuan());
            try {
                String sql = "select retur from barang WHERE id_barang = '"
                        +labelkdbar.getText()+"' ;";
                java.sql.Connection conn = (Connection) Config.configDB();
                java.sql.Statement stm = conn.createStatement();
                java.sql.ResultSet rs = stm.executeQuery(sql);
                rs.next();
                rtr.setText(rs.getString("retur"));
                if (rtr.equals("Iya")) {
                    check1.setSelected(true);
                    check1.setIndeterminate(false);
                } else {
                    check1.setSelected(false);
                    check1.setIndeterminate(false);
                }
                System.out.println(rtr.getText());
            } catch (Exception e) {
            }
            blur.setVisible(true);
            popupbedit.setVisible(true);
//            btneditbar.setVisible(true);
            pktgr1.setDisable(true);
        }
    }

    @FXML
    void hpsbarklik(ActionEvent event) {
        if (labelkdbar.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Kode kosong");
            alert.setHeaderText("Kode Barang masih Kosong");
            alert.setContentText("Pilih dahulu Kode barang yang ingin dihapus");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Konfirmasi Hapus");
            alert.setHeaderText(null);
            alert.setContentText("apakah anda yakin ingin menghapus Data barang dengan Kode "+labelkdbar.getText()+"?");
            Optional <ButtonType> action = alert.showAndWait();

            if (action.get() == ButtonType.OK) {
                try {
                    String sql ="DELETE FROM barang where id_barang='"+labelkdbar.getText()+"'";
                    java.sql.Connection conn=(Connection)Config.configDB();
                    java.sql.PreparedStatement pst=conn.prepareStatement(sql);
                    pst.execute();
                    Alert newalert = new Alert(Alert.AlertType.INFORMATION);
                    newalert.setTitle("Berhasil");
                    newalert.setHeaderText("Data berhasil dihapus");
                    newalert.setContentText("Data barang dengan Kode "+labelkdbar.getText()+" berhasil dihapus");
                    newalert.showAndWait();
                    setJmlbar();
                } catch (Exception e) {
                    Alert newalert = new Alert(Alert.AlertType.WARNING);
                    newalert.setTitle("Gagal");
                    newalert.setHeaderText("penghapusan data barang gagal");
                    newalert.setContentText(e.getMessage());
                    newalert.showAndWait();
                }
                table_bar();
                kosongbar();
            }
        }
    }

    void kosongbar() {
        labelkdbar.setText("");
        labelharga.setText(null);
        labelnamabar.setText(null);
        labelqty.setText(null);
        rtr.setText(null);
    }

    void kosongpop() {
        pkdbar.setText("");
        pnamabar.setText(null);
        pkdbat.setText(null);
        pktgr.setValue("Alat Tulis Komputer");
        pktgr.setDisable(false);
        pqty.setText(null);
        psatuan.setValue(null);
        phargabar.setText(null);
        check.setSelected(false);
    }

    @FXML
    void lhtsupklik(ActionEvent event) throws IOException {
        panesupatas.setVisible(true);
        panesupkiri.setVisible(true);
        panesupkanan.setVisible(true);
        panetabbar.setVisible(false);
        panebarkiri.setVisible(false);
        panebarkanan.setVisible(false);
        autoidsup();
    }

    @FXML
    public void backklik(MouseEvent evt) {
        panesupatas.setVisible(false);
        panesupkiri.setVisible(false);
        panesupkanan.setVisible(false);
        panetabbar.setVisible(true);
        panebarkiri.setVisible(true);
        panebarkanan.setVisible(true);
    }

    @FXML
    void tmbhbarklik(ActionEvent event) throws IOException {
        blur.setVisible(true);
        popupb.setVisible(true);
        btntambahbar.setVisible(true);
        judul.setText("Tambah Barang");
        kosongpop();
        isiktgr();
        isisatuan();
    }

    private void setJmlbar() {
        try {
            String sql = "SELECT count(id_barang) as total from barang ;";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            java.sql.ResultSet rs = pst.executeQuery(sql);
            rs.next();
            jmlbar.setText(rs.getString("total"));

        } catch (SQLException e) {
        }
    }

    @FXML
    public void table_baronclick(MouseEvent evt) {
        ObservableList<tbl_gudang> list;
        list=table_bar.getSelectionModel().getSelectedItems();

        labelkdbar.setText(list.get(0).getKdbar());
        labelnamabar.setText(list.get(0).getNamabar());
        String hrg = String.valueOf(list.get(0).getHarga());
        labelharga.setText(hrg);
        String jml = String.valueOf(list.get(0).getQty());
        labelqty.setText(jml+" "+(list.get(0).getSatuan()));
        try {
            String sql = "select retur from barang WHERE id_barang = '"
                    +labelkdbar.getText()+"' ;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet rs = stm.executeQuery(sql);
            rs.next();
            rtr.setText(rs.getString("retur"));
        } catch (Exception e) {
        }
    }

    private void isiktgr() {
        ObservableList<String> list = FXCollections.observableArrayList();
        try {
            String sql = "select * from kategori";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet res=stm.executeQuery(sql);
            while (res.next()) {
                list.add(res.getString("jenis"));
            }
        } catch (Exception e) {
        }
        pktgr.setItems(list);
    }

    private void isisatuan() {
        ObservableList<String> list = FXCollections.observableArrayList();
        try {
            String sql = "select * from satuan";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()) {
                list.add(res.getString("satuan"));
            }
        } catch (Exception e) {
        }
        psatuan.setItems(list);
    }

    @FXML
    void cancelklik(ActionEvent event) {
        blur.setVisible(false);
        popupb.setVisible(false);
        popupbedit.setVisible(false);
    }

    //TAMBAHBARRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR
    @FXML
    void tambahbaract(ActionEvent event) {
        String cek ="";
        if (check.isSelected()) {
            cek = "Iya";
        } else {
            cek = "Tidak" ;
        }
        if (pkdbar.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle(" kosong");
            alert.setHeaderText("Kode Barang masih Kosong");
            alert.setContentText("Masukkan Kode Barang terlebih dahulu!");
            alert.showAndWait();
        } else {
            String kktgr = "", idsat = "";
            try {
                String sql = "SELECT id_kategori from kategori "
                        + "where jenis = '"+pktgr.getSelectionModel().getSelectedItem()+"';";
                java.sql.Connection conn=(Connection)Config.configDB();
                java.sql.PreparedStatement pst=conn.prepareStatement(sql);
                java.sql.ResultSet rs = pst.executeQuery(sql);
                rs.next();
                kktgr = rs.getString("id_kategori");

            } catch (SQLException e) {
                e.printStackTrace();
            }
            try {
                String sql = "SELECT id_satuan from satuan "
                        + "where satuan = '"+psatuan.getSelectionModel().getSelectedItem()+"';";
                java.sql.Connection conn=(Connection)Config.configDB();
                java.sql.PreparedStatement pst=conn.prepareStatement(sql);
                java.sql.ResultSet rs = pst.executeQuery(sql);
                rs.next();
                idsat = rs.getString("id_satuan");

            } catch (SQLException e) {
                e.printStackTrace();
            }

            try {
                String sqll = "INSERT INTO barang (id_barang, nama_barang, id_kategori, id_satuan, jumlah, barcode, harga_beli, harga_jual, retur) " +
                        "VALUES ('"+pkdbar.getText()+"','"
                        +pnamabar.getText()+"','"
                        +kktgr+"','"
                        +idsat+"','"
                        +pqty.getText()+"','"
                        +pkdbat.getText()+"','"
                        +"0','"
                        +phargabar.getText()+"','"
                        +cek+"')";
                java.sql.Connection conn=(Connection)Config.configDB();
                java.sql.PreparedStatement pstl=conn.prepareStatement(sqll);
                pstl.execute();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Berhasil");
                alert.setHeaderText("Data berhasil disimpan");
                alert.setContentText("Data Barang dengan Kode "+pkdbar.getText()+" berhasil disimpan");
                alert.showAndWait();
                table_bar();
                setJmlbar();
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Gagal");
                alert.setHeaderText("Data gagal disimpan!");
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }

        }
    }

    @FXML
    void autokdbar (ActionEvent event) {
        String kktgr = "";
        try {
            String sql = "SELECT id_kategori from kategori "
                    + "where jenis = '"+pktgr.getSelectionModel().getSelectedItem()+"';";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            java.sql.ResultSet rs = pst.executeQuery(sql);
            rs.next();
            kktgr = rs.getString("id_kategori");

        } catch (SQLException e) {
        }

        try {
            //--> melakukan eksekusi query untuk mengambil data dari tabel
            String sql = "SELECT MAX(id_barang) FROM barang" +
                    " WHERE id_kategori ='"+kktgr+"' ;" ;
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            java.sql.ResultSet rs = pst.executeQuery(sql);
            while (rs.next()) {
                if (rs.getString(1) == null) {
                    pkdbar.setText(kktgr+"001");
                } else {
                    rs.last();
                    String auto = rs.getString(1);
                    auto = auto.replace(kktgr,"");
                    int auto_id = Integer.parseInt(auto) +1;
                    String no = String.valueOf(auto_id);
                    int NomorJual = no.length();
                    //MENGATUR jumlah 0
                    for (int j = 0; j < 3 - NomorJual; j++) {
                        no = "0" + no;
                    }
                    pkdbar.setText(kktgr+no);
                }
            }
            rs.close();
            rs.close();
        } catch (Exception e) {
        }
    }

    //EDITBARRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRRR
    @FXML
    void editbaract(ActionEvent event) {
        String cek, idsat = "";
        if (check1.isSelected()) {
            cek = "Iya";
        } else {
            cek = "Tidak";
        }

        try {
            String sql = "SELECT id_satuan from satuan "
                    + "where satuan = '" + psatuan1.getSelectionModel().getSelectedItem() + "' ;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            java.sql.ResultSet rs = pst.executeQuery(sql);
            rs.next();
            idsat = rs.getString("id_satuan");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        try {
            String sqlll = "UPDATE barang "
                    + "SET nama_barang = '" + pnamabar1.getText()
                    + "', jumlah = '" + pqty1.getText()
                    + "', id_satuan = '" + idsat
                    + "', harga_jual = '" + phargabar1.getText()
                    + "', retur = '" + cek
                    + "', barcode = '" + pkdbat1.getText()
                    + "' WHERE barang.id_barang = '" + pkdbar1.getText() + "' ;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pstll = conn.prepareStatement(sqlll);
            pstll.execute();
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Berhasil");
            alert.setHeaderText("Data berhasil diubah");
            alert.setContentText("Data Barang dengan Kode " + pkdbar1.getText() + " berhasil diubah");
            alert.showAndWait();
            popupbedit.setVisible(false);
            blur.setVisible(false);
            table_bar();
            kosongbar();
//            System.out.println(pnamabar.getText()+" "+pqty.getText()+" "+idsat+" "+phargabar.getText()+" "+cek+" "+pkdbat.getText());

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Gagal");
            alert.setHeaderText("Data gagal disimpan!");
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }
    //suppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppppp
    @FXML
    void clearklik(ActionEvent event) {
        kosong();
    }

    @FXML
    void editsupklik(ActionEvent event) {
        if (txtidsup.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ID kosong");
            alert.setHeaderText("ID Supplier masih Kosong");
            alert.setContentText("Pilih dahulu ID Supplier yang ingin diedit");
            alert.showAndWait();
        } else {
            String hp=txtnomorsup.getText();
            if (hp.matches("^[0-9]*") && hp.length()==12){
                try {
                    String sql ="UPDATE supplier "
                            + "SET nama_supplier = '"+txtnamasup.getText()
                            +"', alamat_supplier = '" +txtalamatsup.getText()
                            +"', telp_supplier = '" +txtnomorsup.getText()
                            +"' WHERE supplier.id_supplier = '"+txtidsup.getText()+"'";
                    java.sql.Connection conn=(Connection)Config.configDB();
                    java.sql.PreparedStatement pst=conn.prepareStatement(sql);
                    pst.execute();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Berhasil");
                    alert.setHeaderText("Data berhasil diubah");
                    alert.setContentText("Data Supplier dengan ID "+txtidsup.getText()+" berhasil diubah");
                    alert.showAndWait();
                } catch (Exception e) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Gagal");
                    alert.setHeaderText("Perubahan data gagal");
                    alert.setContentText(e.getMessage());
                    alert.showAndWait();
                }
                setTable_sup();
                kosong();
//                System.out.println(comb.getSelectionModel().getSelectedItem());
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Nomor salah");
                alert.setHeaderText(null);
                alert.setContentText("Nomor telepon tidak sesuai");
                alert.showAndWait();
            }
        }
    }


    @FXML
    void hpssupklik(ActionEvent event) {
        if (txtidsup.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ID kosong");
            alert.setHeaderText("ID Supplier masih Kosong");
            alert.setContentText("Pilih dahulu ID Supplier yang ingin dihapus");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Konfirmasi Hapus");
            alert.setHeaderText(null);
            alert.setContentText("apakah anda yakin ingin menghapus Data User dengan ID "+txtidsup.getText()+"?");
            Optional<ButtonType> action = alert.showAndWait();

            if (action.get() == ButtonType.OK) {
                try {
                    String sql ="DELETE FROM supplier where id_supplier='"+txtidsup.getText()+"'";
                    java.sql.Connection conn=(Connection)Config.configDB();
                    java.sql.PreparedStatement pst=conn.prepareStatement(sql);
                    pst.execute();
                    Alert newalert = new Alert(Alert.AlertType.INFORMATION);
                    newalert.setTitle("Berhasil");
                    newalert.setHeaderText("Data berhasil dihapus");
                    newalert.setContentText("Data Supplier dengan ID "+txtidsup.getText()+" berhasil dihapus");
                    newalert.showAndWait();
                } catch (Exception e) {
                    Alert newalert = new Alert(Alert.AlertType.WARNING);
                    newalert.setTitle("Gagal");
                    newalert.setHeaderText("penghapusan data gagal");
                    newalert.setContentText(e.getMessage());
                    newalert.showAndWait();
                }
                setTable_sup();
                kosong();
            }
        }
    }

    void setTable_sup() {
        ObservableList<tbl_sup> list = FXCollections.observableArrayList();
        try {
            String sql = "select * from supplier ;";
            Connection conn = (Connection) Config.configDB();
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet res=stm.executeQuery(sql);
            while(res.next()){
                list.add(new tbl_sup(res.getString("id_supplier"),
                        res.getString("nama_supplier"),
                        res.getString("telp_supplier"),
                        res.getString("alamat_supplier")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        idsup.setCellValueFactory(new PropertyValueFactory<tbl_sup, String>("idsup"));
        namasup.setCellValueFactory(new PropertyValueFactory<tbl_sup, String>("namasup"));
        nomorsup.setCellValueFactory(new PropertyValueFactory<tbl_sup, String>("nomorsup"));
        alamatsup.setCellValueFactory(new PropertyValueFactory<tbl_sup, String>("alamatsup"));
        table_sup.setItems(list);
    }

    @FXML
    void carisupkey(KeyEvent event) {
        ObservableList<tbl_sup> list = FXCollections.observableArrayList();
        try {
            String sql = "select * from supplier "
                    + "where nama_supplier like '%" + carisup.getText() + "%'";
            Connection conn = (Connection) Config.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()) {
                list.add(new tbl_sup(res.getString("id_supplier"),
                        res.getString("nama_supplier"),
                        res.getString("telp_supplier"),
                        res.getString("alamat_supplier")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        idsup.setCellValueFactory(new PropertyValueFactory<tbl_sup, String>("idsup"));
        namasup.setCellValueFactory(new PropertyValueFactory<tbl_sup, String>("namasup"));
        nomorsup.setCellValueFactory(new PropertyValueFactory<tbl_sup, String>("nomorsup"));
        alamatsup.setCellValueFactory(new PropertyValueFactory<tbl_sup, String>("alamatsup"));
        table_sup.setItems(list);
    }
    @FXML
    void table_suponclick(MouseEvent event) {
        ObservableList<tbl_sup> list;
        list=table_sup.getSelectionModel().getSelectedItems();

        txtidsup.setText(list.get(0).getIdsup());
        txtidsup.setDisable(true);
        txtnamasup.setText(list.get(0).getNamasup());
        txtnomorsup.setText(list.get(0).getNomorsup());
        txtalamatsup.setText(list.get(0).getAlamatsup());
        btntmbhsup.setDisable(true);
    }

    @FXML
    void tmbhsupklik(ActionEvent event) {
        if (txtidsup.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ID kosong");
            alert.setHeaderText("ID Supplier masih Kosong");
            alert.setContentText("Masukkan ID Supplier terlebih dahulu!");
            alert.showAndWait();
        } else {
            String hp=txtnomorsup.getText();
            if (hp.matches("^[0-9]*") && hp.length()==12){
                try {
                    String sql = "INSERT INTO supplier VALUES ('"+txtidsup.getText()+"','"
                            +txtnamasup.getText()+"','"+txtalamatsup.getText()+"','"+
                            txtnomorsup.getText()+"')";
                    java.sql.Connection conn=(Connection)Config.configDB();
                    java.sql.PreparedStatement pst=conn.prepareStatement(sql);
                    pst.execute();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Berhasil");
                    alert.setHeaderText("Data berhasil ditambah");
                    alert.setContentText("Data Supplier dengan ID "+txtidsup.getText()+" berhasil ditambah");
                    alert.showAndWait();
                } catch (Exception e) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Gagal");
                    alert.setHeaderText("Data gagal disimpan!");
                    alert.setContentText(e.getMessage());
                    alert.showAndWait();
                }
                setTable_sup();
                kosong();
//                System.out.println(comb.getSelectionModel().getSelectedItem());
            } else {
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setTitle("Nomor salah");
                alert.setHeaderText(null);
                alert.setContentText("Nomor telepon tidak sesuai");
                alert.showAndWait();
            }
        }
    }

    void autoidsup() {
        try {
            //--> melakukan eksekusi query untuk mengambil data dari tabel
            String sql = "SELECT MAX(id_supplier) FROM supplier" ;
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            java.sql.ResultSet rs = pst.executeQuery(sql);
            while (rs.next()) {
                if (rs.getString(1) == null) {
                    txtidsup.setText("S"+"00001");
                } else {
                    rs.last();
                    String auto = rs.getString(1);
                    auto = auto.replace("S","");
                    int auto_id = Integer.parseInt(auto) +1;
                    String no = String.valueOf(auto_id);
                    int NomorJual = no.length();
                    //MENGATUR jumlah 0
                    for (int j = 0; j < 5 - NomorJual; j++) {
                        no = "0" + no;
                    }
                    txtidsup.setText("S"+no);
                }
            }
            rs.close();
            rs.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void kosong() {
        txtidsup.setText("");
        txtidsup.setDisable(false);
        txtnamasup.setText(null);
        txtalamatsup.setText(null);
        txtnomorsup.setText(null);
        btntmbhsup.setDisable(false);
        autoidsup();
    }

    @FXML
    void menudashklik(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void menugudangklik(MouseEvent event) throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("gudang.fxml"));
//        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
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
    void menureturklik(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("karyawan.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void menuriwayatklik(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("karyawan.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void menusetklik(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("karyawan.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void menutransklik(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("karyawan.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
