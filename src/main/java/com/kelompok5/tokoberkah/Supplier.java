package com.kelompok5.tokoberkah;

import com.mysql.jdbc.Connection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;

public class Supplier implements Initializable {

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        setTable_sup();
    }

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
