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
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;


public class Karyawan extends App implements Initializable {

    @FXML
    private TableView<tbl_karyawan> table_karyawan;

    @FXML
    private TableColumn<tbl_karyawan, String> idkar;

    @FXML
    private TableColumn<tbl_karyawan, String> namakar;

    @FXML
    private TableColumn<tbl_karyawan, String> nomorkar;

    @FXML
    private TableColumn<tbl_karyawan, String> alamatkar;

    @FXML
    private TableColumn<tbl_karyawan, String> jeniskar;

    @FXML
    private TableColumn<tbl_karyawan, String> pwkar;

    @FXML
    private ComboBox<String> comb;

    @FXML
    private PasswordField txtpass;

    @FXML
    private TextField txtnama;

    @FXML
    private TextField txtnomor;

    @FXML
    private TextField txtalamat;

    @FXML
    private Label txtid;

    @FXML
    private Button tmbhkar;

    @FXML
    private Button editkar;

    @FXML
    private Button hapuskar;

    @FXML
    private Label dashboard;



//    public  String[] status = {"Admin","Karyawan"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> list = FXCollections.observableArrayList("Admin","Karyawan");
        comb.setItems(list);
        tbl_kar();


//        myChoiceBox.getItems().add("ehe");
    }

    @FXML
    public void tmbhkar(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("karyawanPopup.fxml"));
        Scene scene = new Scene(root);
        scene.setFill(Color.TRANSPARENT);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.initStyle(StageStyle.TRANSPARENT);
        stage.show();
    }

    private void tbl_kar(){
        ObservableList<tbl_karyawan> list = FXCollections.observableArrayList();
        try {
            String sql = "select * from pengguna ;";
            Connection conn = (Connection) Config.configDB();
                java.sql.Statement stm=conn.createStatement();
                java.sql.ResultSet res=stm.executeQuery(sql);
                while(res.next()){
                    list.add(new tbl_karyawan(res.getString("id_pengguna"),
                            res.getString("nama_pengguna"),
                            res.getString("telp_pengguna"),
                            res.getString("alamat_pengguna"),
                            res.getString("jenis_pengguna"),
                            res.getString("password")));
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

        idkar.setCellValueFactory(new PropertyValueFactory<tbl_karyawan, String>("idkar"));
        namakar.setCellValueFactory(new PropertyValueFactory<tbl_karyawan, String>("namakar"));
        nomorkar.setCellValueFactory(new PropertyValueFactory<tbl_karyawan, String>("nomorkar"));
        alamatkar.setCellValueFactory(new PropertyValueFactory<tbl_karyawan, String>("alamatkar"));
        jeniskar.setCellValueFactory(new PropertyValueFactory<tbl_karyawan, String>("jeniskar"));
        pwkar.setCellValueFactory(new PropertyValueFactory<tbl_karyawan, String>("pwkar"));
        table_karyawan.setItems(list);
    }

    @FXML
    public void table_karyawanonclick(MouseEvent evt) {
        ObservableList<tbl_karyawan> list;
        list=table_karyawan.getSelectionModel().getSelectedItems();

            txtid.setText(list.get(0).getIdkar());
            txtnama.setText(list.get(0).getNamakar());
            txtnomor.setText(list.get(0).getNomorkar());
            txtalamat.setText(list.get(0).getAlamatkar());
            comb.setValue(list.get(0).getJeniskar());
            txtpass.setText(list.get(0).getPwkar());
    }

    @FXML
    public void editkar(ActionEvent evt) {
        if (txtid.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ID kosong");
            alert.setHeaderText("ID masih Kosong");
            alert.setContentText("Pilih dahulu ID dari Table");
            alert.showAndWait();
        } else {
            String hp=txtnomor.getText();
            if (hp.matches("^[0-9]*") && hp.length()==12){
                try {
                    String sql ="UPDATE pengguna SET nama_pengguna = '"+txtnama.getText()
                            +"', alamat_pengguna = '"
                            +txtalamat.getText()
                            +"', telp_pengguna = '" +txtnomor.getText()
                            + "', jenis_pengguna = '"+comb.getSelectionModel().getSelectedItem()
                            +"', password = '"+txtpass.getText()
                            +"' WHERE pengguna.id_pengguna = '"+txtid.getText()+"'";
                    java.sql.Connection conn=(Connection)Config.configDB();
                    java.sql.PreparedStatement pst=conn.prepareStatement(sql);
                    pst.execute();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Berhasil");
                    alert.setHeaderText("Data berhasil diubah");
                    alert.setContentText("Data User dengan ID "+txtid.getText()+" berhasil diubah");
                    alert.showAndWait();
                } catch (Exception e) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Gagal");
                    alert.setHeaderText("Perubahan data gagal");
                    alert.setContentText(e.getMessage());
                    alert.showAndWait();
                }
                tbl_kar();
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
    public void hapuskar(ActionEvent evt) {
        if (txtid.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ID kosong");
            alert.setHeaderText("ID masih Kosong");
            alert.setContentText("Pilih dahulu ID yang ingin dihapus");
            alert.showAndWait();
        } else {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Konfirmasi Hapus");
            alert.setHeaderText(null);
            alert.setContentText("apakah anda yakin ingin menghapus Data User dengan ID "+txtid.getText()+"?");
            Optional <ButtonType> action = alert.showAndWait();

            if (action.get() == ButtonType.OK) {
                try {
                    String sql ="DELETE FROM pengguna where id_pengguna='"+txtid.getText()+"'";
                    java.sql.Connection conn=(Connection)Config.configDB();
                    java.sql.PreparedStatement pst=conn.prepareStatement(sql);
                    pst.execute();
                    Alert newalert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Berhasil");
                    alert.setHeaderText("Data berhasil dihapus");
                    alert.setContentText("Data User dengan ID "+txtid.getText()+" berhasil dihapus");
                    alert.showAndWait();
                } catch (Exception e) {
                    Alert newalert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Gagal");
                    alert.setHeaderText("penghapusan data gagal");
                    alert.setContentText(e.getMessage());
                    alert.showAndWait();
                }
                tbl_kar();
                kosong();
            }
        }
    }

    private void kosong() {
        txtid.setText(null);
        txtnama.setText(null);
        txtalamat.setText(null);
        txtnomor.setText(null);
        txtpass.setText(null);
        comb.setValue(null);
//        txtcari.setText(null);
    }

    @FXML
    void menudash(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}

