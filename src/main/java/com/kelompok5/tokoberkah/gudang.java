package com.kelompok5.tokoberkah;

import com.mysql.jdbc.Connection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.Pane;

import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class gudang implements Initializable {
    @FXML
    private Pane paneBarang;

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
    private Pane paneBarang1;

    @FXML
    private Button editbar;

    @FXML
    private Button hpsbar;

    @FXML
    private Pane paneBarang11;

    @FXML
    private Button tmbhbar;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        table_bar();
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
    void editbarklik(ActionEvent event) {

    }

    @FXML
    void hpsbarklik(ActionEvent event) {

    }

    @FXML
    void lhtsupklik(ActionEvent event) {

    }

    @FXML
    void tmbhbarklik(ActionEvent event) {

    }

}
