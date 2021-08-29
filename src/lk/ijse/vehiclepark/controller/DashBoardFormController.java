package lk.ijse.vehiclepark.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.util.Duration;
import lk.ijse.vehiclepark.model.Delivery;
import lk.ijse.vehiclepark.model.Driver;
import lk.ijse.vehiclepark.model.Parking;
import lk.ijse.vehiclepark.model.Vehicle;

import java.awt.print.Pageable;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

public class DashBoardFormController {
    public Label lblDate;
    public Label lblTime;
    public JFXButton btnParkVehicle;
    public JFXButton btnOnDeliveryShift;
    public JFXButton btnManagementLogin;
    public AnchorPane root;
    public JFXComboBox<Object> cmbSelectVehicleType;
    public JFXTextField txtVehicleType;
    public JFXComboBox cmbSelectDriver;
    public Label lblSlotNumber;
    public JFXComboBox cmbSelectVehicleNumber;


    public void initialize()  {
        generateDateTime ();
        getAllVehicle();
        getAllDrives();
    }

    public void getAllVehicle() {
        cmbSelectDriver.setItems (null);
        try {
            List< Vehicle > all = VehicleController.getInstance ().getAll ( );

            ObservableList<String> observableList = FXCollections.observableArrayList ( );

        for (Vehicle vehicle:all ) {
            observableList.add ( vehicle.getVehicleNumber () ) ;
        }
        cmbSelectVehicleNumber.setItems (observableList);
        } catch (Exception e) {
            e.printStackTrace ( );
        }
    }

    public void getAllDrives(){
        try {
            List< Driver > all = DriverController.getInstance ( ).getAll ( );

            ObservableList< String > observableList = FXCollections.observableArrayList ( );

            for (Driver driver : all) {
                observableList.add ( driver.getDriverName ( ) );
            }
            cmbSelectDriver.setItems ( observableList );
        } catch (Exception e) {
            e.printStackTrace ( );
        }
    }

