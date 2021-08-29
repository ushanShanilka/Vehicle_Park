package lk.ijse.vehiclepark.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import lk.ijse.vehiclepark.model.Vehicle;

import java.util.regex.Pattern;


public class AddVehicleFormController {
    public JFXTextField txtVehicleNumber;
    public JFXTextField txtMaximumWeight;
    public JFXTextField txtNoOfPassengers;
    public JFXButton btnSaveVehicle;
    public ComboBox cmbVehicleType;



    public void initialize(){
        ObservableList<Object> observableArrayList = FXCollections.observableArrayList();
        observableArrayList.add("Van");
        observableArrayList.add("Buss");
        observableArrayList.add("Lorry");
        cmbVehicleType.setItems(observableArrayList);


    }

    public void saveVehicleOnAction ( ActionEvent actionEvent ) {
        if ( Pattern.compile ( "^[A-Z]{2}(-)[0-9]{4}$" ).matcher ( txtVehicleNumber.getText () ).matches () ){
            if ( Pattern.compile("^[0-9]{4}$").matcher(txtMaximumWeight.getText()).matches() ) {
                if ( Pattern.compile ( "^[0-9]{1,2}$" ).matcher ( txtNoOfPassengers.getText ( ) ).matches ( ) ){
                    Vehicle vehicle=new Vehicle (
                            txtVehicleNumber.getText ( ) ,
                            (String) cmbVehicleType.getValue ( ) ,
                            txtMaximumWeight.getText ( ) ,
                            Integer.parseInt ( txtNoOfPassengers.getText ( ) )
                    );
                try {
                    if ( VehicleController.getInstance ( ).save ( vehicle ) ) {
                        Alert alert=new Alert ( Alert.AlertType.INFORMATION , "Vehicle is Saved" );
                        Stage stage=(Stage) btnSaveVehicle.getScene ( ).getWindow ( );
                        stage.close ( );
                        alert.show ( );
                    }
                } catch ( Exception e ) {
                    e.printStackTrace ( );
                }

            }else {
                    txtNoOfPassengers.setFocusColor ( Paint.valueOf ( "red" ) );
                    txtNoOfPassengers.requestFocus ();
                }

            }else {
                txtMaximumWeight.setFocusColor ( Paint.valueOf ( "red" ) );
                txtMaximumWeight.requestFocus ();
            }
        }else {
            txtVehicleNumber.setFocusColor ( Paint.valueOf ( "red" ) );
            txtVehicleNumber.requestFocus ();
        }
    }
}
