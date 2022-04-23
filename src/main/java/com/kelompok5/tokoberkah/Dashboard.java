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
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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
    private Pane panePendapatan;

    @FXML
    private Pane panePengeluaran;

    @FXML
    private Pane panetrans;

    //menu
    @FXML
    private Label logout;

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

    @FXML
    private Label blnpenda;

    @FXML
    private Label blnpenge;

    @FXML
    private Label blnpendachart;

    @FXML
    private Label blnpengechart;

    @FXML
    private TableView<tbl_dbbarang> table_dbbarang;

    @FXML
    private TableColumn<tbl_dbbarang, String> colbar;

    @FXML
    private TableColumn<tbl_dbbarang, String> colktgr;

    @FXML
    private TableColumn<tbl_dbbarang, String> colnama;

    @FXML
    private TableColumn<tbl_dbbarang, Integer> colno;

    @FXML
    private TableColumn<tbl_dbbarang, Double> colqty;

    @FXML
    private TableColumn<tbl_dbbarang, String> colsatuan;

    @FXML
    private TableView<tbl_dbtrans> table_dbtrans;

    @FXML
    private TableColumn<tbl_dbtrans, Integer> no;

    @FXML
    private TableColumn<tbl_dbtrans, String> idPenjualan;

    @FXML
    private TableColumn<tbl_dbtrans, String> tanggal;

    @FXML
    private TableColumn<tbl_dbtrans, String> jam;

    @FXML
    private TableColumn<tbl_dbtrans, Integer> ttl_byr;

    @FXML
    private TableColumn<tbl_dbtrans, String> kasir;

    @FXML
    private AreaChart<?, ?> areapendapatan;

    @FXML
    private AreaChart<?, ?> areaPengeluaran;

    //seng ruwet
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Trans();
        Pendapatan();
        Pengeluaran();
        stokbarang();
        tabletrans();
        hidePade();

    }


    //code here
