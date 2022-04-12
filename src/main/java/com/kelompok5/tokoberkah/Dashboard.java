package com.kelompok5.tokoberkah;

import com.mysql.jdbc.Connection;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ResourceBundle;


public class Dashboard extends App implements Initializable {

    @FXML
    private Button btndtlTrans;

    @FXML
    private Button btndtlPendapatan;

    @FXML
    private Button btndtlpengeluaran;

    @FXML
    private Button btnStokbrg;

    @FXML
    private Label lblTrans;

    @FXML
    private Label lblPendapatan;

    @FXML
    private Label lblPengeluaran;

    @FXML
    private Label lblStokbrg;

    @FXML
    private Pane paneBarang;

    @FXML
    private Label menukar;



    @FXML
    private TableView<tbl_trans> table_dashboard;

    @FXML
    private TableColumn<tbl_trans, Integer> no;

    @FXML
    private TableColumn<tbl_trans, String> idPenjualan;

    @FXML
    private TableColumn<tbl_trans, String> tanggal;

    @FXML
    private TableColumn<tbl_trans, String> jam;

    @FXML
    private TableColumn<tbl_trans, Integer> ttl_byr;

    @FXML
    private TableColumn<tbl_trans, String> kasir;



    //seng ruwet
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    Trans();
    Pendapatan();
    table();
    hidePade();

    }


    //code here
//    void label() {
//        lblTrans.setText("ststtsts");
//    }

    private void Trans () {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime tanggal = LocalDateTime.now();
        String a = (dtf.format(tanggal));
        try {
            String sql = "SELECT count(id_penjualan) as total from penjualan "
                    + "where tanggal_transaksi='"+a+"' ;";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            java.sql.ResultSet rs = pst.executeQuery(sql);
            rs.next();
            lblTrans.setText(rs.getString("total"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void Pendapatan () {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM");
        LocalDateTime tanggal = LocalDateTime.now();
        String a = (dtf.format(tanggal));
        try {
            String sql = "SELECT sum(total_bayar) as total from penjualan "
                    + "where tanggal_transaksi between '2021-01-01' and '2022-01-01'";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            java.sql.ResultSet rs = pst.executeQuery(sql);
            rs.next();
            RP rupiah   = new RP();
            lblPendapatan.setText(rupiah.formatRupiah((int) rs.getDouble("total")).replace(".00", "").replace(",","."));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void table(){
        int nom = 1;
        ObservableList<tbl_trans>list = FXCollections.observableArrayList();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime tgl = LocalDateTime.now();
        String a = (dtf.format(tgl));
        try {
            String sql = "SELECT * from penjualan ";
//                    + "where tanggal_tranksaksi='"+a+"' ;";
            Connection conn = (Connection) Config.configDB();
            java.sql.Statement stm=conn.createStatement();
            java.sql.ResultSet res=stm.executeQuery(sql);
            while(res.next()){
                list.add(new tbl_trans(nom++,res.getString("id_penjualan"),
                        res.getString("tanggal_transaksi"),
                        res.getString("jam_transaksi"),
                        res.getInt("total_bayar"),
                        res.getString("id_pengguna")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        no.setCellValueFactory(new PropertyValueFactory<tbl_trans, Integer>("no"));
        idPenjualan.setCellValueFactory(new PropertyValueFactory<tbl_trans, String>("IdPenjualan"));
        tanggal.setCellValueFactory(new PropertyValueFactory<tbl_trans, String>("Tanggal"));
        jam.setCellValueFactory(new PropertyValueFactory<tbl_trans, String>("Jam"));
        ttl_byr.setCellValueFactory(new PropertyValueFactory<tbl_trans, Integer>("ttl_byr"));
        kasir.setCellValueFactory(new PropertyValueFactory<tbl_trans, String>("Kasir"));
        table_dashboard.setItems(list);
    }

    public void hidePade(){
        paneBarang.setVisible(false);
    }

    @FXML
    void menukarklik(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("karyawan.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}

