package com.kelompok5.tokoberkah;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;
import java.sql.Connection;

public class LoginPage extends App {


    public static void main(String[] args) {
        launch(args);
    }

    @FXML
    private TextField txtuser;

    @FXML
    private PasswordField txtpass;

    @FXML
    private Button BtnLogin;


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
                } else if (user_tipe.equals("kasir")) {
                    System.out.println("Error");
                }
            }
        } catch (Exception e) {
            System.out.println("Error");
        }
//        if (username.equals("admin") && password.equals("admin") ) {
//            try {
//                Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));
//                Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
//                Scene scene = new Scene(root);
//                stage.setScene(scene);
//                stage.show();
//            }
//            catch(Exception e) {
//                e.printStackTrace();
//            }
//            } else {
//            System.out.println("Error");
//        }
//        System.out.println("Error");
    }

//    public void start(Stage primaryStage) {
//        Pane root = new Pane();
//        root.setStyle("-fx-background-radius: 6;" + "-fx-background-color: rgb(45, 45, 50), rgb(60, 60, 65);" + "-fx-background-insets: 0, 0 1 1 0;");
//        Scene scene = new Scene(root, 290, 120, Color.TRANSPARENT);
//        primaryStage.setScene(scene);
//        primaryStage.initStyle(StageStyle.TRANSPARENT);
//        primaryStage.show(); // За верхнюю часть высотой 22 можно перемещать окно: com.sun.glass.ui.Window.getWindows().get(0).setUndecoratedMoveRectangle(22); }
//    }

}
