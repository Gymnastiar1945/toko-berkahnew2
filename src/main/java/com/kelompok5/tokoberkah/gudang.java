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
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

public class gudang implements Initializable {

    private Parent root;

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
    private Label back;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        panesupatas.setVisible(false);
        panesupkiri.setVisible(false);
        panesupkanan.setVisible(false);
        table_bar();
        setJmlbar();
    }

    @FXML
    private void table_bar(){
        ObservableList<tbl_gudang> list = FXCollections.observableArrayList();
        try {
            String sql = "select * from barang ;";
            Connection conn = (Connection) Config.configDB();
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet res=stm.executeQuery(sql);
            while(res.next()){
                list.add(new tbl_gudang(res.getString("id_barang"),
                        res.getString("nama_barang"),
                        res.getString("id_kategori"),
                        res.getDouble("jumlah"),
                        res.getString("id_satuan"),
                        res.getInt("harga_jual")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        kdbar.setCellValueFactory(new PropertyValueFactory<tbl_gudang, String>("kdbar"));
        namabar.setCellValueFactory(new PropertyValueFactory<tbl_gudang, String>("namabar"));
        ktgr.setCellValueFactory(new PropertyValueFactory<tbl_gudang, String>("ktgr"));
        qty.setCellValueFactory(new PropertyValueFactory<tbl_gudang, Double>("qty"));
        satuan.setCellValueFactory(new PropertyValueFactory<tbl_gudang, String>("satuan"));
        harga.setCellValueFactory(new PropertyValueFactory<tbl_gudang, Integer>("harga"));
        table_bar.setItems(list);
    }

    @FXML
    void editbarklik(ActionEvent event) throws IOException {
//        Parent root = FXMLLoader.load(getClass().getResource("editBarang.fxml"));
//        Scene scene = new Scene(root);
//        scene.setFill(Color.TRANSPARENT);
//        Stage stage = new Stage();
//        stage.setScene(scene);
//        stage.initStyle(StageStyle.TRANSPARENT);
//        stage.show();
        String kodebar = labelkdbar.getText();
        String enamabar = "", ekdbat = "", ektgr = "", eqty = "", esatuan = "", ehargabar = "";
        FXMLLoader loader = new FXMLLoader(getClass().getResource("editBarang.fxml"));
        root = loader.load();

        EditBarang  Editbarang = loader.getController();
        try {
            String sql = "SELECT * from barang "
                    +"where id_barang='"+labelkdbar.getText()+"';";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            java.sql.ResultSet rs = pst.executeQuery(sql);
            rs.next();
            enamabar= (rs.getString("nama_barang"));
            ekdbat = (rs.getString("barcode"));
            ektgr = (rs.getString("id_kategori"));
            eqty = (rs.getString("jumlah"));
            esatuan = (rs.getString("id_satuan"));
            ehargabar = (rs.getString("harga_jual"));

        } catch (SQLException e) {
        }
        Editbarang.kdbar.setText(kodebar);
        Editbarang.namabar.setText(enamabar);
        Editbarang.kdbat.setText(ekdbat);
        Editbarang.ktgr.setValue(ektgr);
        Editbarang.qty.setText(eqty);
        Editbarang.satuan.setValue(esatuan);
        Editbarang.hargabar.setText(ehargabar);



        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
    }

    @FXML
    void hpsbarklik(ActionEvent event) {

    }

    @FXML
    void lhtsupklik(ActionEvent event) throws IOException {
        panesupatas.setVisible(true);
        panesupkiri.setVisible(true);
        panesupkanan.setVisible(true);
        panetabbar.setVisible(false);
        panebarkiri.setVisible(false);
        panebarkanan.setVisible(false);

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
        Parent root = FXMLLoader.load(getClass().getResource("tambaBarang.fxml"));
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
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
        labelqty.setText(jml+(list.get(0).getSatuan()));
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
                    alert.setTitle("Berhasil");
                    alert.setHeaderText("Data berhasil dihapus");
                    alert.setContentText("Data Supplier dengan ID "+txtidsup.getText()+" berhasil dihapus");
                    alert.showAndWait();
                } catch (Exception e) {
                    Alert newalert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Gagal");
                    alert.setHeaderText("penghapusan data gagal");
                    alert.setContentText(e.getMessage());
                    alert.showAndWait();
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
    void table_suponclick(MouseEvent event) {
        ObservableList<tbl_sup> list;
        list=table_sup.getSelectionModel().getSelectedItems();

        txtidsup.setText(list.get(0).getIdsup());
        txtnamasup.setText(list.get(0).getNamasup());
        txtnomorsup.setText(list.get(0).getNomorsup());
        txtalamatsup.setText(list.get(0).getAlamatsup());
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

    private void kosong() {
        txtidsup.setText("");
        txtnamasup.setText(null);
        txtalamatsup.setText(null);
        txtnomorsup.setText(null);
    }

}
