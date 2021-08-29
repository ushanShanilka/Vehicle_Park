package lk.ijse.vehiclepark.controller;


import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextArea;
import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.paint.Paint;
import lk.ijse.vehiclepark.model.Driver;

import java.util.regex.Pattern;


public class AddDriverFormController {
    public JFXTextField txtDriverName;
    public JFXTextField txtNic;
    public JFXTextField txtDrivingLicenseNo;
    public JFXTextArea txtAddress;
    public JFXTextField txtContactNo;
    public JFXButton btnSaveDriver;

    public void saveDriverOnAction ( ActionEvent actionEvent ) {

        if ( Pattern.compile ( "^[A-z]{1,}[ ][A-z]{1,}$" ).matcher ( txtDriverName.getText ( ) ).matches ( ) ) {
            if ( Pattern.compile ( "^[0-9]{11,12}$" ).matcher ( txtNic.getText ( ) ).matches ( ) ) {
                if ( Pattern.compile ( "^[0-9]{11,12}$" ).matcher ( txtDrivingLicenseNo.getText ( ) ).matches ( ) ) {
                    if ( Pattern.compile("^[A-z]{1,}[ ][A-z]{1,}$").matcher(txtAddress.getText()).matches() ) {
                        if ( Pattern.compile("^[0-9]{9,10}$").matcher(txtContactNo.getText()).matches() ) {
                            Driver drivers=new Driver (
                                    txtDriverName.getText ( ) ,
                                    txtNic.getText ( ) ,
                                    txtDrivingLicenseNo.getText ( ) ,
                                    txtAddress.getText ( ) ,
                                    txtContactNo.getText ( )
                            );
                            try {
                                if ( DriverController.getInstance ( ).save ( drivers ) ) {
                                    Alert alert=new Alert ( Alert.AlertType.INFORMATION , "Driver is Saved" );
                                    alert.show ( );
                                }
                            } catch ( Exception e ) {
                                e.printStackTrace ( );
                            }
                        }else {
                            txtContactNo.setFocusColor ( Paint.valueOf ( "red" ) );
                            txtContactNo.requestFocus ( );
                        }
                    }else {
                        txtAddress.setFocusColor ( Paint.valueOf ( "red" ) );
                        txtAddress.requestFocus ( );
                    }
                }
                else {
                    txtDrivingLicenseNo.setFocusColor ( Paint.valueOf ( "red" ) );
                    txtDrivingLicenseNo.requestFocus ( );
                }
            }else {
                txtNic.setFocusColor ( Paint.valueOf ( "red" ) );
                txtNic.requestFocus ( );
            }
        }else {
            txtDriverName.setFocusColor ( Paint.valueOf ( "red" ) );
            txtDriverName.requestFocus ( );
        }

    }

}
