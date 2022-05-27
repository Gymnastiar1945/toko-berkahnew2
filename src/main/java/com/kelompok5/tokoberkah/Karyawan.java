package com.kelompok5.tokoberkah;

import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.events.JFXDialogEvent;
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
import javafx.scene.effect.BoxBlur;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.SVGPath;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import net.sf.jasperreports.engine.xml.JRPenFactory;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;


public class Karyawan extends App implements Initializable {

    private Parent root;

    @FXML
    private StackPane stackalert;

    @FXML
    private Pane bluralert;

    @FXML
    private Pane alert;

    @FXML
    private Label judulalert;

    @FXML
    private Label keterangan;

    @FXML
    private SVGPath svg;

    @FXML
    private Button ya;



    @FXML
    private StackPane stackblur;

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
    private TextField carikar;

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
    private Label menudash;

    @FXML
    private Pane panepopupkaryawan;

    @FXML
    private Pane blur;

    @FXML
    private ComboBox<String> pcomb;

    @FXML
    private TextField ptxtalamat;

    @FXML
    private TextField ptxtid;

    @FXML
    private TextField ptxtnama;

    @FXML
    private TextField ptxtnomor;

    @FXML
    private PasswordField ptxtpass;

    @FXML
    private Button cancel;

    @FXML
    private Button tambahkar;


//    public  String[] status = {"Admin","Karyawan"};

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> list = FXCollections.observableArrayList("Admin","Karyawan");
        comb.setItems(list);
        pcomb.setItems(list);
        tbl_kar();
        panepopupkaryawan.setVisible(false);
        blur.setVisible(true);


//        myChoiceBox.getItems().add("ehe");
    }

    @FXML
    public void tmbhkar(ActionEvent event) throws IOException {
        BoxBlur blur1 = new BoxBlur(3,3,3);

        JFXDialog dialog = new JFXDialog( stackblur, panepopupkaryawan, JFXDialog.DialogTransition.TOP);

        dialog.show();
        dialog.setOnDialogClosed((JFXDialogEvent event1) -> {
            blur.setEffect(null);
        });

        tambahkar.addEventHandler(MouseEvent.MOUSE_CLICKED,(MouseEvent mouseEvent) -> {
            if (ptxtid.getText().equals("")) {

                JFXDialog dialogalert = new JFXDialog( stackalert, alert, JFXDialog.DialogTransition.CENTER);

                dialogalert.show();
                dialogalert.setOnDialogClosed((JFXDialogEvent event1) -> {
                    bluralert.setEffect(null);
                });
                ya.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent mouseEventalert) -> {
                    dialogalert.close();
                });
                bluralert.setEffect(blur1);



                judulalert.setText("ID masih kosong");
                keterangan.setText("Masukkan ID karyawan terlebih dahulu!");
                svg.setContent("M 11.25 67.5 C 11.25 36.45 36.3937 11.25 67.4437 11.25 C 98.55 11.25 123.75 36.45 123.75 67.5 C 123.75 98.55 98.55 123.75 67.4437 123.75 C 36.3937 123.75 11.25 98.55 11.25 67.5 Z M 73.125 45 C 73.125 41.9062 70.5938 39.375 67.5 39.375 C 64.4062 39.375 61.875 41.9062 61.875 45 V 67.5 C 61.875 70.5938 64.4062 73.125 67.5 73.125 C 70.5938 73.125 73.125 70.5938 73.125 67.5 V 45 Z M 67.5 112.5 C 42.6375 112.5 22.5 92.3625 22.5 67.5 C 22.5 42.6375 42.6375 22.5 67.5 22.5 C 92.3625 22.5 112.5 42.6375 112.5 67.5 C 112.5 92.3625 92.3625 112.5 67.5 112.5 Z M 61.875 84.375 V 95.625 H 73.125 V 84.375 H 61.875 Z");
                ya.getStyleClass().add("button-merah");
                alert.setVisible(true);

//                Alert alert = new Alert(Alert.AlertType.WARNING);
//                alert.setTitle("ID kosong");
//                alert.setHeaderText("ID masih Kosong");
//                alert.setContentText("Masukkan ID Karyawan terlebih dahulu!");
//                alert.showAndWait();
            } else {
                String hp=ptxtnomor.getText();
                if (hp.matches("^[0-9]*") && hp.length()==12){
                    try {
                        String sqll = "INSERT INTO pengguna VALUES ('"+ptxtid.getText()+"','"
                                +ptxtnama.getText()+"','"+ptxtalamat.getText()+"','"+
                                ptxtnomor.getText()+"','"+pcomb.getSelectionModel().getSelectedItem()+"','"+ptxtpass.getText()+"')";
                        java.sql.Connection conn=(Connection)Config.configDB();
                        java.sql.PreparedStatement pstl=conn.prepareStatement(sqll);
                        pstl.execute();


                        JFXDialog dialogalert = new JFXDialog( stackalert, alert, JFXDialog.DialogTransition.CENTER);
                        dialogalert.show();
                        dialogalert.setOnDialogClosed((JFXDialogEvent event1) -> {
                            bluralert.setEffect(null);
                        });
                        ya.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent mouseEventalert) -> {
                            dialogalert.close();
                            dialog.close();
                        });
                        bluralert.setEffect(blur1);

                        judulalert.setText("Berhasil");
                        keterangan.setText("Data Karyawan dengan ID "+ptxtid.getText()+" berhasil disimpan");
                        svg.setContent("M 67.5 11.25 C 36.45 11.25 11.25 36.45 11.25 67.5 C 11.25 98.55 36.45 123.75 67.5 123.75 C 98.55 123.75 123.75 98.55 123.75 67.5 C 123.75 36.45 98.55 11.25 67.5 11.25 Z M 67.5 112.5 C 42.6938 112.5 22.5 92.3063 22.5 67.5 C 22.5 42.6938 42.6938 22.5 67.5 22.5 C 92.3063 22.5 112.5 42.6938 112.5 67.5 C 112.5 92.3063 92.3063 112.5 67.5 112.5 Z M 56.25 79.7063 L 89.325 46.6313 C 91.5188 44.4375 95.1188 44.4375 97.3125 46.6313 C 99.5063 48.825 99.5063 52.3688 97.3125 54.5625 L 60.2438 91.6312 C 58.05 93.825 54.5063 93.825 52.3125 91.6312 L 37.7438 77.0625 C 35.55 74.8688 35.55 71.325 37.7438 69.1313 C 38.7947 68.078 40.2215 67.486 41.7094 67.486 C 43.1973 67.486 44.6241 68.078 45.675 69.1313 L 56.25 79.7063 Z");
                        svg.setFill(Color.rgb(70, 204, 89));
                        svg.setStroke(Color.rgb(70, 204, 89));
//
                        ya.getStyleClass().remove("button-merah");
                        ya.getStyleClass().add("button-hijau");
                        alert.setVisible(true);

//                        Alert alert = new Alert(Alert.AlertType.INFORMATION);
//                        alert.setTitle("Berhasil");
//                        alert.setHeaderText("Data berhasil disimpan");
//                        alert.setContentText("Data Karyawan dengan ID "+ptxtid.getText()+" berhasil disimpan");
//                        alert.showAndWait();
                        pkosong();
                        tbl_kar();

                    } catch (Exception e) {
                        Alert alert = new Alert(Alert.AlertType.WARNING);
                        alert.setTitle("Gagal");
                        alert.setHeaderText("Data gagal disimpan!");
                        alert.setContentText(e.getMessage());
                        alert.showAndWait();
                    }

                } else {
                    Alert alert = new Alert(Alert.AlertType.WARNING);
                    alert.setTitle("Nomor salah");
                    alert.setHeaderText(null);
                    alert.setContentText("Nomor telepon tidak sesuai");
                    alert.showAndWait();
                }
            }
        });

        cancel.addEventHandler(MouseEvent.MOUSE_CLICKED,(MouseEvent mouseEvent ) -> {
            dialog.close();

        });

        blur.setEffect(blur1);
        panepopupkaryawan.setVisible(true);
    }

    public void tbl_kar(){
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
                    newalert.setTitle("Berhasil");
                    newalert.setHeaderText("Data berhasil dihapus");
                    newalert.setContentText("Data User dengan ID "+txtid.getText()+" berhasil dihapus");
                    newalert.showAndWait();
                } catch (Exception e) {
                    Alert newalert = new Alert(Alert.AlertType.WARNING);
                    newalert.setTitle("Gagal");
                    newalert.setHeaderText("penghapusan data gagal");
                    newalert.setContentText(e.getMessage());
                    newalert.showAndWait();
                }
                tbl_kar();
                kosong();
            }
        }
    }

    private void kosong() {
        txtid.setText("");
        txtnama.setText(null);
        txtalamat.setText(null);
        txtnomor.setText(null);
        txtpass.setText(null);
        comb.setValue(null);
//        txtcari.setText(null);
    }

    @FXML
    void carikarkey(KeyEvent event) {
        ObservableList<tbl_karyawan> list = FXCollections.observableArrayList();
        try {
            String sql = "select * from pengguna "
                    + "where nama_pengguna like '%" + carikar.getText() + "%'";
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

    //POPUPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPPP
    @FXML
    public void tambahkar(ActionEvent evt) {

    }

    private void pkosong() {
        txtid.setText("");
        txtnama.setText(null);
        txtalamat.setText(null);
        txtnomor.setText(null);
        txtpass.setText(null);
        comb.setValue(null);
//        txtcari.setText(null);
    }

    @FXML
    void cancelklik(ActionEvent event) {
//        panepopupkaryawan.setVisible(false);
//        blur.setVisible(false);
    }

    @FXML
    void menudashklik(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
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
//        Parent root = FXMLLoader.load(getClass().getResource("karyawan.fxml"));
//        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//        Scene scene = new Scene(root);
//        stage.setScene(scene);
//        stage.show();
    }

    @FXML
    void menureturklik(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("karyawan.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void menuriwayatklik(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("karyawan.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void menusetklik(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("karyawan.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }

    @FXML
    void menutransklik(MouseEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("karyawan.fxml"));
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}