//    void label() {
//        lblTrans.setText("ststtsts");
//    }

    private void Trans() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime tanggal = LocalDateTime.now();
        String a = (dtf.format(tanggal));
        try {
            String sql = "SELECT count(id_penjualan) as total from penjualan "
                    + "where tanggal_transaksi='" + a + "' ;";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            java.sql.ResultSet rs = pst.executeQuery(sql);
            rs.next();
            lblTrans.setText(rs.getString("total"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void Pendapatan() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM");
        LocalDateTime tanggal = LocalDateTime.now();
        String a = (dtf.format(tanggal));
        int b = Integer.parseInt(a);
        switch (b) {
            case 1:
                blnpenda.setText("Januari");
                blnpenge.setText("Januari");
                break;
            case 2:
                blnpenda.setText("Februari");
                blnpenge.setText("Februari");
                break;
            case 3:
                blnpenda.setText("Maret");
                blnpenge.setText("Maret");
                break;
            case 4:
                blnpenda.setText("April");
                blnpenge.setText("April");
                break;
            case 5:
                blnpenda.setText("Mei");
                blnpenge.setText("Mei");
                break;
            case 6:
                blnpenda.setText("Juni");
                blnpenge.setText("Juni");
                break;
            case 7:
                blnpenda.setText("Juli");
                blnpenge.setText("Juli");
                break;
            case 8:
                blnpenda.setText("Agustus");
                blnpenge.setText("Agustus");
                break;
            case 9:
                blnpenda.setText("September");
                blnpenge.setText("September");
                break;
            case 10:
                blnpenda.setText("Oktober");
                blnpenge.setText("Oktober");
                break;
            case 11:
                blnpenda.setText("November");
                blnpenge.setText("November");
                break;
            case 12:
                blnpenda.setText("Desember");
                blnpenge.setText("Desember");
                break;
        }
        blnpendachart.setText(blnpenda.getText());
        blnpengechart.setText(blnpenda.getText());
        try {
            String sql = "SELECT sum(total_bayar) as total from penjualan "
                    + "where tanggal_transaksi between '2021-"+a+"-01' and '2022-"+a+"-31'";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            java.sql.ResultSet rs = pst.executeQuery(sql);
            rs.next();
            RP rupiah = new RP();
            lblPendapatan.setText(rupiah.formatRupiah((int) rs.getDouble("total")).replace(".00", "").replace(",", "."));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void Pengeluaran() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM");
        LocalDateTime tanggal = LocalDateTime.now();
        String a = (dtf.format(tanggal));
        try {
            String sql = "SELECT sum(uang) as total from pembelian "
                    + "where tanggal_transaksi between '2021-"+a+"-01' and '2022-"+a+"-31'";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            java.sql.ResultSet rs = pst.executeQuery(sql);
            rs.next();
            RP rupiah = new RP();
            lblPengeluaran.setText(rupiah.formatRupiah((int) rs.getDouble("total")).replace(".00", "").replace(",", "."));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void stokbarang() {
        try {
            String sql = "SELECT count(id_barang) as total from barang "
                    + "where jumlah<=5 ;";
            java.sql.Connection conn=(Connection)Config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            java.sql.ResultSet rs = pst.executeQuery(sql);
            rs.next();
            lblStokbrg.setText(rs.getString("total"));

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void tabletrans() {
        int nom = 1;
        ObservableList<tbl_dbtrans> list = FXCollections.observableArrayList();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDateTime tgl = LocalDateTime.now();
        String a = (dtf.format(tgl));
        try {
            String sql = "SELECT * from penjualan "
                    + "where tanggal_transaksi='"+a+"' ;";
            Connection conn = (Connection) Config.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()) {
                list.add(new tbl_dbtrans(nom++, res.getString("id_penjualan"),
                        res.getString("jam_transaksi"),
                        res.getInt("total_bayar"),
                        res.getString("id_pengguna")));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        no.setCellValueFactory(new PropertyValueFactory<tbl_dbtrans, Integer>("no"));
        idPenjualan.setCellValueFactory(new PropertyValueFactory<tbl_dbtrans, String>("IdPenjualan"));
        jam.setCellValueFactory(new PropertyValueFactory<tbl_dbtrans, String>("Jam"));
        ttl_byr.setCellValueFactory(new PropertyValueFactory<tbl_dbtrans, Integer>("ttl_byr"));
        kasir.setCellValueFactory(new PropertyValueFactory<tbl_dbtrans, String>("Kasir"));
        table_dbtrans.setItems(list);
    }

    private void tablebar() {
        int nom = 1;
        ObservableList<tbl_dbbarang> list = FXCollections.observableArrayList();

        try {
            String sql = "select barang.id_barang, barang.nama_barang, kategori.jenis, jumlah, satuan.satuan "
                    + "from barang join kategori on barang.id_kategori = kategori.id_kategori "
                    + "join satuan on barang.id_satuan = satuan.id_satuan "
                    + "where jumlah<=5 ;";
            Connection conn = (Connection) Config.configDB();
            java.sql.Statement stm = conn.createStatement();
            java.sql.ResultSet res = stm.executeQuery(sql);
            while (res.next()) {
                list.add(new tbl_dbbarang(nom++, res.getString(1),
                        res.getString(2),
                        res.getString(3),
                        res.getDouble(4),
                        res.getString(5)));
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        colno.setCellValueFactory(new PropertyValueFactory<tbl_dbbarang, Integer>("colno"));
        colbar.setCellValueFactory(new PropertyValueFactory<tbl_dbbarang, String>("colbar"));
        colnama.setCellValueFactory(new PropertyValueFactory<tbl_dbbarang, String>("colnama"));
        colktgr.setCellValueFactory(new PropertyValueFactory<tbl_dbbarang, String>("colktgr"));
        colqty.setCellValueFactory(new PropertyValueFactory<tbl_dbbarang, Double>("colqty"));
        colsatuan.setCellValueFactory(new PropertyValueFactory<tbl_dbbarang, String>("colsatuan"));
        table_dbbarang.setItems(list);
    }

    public void hidePade() {
        panetrans.setVisible(true);
        paneBarang.setVisible(false);
        panePendapatan.setVisible(false);
        panePengeluaran.setVisible(false);
    }

    @FXML
    void logoutklik(MouseEvent event) {

    }

    @FXML
    void menugudangklik(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("gudang.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
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
    void menureturklik(MouseEvent event) {

    }

    @FXML
    void menuriwayatklik(MouseEvent event) {

    }

    @FXML
    void menusetklik(MouseEvent event) {

    }

    @FXML
    void menutransklik(MouseEvent event) {

    }

    public void PendapatanChart() {
        XYChart.Series series = new XYChart.Series();
//        series.getData().add(new XYChart.Data("1", 23));
//        series.getData().add(new XYChart.Data("2", 20));
//        series.getData().add(new XYChart.Data("3", 10));
//        series.getData().add(new XYChart.Data("4", 15));
//        series.getData().add(new XYChart.Data("5", 25));
//        series.getData().add(new XYChart.Data("6", 30));
//        series.getData().add(new XYChart.Data("7", 40));
//        series.getData().add(new XYChart.Data("9", 23));
//        series.getData().add(new XYChart.Data("10", 20));
//        series.getData().add(new XYChart.Data("11", 23));
//        series.getData().add(new XYChart.Data("12", 23));
//        series.getData().add(new XYChart.Data("13", 23));
//        series.getData().add(new XYChart.Data("14", 23));
//        series.getData().add(new XYChart.Data("15", 23));
//        series.getData().add(new XYChart.Data("16", 23));
//        series.getData().add(new XYChart.Data("17", 23));
//        series.getData().add(new XYChart.Data("18", 23));
//        series.getData().add(new XYChart.Data("19", 23));
//        series.getData().add(new XYChart.Data("20", 23));
//        series.getData().add(new XYChart.Data("21", 23));
//        series.getData().add(new XYChart.Data("22", 23));
//        series.getData().add(new XYChart.Data("23", 23));
//        series.getData().add(new XYChart.Data("24", 120));
//        series.getData().add(new XYChart.Data("25", 23));
//        series.getData().add(new XYChart.Data("26", 23));
//        series.getData().add(new XYChart.Data("27", 23));
//        series.getData().add(new XYChart.Data("28", 23));
//        series.getData().add(new XYChart.Data("29", 23));
//        series.getData().add(new XYChart.Data("30", 23));
//        series.getData().add(new XYChart.Data("31", 23));
//
//        final NumberAxis xAxis = new NumberAxis();
//        final NumberAxis yAxis = new NumberAxis();
//        xAxis.setLabel("Date");
//        yAxis.setLabel("Events");
//
//        final AreaChart<Number,Number> lineChart = new AreaChart<>(xAxis, yAxis);
//        AreaChart.setTitle("Events");

//        NumberAxis xAxis = new NumberAxis();
//        NumberAxis yAxis = new NumberAxis();

        for (int i = 1; i <=31; i++) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM");
            LocalDateTime tanggal = LocalDateTime.now();
            String a = (dtf.format(tanggal));
            int j = 0;
            try {
                String sql = "SELECT sum(total_bayar) as total from penjualan "
                        + "where tanggal_transaksi between '2022-04-"+i+"' and '2022-04-"+i+"'";
                java.sql.Connection conn = (Connection) Config.configDB();
                PreparedStatement pst = conn.prepareStatement(sql);
                ResultSet rs = pst.executeQuery(sql);
                rs.next();
                j = rs.getInt("total");

            } catch (SQLException e) {
                e.printStackTrace();
            }
            series.getData().add(new XYChart.Data(""+i+"", j));
//
//            Tooltip.install(series.getNode(), new Tooltip(
//                    series.getXValue.toString() + "\n" +
//                            "Number Of Events : " + series.getYValue()));
//
//            //Adding class on hover
//            series.getNode().setOnMouseEntered(event -> series.getNode().getStyleClass().add("onHover"));
//
//            //Removing class on exit
//            series.getNode().setOnMouseExited(event -> series.getNode().getStyleClass().remove("onHover"));

//            Node node = data.getNode();
//            Tooltip tooltip = new Tooltip(
//                    '(' + data.getXValue().toString() + ';' + data.getYValue().toString() + ')');
//            Tooltip.install(node, tooltip);
        }
        areapendapatan.setVerticalGridLinesVisible(false);
        areapendapatan.getData().setAll(series);
        areapendapatan.setLegendVisible(false);
        areapendapatan.createSymbolsProperty();
    }
    public void PengeluaranChart(){
        areaPengeluaran.setVerticalGridLinesVisible(false);
        XYChart.Series series2 = new XYChart.Series();
//        series2.getData().add(new XYChart.Data("1",23));
//        series2.getData().add(new XYChart.Data("2",20));
//        series2.getData().add(new XYChart.Data("3",10));
//        series2.getData().add(new XYChart.Data("4",15));
//        series2.getData().add(new XYChart.Data("5",25));
//        series2.getData().add(new XYChart.Data("6",30));
//        series2.getData().add(new XYChart.Data("7",40));
//        series2.getData().add(new XYChart.Data("9",23));
//        series2.getData().add(new XYChart.Data("10",20));
//        series2.getData().add(new XYChart.Data("11",23));
//        series2.getData().add(new XYChart.Data("12",23));
//        series2.getData().add(new XYChart.Data("13",23));
//        series2.getData().add(new XYChart.Data("14",23));
//        series2.getData().add(new XYChart.Data("15",23));
//        series2.getData().add(new XYChart.Data("16",23));
//        series2.getData().add(new XYChart.Data("17",23));
//        series2.getData().add(new XYChart.Data("18",23));
//        series2.getData().add(new XYChart.Data("19",23));
//        series2.getData().add(new XYChart.Data("20",23));
//        series2.getData().add(new XYChart.Data("21",23));
//        series2.getData().add(new XYChart.Data("22",23));
//        series2.getData().add(new XYChart.Data("23",23));
//        series2.getData().add(new XYChart.Data("24",23));
//        series2.getData().add(new XYChart.Data("25",23));
//        series2.getData().add(new XYChart.Data("26",23));
//        series2.getData().add(new XYChart.Data("27",23));
//        series2.getData().add(new XYChart.Data("28",23));
//        series2.getData().add(new XYChart.Data("29",23));
//        series2.getData().add(new XYChart.Data("30",23));
//        series2.getData().add(new XYChart.Data("31",23));
        for (int i = 1; i <=31; i++) {
            DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM");
            LocalDateTime tanggal = LocalDateTime.now();
            String a = (dtf.format(tanggal));
            int j = 0;
            try {
                String sql = "SELECT sum(uang) as total from pembelian "
                        + "where tanggal_transaksi between '2022-04-"+i+"' and '2022-04-"+i+"'";
                java.sql.Connection conn = (Connection) Config.configDB();
                java.sql.PreparedStatement pst = conn.prepareStatement(sql);
                java.sql.ResultSet rs = pst.executeQuery(sql);
                rs.next();
                j = rs.getInt("total");

            } catch (SQLException e) {
                e.printStackTrace();
            }
            
            series2.getData().add(new XYChart.Data(""+i+"", j));
        }
        areaPengeluaran.setLegendVisible(false);
        areaPengeluaran.setVerticalGridLinesVisible(false);
        areaPengeluaran.getData().setAll(series2);
    }

    @FXML
    void btndtlTransact(ActionEvent event) {
        tabletrans();
        panetrans.setVisible(true);
        paneBarang.setVisible(false);
        panePendapatan.setVisible(false);
        panePengeluaran.setVisible(false);
    }

    @FXML
    void btndtlPendapatanact(ActionEvent event) {
        PendapatanChart();
        panetrans.setVisible(false);
        paneBarang.setVisible(false);
        panePendapatan.setVisible(true);
        panePengeluaran.setVisible(false);
    }

    @FXML
    void btndtlpengeluaranact(ActionEvent event) {
        PengeluaranChart();
        panetrans.setVisible(false);
        paneBarang.setVisible(false);
        panePendapatan.setVisible(false);
        panePengeluaran.setVisible(true);
    }

    @FXML
    void btnStokbrgact(ActionEvent event) {
        tablebar();
        panetrans.setVisible(false);
        paneBarang.setVisible(true);
        panePendapatan.setVisible(false);
        panePengeluaran.setVisible(false);
    }
}