    public void generateDateTime() {
        lblDate.setText( LocalDate.now().toString());

        Timeline timeline = new Timeline( new KeyFrame ( Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern( "hh:mm:ss a");
            lblTime.setText( LocalDateTime.now().format( formatter));
        }), new KeyFrame(Duration.seconds(1)));
        timeline.setCycleCount( Animation.INDEFINITE);
        timeline.play();
    }

    public void parkVehicleOnAction ( ActionEvent actionEvent ) {
        try {
            SimpleDateFormat formatter=new SimpleDateFormat ( "dd/MM/yyyy HH:mm" );
            Date date=new Date ( );

            DeliveryController deliveryController=DeliveryController.getInstance ( );
            Delivery delivery=deliveryController.get ( (String) cmbSelectVehicleNumber.getValue ( ) );
            if ( delivery != null ) {
                deliveryController.delete ( delivery.getVehicleNumber ( ) );
            }
            else {
                if ( ( cmbSelectVehicleNumber.getValue () )!=null ){
                Parking parking=new Parking (
                        (String) cmbSelectVehicleNumber.getValue ( ) ,
                        txtVehicleType.getText ( ) ,
                        lblSlotNumber.getText ( ) ,
                        formatter.format ( date )
                );


                if ( ParkingController.getInstance ( ).save ( parking ) ) {
                    Alert alert=new Alert ( Alert.AlertType.INFORMATION , "Vehicle is Park" );
                    alert.show ( );
                    clearText ( );
                }
                }else {
                    cmbSelectVehicleNumber.setFocusColor ( Paint.valueOf ( "red" ) );
                    cmbSelectVehicleNumber.requestFocus ();
                }
            }

        } catch ( Exception e ) {
            e.printStackTrace ( );
        }
    }

    public void onDeliveryShiftOnAction ( ActionEvent actionEvent ){
        try {
            boolean delete = ParkingController.getInstance ( ).delete ((String) cmbSelectVehicleNumber.getValue () );
            if ( delete ){
                SimpleDateFormat formatter = new SimpleDateFormat( "dd/MM/yyyy HH:mm");
                Date date = new Date();

                if ( cmbSelectVehicleNumber.getValue ( ) != null ) {
                    if ( cmbSelectDriver.getValue ( ) != null ) {
                        Delivery delivery = new Delivery (
                                (String) cmbSelectVehicleNumber.getValue ( ) ,
                                txtVehicleType.getText ( ) ,
                                (String) cmbSelectDriver.getValue ( ) ,
                                formatter.format ( date )
                        );
                        try {
                            if ( DeliveryController.getInstance ( ).save ( delivery ) ) {
                                Alert alert = new Alert ( Alert.AlertType.INFORMATION , "Its Deliver" );
                                alert.show ( );
                            }
                        } catch ( Exception e ) {
                            e.printStackTrace ( );
                        }
                    }
                    else {
                        cmbSelectDriver.setFocusColor ( Paint.valueOf ( "red" ) );
                        cmbSelectDriver.requestFocus ( );
                    }
                }
                else {
                    cmbSelectVehicleNumber.setFocusColor ( Paint.valueOf ( "red" ) );
                    cmbSelectVehicleNumber.requestFocus ( );
                }
            }
        } catch ( Exception e ) {
            e.printStackTrace ( );
        }
        clearText();
    }

    public void managementLoginOnAction ( ActionEvent actionEvent ){
        Scene scene = null;
        try {
            scene = new Scene ( FXMLLoader.load( getClass().getResource( "../view/LoginForm.fxml")));
        } catch (IOException e) {
            e.printStackTrace ( );
        }
        Stage primaryStage = new Stage();
        primaryStage.setScene(scene);
        primaryStage.show ();
    }

    public void cmbSelectVehicleNumberOnAction ( ActionEvent actionEvent )  {
        try {
            List< Vehicle > all = VehicleController.getInstance ( ).getAll ( );

            for ( Vehicle vehicle : all ) {
                try {
                    if ( cmbSelectVehicleNumber.getValue ( ).equals ( vehicle.getVehicleNumber ( ) ) ) {
                        txtVehicleType.setText ( vehicle.getVehicleType ( ) );

                        switch (txtVehicleType.getText ( )) {
                            case "Bus":
                                lblSlotNumber.setText ( "14" );
                                break;
                            case "Van":
                                String s = ParkingController.getInstance ( ).vanSlot ( );
                                lblSlotNumber.setText ( s );
                                break;
                            case "Cargo Lorry":
                                String s1=ParkingController.getInstance ( ).cargoSlot ( );
                                lblSlotNumber.setText ( s1 );
                                break;
                        }
                    }
                    Parking parking = ParkingController.getInstance ( ).get ( (String) cmbSelectVehicleNumber.getValue ( ) );
                    if ( parking != null ) {
                        btnParkVehicle.setDisable ( true );
                    }
                    else {
                        btnParkVehicle.setDisable ( false );
                    }
                    Delivery delivery = DeliveryController.getInstance ( ).get ( (String) cmbSelectVehicleNumber.getValue ( ) );
                    btnOnDeliveryShift.setDisable ( delivery != null );
                } catch ( NullPointerException ignored ) {

                }
            }
        } catch ( Exception e ) {
            e.printStackTrace ( );
        }
    }

    public void cmbSelectDriver ( ActionEvent actionEvent ) {
        try {
            List< Parking > all = ParkingController.getInstance ( ).getAll ( );

            ObservableList< String > observableList = FXCollections.observableArrayList ( );

            for ( Parking parking : all) {
                observableList.add ( parking.getVehicleType () );
            }
        } catch ( Exception e ) {
            e.printStackTrace ( );
        }
    }

    public void btnRefreshOnAction ( ActionEvent actionEvent ) {
        initialize ();
        clearText ();
        lblSlotNumber.setText ( null );
    }

    private void clearText(){
        cmbSelectVehicleNumber.setValue ( null );
        txtVehicleType.setText ( "" );
        cmbSelectDriver.setValue ( null );
        btnOnDeliveryShift.setDisable ( false );
        btnParkVehicle.setDisable ( false );
    }
}
