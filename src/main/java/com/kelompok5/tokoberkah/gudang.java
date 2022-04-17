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
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class gudang implements Initializable {

    private Parent root;

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

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
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

        FXMLLoader loader = new FXMLLoader(getClass().getResource("editBarang.fxml"));
        root = loader.load();

        EditBarang  Editbarang = loader.getController();
        Editbarang.kdbar.setText(kodebar);

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
        Parent root = FXMLLoader.load(getClass().getResource("supplier.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
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

}
