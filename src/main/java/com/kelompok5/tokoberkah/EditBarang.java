package com.kelompok5.tokoberkah;

import com.mysql.jdbc.Connection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class EditBarang implements Initializable {

    @FXML
    private Button btneditbar;

    @FXML
    private Button cancel;

    @FXML
    public TextField hargabar;

    @FXML
    public Label kdbar;

    @FXML
    public TextField kdbat;

    @FXML
    public ComboBox<String> ktgr;

    @FXML
    public TextField namabar;

    @FXML
    public TextField qty;

    @FXML
    public ComboBox<String> satuan;

    @FXML
    private ComboBox<String> sup;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        isiktgr();
        isisatuan();
        isisup();
        setkdbar();
        initisi();
    }
    public void setkdbar() {
        String kodebar = "";
        String enamabar = "", ekdbat = "", ektgr = "", eqty = "", esatuan = "", ehargabar = "";
        kdbar.setText(kodebar);
        namabar.setText(enamabar);
        kdbat.setText(ekdbat);
        ktgr.setValue(ektgr);
        qty.setText(eqty);
        satuan.setValue(esatuan);
        hargabar.setText(ehargabar);
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
    void editbaract(ActionEvent event) {
        if (kdbar.getText().equals("")) {
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle(" kosong");
            alert.setHeaderText("Kode Barang masih Kosong");
            alert.setContentText("Pilih dahulu barang yang ingin diedit!");
            alert.showAndWait();
        } else {
            try {
                String sqll ="UPDATE barang "
                        + "SET nama_barang = '"+namabar.getText()
                        +"', jumlah = '" +qty.getText()
                        +"', id_kategori = '" +satuan.getSelectionModel().getSelectedItem()
                        +"', id_satuan = '" +satuan.getSelectionModel().getSelectedItem()
                        +"', harga_jual = '"+hargabar
                        +"', barcode = '"+kdbat
                        +"', id_sup = '"+sup.getSelectionModel().getSelectedItem()
                        +"' WHERE barang.id_barang = '"+kdbar.getText()+"'";
                java.sql.Connection conn=(Connection)Config.configDB();
                java.sql.PreparedStatement pstl=conn.prepareStatement(sqll);
                pstl.execute();
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Berhasil");
                alert.setHeaderText("Data berhasil disimpan");
                alert.setContentText("Data Barang dengan Kode "+kdbar.getText()+" berhasil diubah");
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

    private void initisi() {
        try {
            String sql = "SELECT * from barang "
                    +"where id_barang='"+kdbar.getText()+"';";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            java.sql.ResultSet rs = pst.executeQuery(sql);
            rs.next();
            namabar.setText(rs.getString("nama_barang"));
            kdbat.setText(rs.getString("barcode"));
            ktgr.setValue(rs.getString("id_kategori"));
            qty.setText(rs.getString("jumlah"));
            satuan.setValue(rs.getString("id_satuan"));
            hargabar.setText(rs.getString("harga_jual"));

        } catch (SQLException e) {
        }
    }
}
