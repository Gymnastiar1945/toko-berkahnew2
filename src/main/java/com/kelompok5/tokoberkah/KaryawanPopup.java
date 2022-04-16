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
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class KaryawanPopup extends App implements Initializable {

    @FXML
    private TextField txtid;

    @FXML
    private PasswordField txtpass;

    @FXML
    private TextField txtnama;

    @FXML
    private TextField txtnomor;

    @FXML
    private TextField txtalamat;

    @FXML
    private ComboBox<String> comb;

    @FXML
    private Button cancel;

    @FXML
    private Button tambahkar;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    ObservableList<String> list = FXCollections.observableArrayList("Admin", "Karyawan");
    comb.setItems(list);
    }

    @FXML
    public void tambahkar(ActionEvent evt) {
        if (txtid.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("ID kosong");
            alert.setHeaderText("ID masih Kosong");
            alert.setContentText("Masukkan ID Karyawan terlebih dahulu!");
            alert.showAndWait();
        } else {
            String hp=txtnomor.getText();
            if (hp.matches("^[0-9]*") && hp.length()==12){
                try {
                    String sqll = "INSERT INTO pengguna VALUES ('"+txtid.getText()+"','"
                            +txtnama.getText()+"','"+txtalamat.getText()+"','"+
                            txtnomor.getText()+"','"+comb.getSelectionModel().getSelectedItem()+"','"+txtpass.getText()+"')";
                    java.sql.Connection conn=(Connection)Config.configDB();
                    java.sql.PreparedStatement pstl=conn.prepareStatement(sqll);
                    pstl.execute();
                    Alert alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Berhasil");
                    alert.setHeaderText("Data berhasil disimpan");
                    alert.setContentText("Data User dengan ID "+txtid.getText()+" berhasil disimpan");
                    alert.showAndWait();
                    Stage stage = (Stage) ((Node) evt.getSource()).getScene().getWindow();
                    stage.close();
                } catch (Exception e) {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Gagal");
                    alert.setHeaderText("Data gagal disimpan!");
                    alert.setContentText(e.getMessage());
                    alert.showAndWait();
                }
                kosong();
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
        txtid.setText(null);
        txtnama.setText(null);
        txtalamat.setText(null);
        txtnomor.setText(null);
        txtpass.setText(null);
        comb.setValue(null);
//        txtcari.setText(null);
    }

    @FXML
    void cancelklik(ActionEvent event) {
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.close();
    }
}
