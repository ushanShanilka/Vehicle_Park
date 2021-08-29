package lk.ijse.vehiclepark.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.regex.Pattern;

public class LoginFormController {
    public JFXTextField txtUserName;
    public AnchorPane root;

    public JFXButton btnCancel;
    public JFXButton btnLogin;
    public JFXPasswordField txtPassword;

    public void cancelOnActon ( ActionEvent actionEvent ) {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }

    public void loginOnAction ( ActionEvent actionEvent ) throws IOException {

        if ( Pattern.compile( "^[a-z]{5}$").matcher( txtUserName.getText()).matches()) {
            if (Pattern.compile("^[0-9]{4}$").matcher(txtPassword.getText()).matches()) {
                String name = txtUserName.getText().trim();
                String password = txtPassword.getText().trim();
                if (name.length()>0 && password.length()>0){

                    if (name.equalsIgnoreCase("ushan")
                        && password.equalsIgnoreCase("1234")){
                        Stage stage = (Stage) btnCancel.getScene().getWindow();
                        stage.close();

                        Scene scene = new Scene ( FXMLLoader.load( getClass().getResource( "../view/ManagementDashBoardForm.fxml")));
                        Stage primaryStage = new Stage();
                        primaryStage.setScene(scene);
                        primaryStage.show ();

                    }else{
                        new Alert ( Alert.AlertType.WARNING, "Try Again !!!!",
                                    ButtonType.OK, ButtonType.NO).show();
                    }
                }else{
                    new Alert(Alert.AlertType.WARNING,"Empty !!!!",
                              ButtonType.OK,ButtonType.NO).show();
                }
            }else{
                txtPassword.setFocusColor( Paint.valueOf( "red"));
                txtPassword.requestFocus();
            }
        }else{
            txtUserName.setFocusColor(Paint.valueOf("red"));
            txtUserName.requestFocus();

        }
    }
}
