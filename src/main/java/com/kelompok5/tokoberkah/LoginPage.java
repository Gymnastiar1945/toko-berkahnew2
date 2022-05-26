package com.kelompok5.tokoberkah;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXDialog;
import com.jfoenix.controls.JFXDialogLayout;
import com.jfoenix.controls.events.JFXDialogEvent;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.BoxBlur;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.view.JasperViewer;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.util.HashMap;

public class LoginPage extends App {


    public static void main(String[] args) {
        launch(args);
    }


    @FXML
    private StackPane stackblur;

    @FXML
    private Pane blur;

    @FXML
    private Pane alert;

    @FXML
    private TextField txtuser;

    @FXML
    private PasswordField txtpass;

    @FXML
    private Button BtnLogin;

    @FXML
    private AnchorPane logn;

    @FXML
    private Button ya;

    @FXML
    public void BtnLogin(ActionEvent event) throws Exception {
        String username = txtuser.getText().toString();
        String password = txtpass.getText().toString();

        try {
            String sql = "SELECT id_pengguna, password, jenis_pengguna"
                    + " FROM pengguna"
                    + " WHERE id_pengguna='" + username
                    + "'AND password='" + password + "'";
            java.sql.Connection conn = (Connection) Config.configDB();
            java.sql.PreparedStatement pst = conn.prepareStatement(sql);
            java.sql.ResultSet rs = pst.executeQuery(sql);
            if (rs.next()) {
                String user_tipe = rs.getString("jenis_pengguna");
                if (user_tipe.equals("Admin")) {
                    try {
                        Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        Scene scene = new Scene(root);
                        stage.setScene(scene);
                        stage.show();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } else if (user_tipe.equals("Karyawan")) {
                    System.out.println("Error");
                }
            } else {
//
                BoxBlur blur1 = new BoxBlur(3, 3, 3);

                JFXDialog dialog = new JFXDialog(stackblur, alert, JFXDialog.DialogTransition.CENTER);

                dialog.show();
                dialog.setOnDialogClosed((JFXDialogEvent event1) -> {
                    blur.setEffect(null);
                });
                ya.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent mouseEvent) -> {
                    dialog.close();

                });

                blur.setEffect(blur1);
                alert.setVisible(true);
            }
        } catch (Exception e) {
            System.out.println("Error");
        }

//        try {
//            java.sql.Connection conn=(com.mysql.jdbc.Connection)Config.configDB();
////        String namafile = "src/kasir/report.jrxml";
////            InputStream report = getClass().getResourceAsStream("report/trans.jasper");
//            HashMap param = new HashMap();
//            param.put("kd_trans", txtuser.getText());
////        File file = new File(namafile);
////        JasperDesign jd = JRXmlLoader.load(namafile);
////        JasperReport jr = JasperCompileManager.compileReport(jd);
//            JasperPrint jp = JasperFillManager.fillReport("report/trans.jasper",param,conn);
//            JasperViewer.viewReport(jp, false);
//        } catch(Exception e) {
//            e.printStackTrace();
//        }
    }
}