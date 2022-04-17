package com.kelompok5.tokoberkah;

import com.mysql.jdbc.Connection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class TambaBarang implements Initializable {
    @FXML
    private TextField kdbar;

    @FXML
    private TextField kdbat;

    @FXML
    private ComboBox<String> ktgr;

    @FXML
    private TextField namabar;

    @FXML
    private TextField hargabar;

    @FXML
    private TextField qty;

    @FXML
    private ComboBox<String> sup;

    @FXML
    private Button cancel;

    @FXML
    private Button btntambahbar;

    @FXML
    private ComboBox<String> satuan;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
       isiktgr();
       isisatuan();
       isisup();
    }
    private void isiktgr() {
        ObservableList<String> list = FXCollections.observableArrayList("atk","atb");
        ktgr.setItems(list);
    }

    private void isisatuan() {
        ObservableList<String> list = FXCollections.observableArrayList("m","pcs");
        satuan.setItems(list);
    }

    private void isisup() {
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
        sup.setItems(list);
    }

    @FXML
    void cancelklik(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }

    @FXML
    void tambahbaract(ActionEvent event) {
        if (kdbar.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle(" kosong");
            alert.setHeaderText("Kode Barang masih Kosong");
            alert.setContentText("Masukkan Kode Barang terlebih dahulu!");
            alert.showAndWait();
        } else {
                try {
                    String sqll = "INSERT INTO barang VALUES ('"+kdbar.getText()+"','"
                            +namabar.getText()+"','"
                            +ktgr.getSelectionModel().getSelectedItem()+"','"
                            +satuan.getSelectionModel().getSelectedItem()+"','"
                            +qty.getText()+"','"
                            +kdbat.getText()+"','"
                            +hargabar.getText()+"')";
                    java.sql.Connection conn=(Connection)Config.configDB();
                    java.sql.PreparedStatement pstl=conn.prepareStatement(sqll);
                    pstl.execute();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Berhasil");
                    alert.setHeaderText("Data berhasil disimpan");
                    alert.setContentText("Data Barang dengan Kode "+kdbar.getText()+" berhasil disimpan");
                    alert.showAndWait();
                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    stage.close();
                } catch (Exception e) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Gagal");
                    alert.setHeaderText("Data gagal disimpan!");
                    alert.setContentText(e.getMessage());
                    alert.showAndWait();
                }
//                kosong();

        }
    }

}
