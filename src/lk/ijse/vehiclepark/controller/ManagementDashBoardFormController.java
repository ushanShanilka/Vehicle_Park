package lk.ijse.vehiclepark.controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import lk.ijse.vehiclepark.model.Delivery;
import lk.ijse.vehiclepark.model.Driver;
import lk.ijse.vehiclepark.model.Parking;
import lk.ijse.vehiclepark.model.Vehicle;
import lk.ijse.vehiclepark.view.tm.DeliveryTM;
import lk.ijse.vehiclepark.view.tm.DriverTM;
import lk.ijse.vehiclepark.view.tm.ParkingTM;
import lk.ijse.vehiclepark.view.tm.VehicleTM;

import java.io.IOException;
import java.util.List;


public class ManagementDashBoardFormController {
    public AnchorPane tblRoot;


    public JFXButton btnAddVehicle;
    public ComboBox cmbStatus;
    public JFXButton btnAddDriver;
    public JFXButton btnLogOut;
    public TableView tblVehicle;
    public TableView tblInParkingVehicle;
    public TableView tblOnDelivery;
    public TableView<DriverTM> tblDriver;
    public TableColumn colDriverName;
    public TableColumn colDriverNic;
    public TableColumn colDriverLiNo;
    public TableColumn colDriverAddress;
    public TableColumn colDriverContactNo;
    public TableColumn colInParkingVehicleNumber;
    public TableColumn colInParkingVehicleType;
    public TableColumn colInParkingVehicleSlot;
    public TableColumn colInParkingVehicleParkedTime;
    public TableColumn colOnDeliveryVehicleNumber;
    public TableColumn colOnDeliveryVehicleType;
    public TableColumn colOnDeliveryDriverName;
    public TableColumn colLeftTime;
    public TableColumn colVehicleNumber;
    public TableColumn colNoOfPassenger;
    public TableColumn colMaximumWeight;
    public TableColumn colVehicleType;


    public void initialize ( )  {
        colDriverName.setCellValueFactory ( new PropertyValueFactory<> ( "driverName" ) );
        colDriverNic.setCellValueFactory ( new PropertyValueFactory<> ( "nic" ) );
        colDriverLiNo.setCellValueFactory ( new PropertyValueFactory<> ( "drivingLicenseNo" ) );
        colDriverAddress.setCellValueFactory ( new PropertyValueFactory<> ( "address" ) );
        colDriverContactNo.setCellValueFactory ( new PropertyValueFactory<> ( "contactNo" ) );


        colVehicleNumber.setCellValueFactory ( new PropertyValueFactory<> ( "vehicleNumber" ) );
        colVehicleType.setCellValueFactory ( new PropertyValueFactory<> ( "vehicleType" ) );
        colNoOfPassenger.setCellValueFactory ( new PropertyValueFactory<> ( "noOfPassengers" ) );
        colMaximumWeight.setCellValueFactory ( new PropertyValueFactory<> ( "maximumWeight" ) );


        colInParkingVehicleNumber.setCellValueFactory ( new PropertyValueFactory<> ( "vehicleNumber" ) );
        colInParkingVehicleType.setCellValueFactory ( new PropertyValueFactory<> ( "vehicleType" ) );
        colInParkingVehicleSlot.setCellValueFactory ( new PropertyValueFactory<> ( "ParkingSlot" ) );
        colInParkingVehicleParkedTime.setCellValueFactory ( new PropertyValueFactory<> ( "date" ) );


        colOnDeliveryVehicleNumber.setCellValueFactory ( new PropertyValueFactory<> ( "vehicleNumber" ) );
        colOnDeliveryVehicleType.setCellValueFactory ( new PropertyValueFactory<> ( "vehicleType" ) );
        colOnDeliveryDriverName.setCellValueFactory ( new PropertyValueFactory<> ( "driverName" ) );
        colLeftTime.setCellValueFactory ( new PropertyValueFactory<> ( "leftTime" ) );

        loadAllParkingVehicle();
        loadAllVehicles ();
        loadAllDrivers ();
        loadAllDeliveryVehicle();

        ObservableList<Object> observableArrayList = FXCollections.observableArrayList();
        observableArrayList.add("In Parking");
        observableArrayList.add("On Delivery");
        observableArrayList.add("Vehicle");
        observableArrayList.add("Driver");
        cmbStatus.setItems(observableArrayList);
    }

    public void addVehicleOnAction ( ActionEvent actionEvent ) {
        tblVehicle.setVisible ( true );
        tblOnDelivery.setVisible ( false );
        tblInParkingVehicle.setVisible ( false );
        tblOnDelivery.setVisible ( false );
        tblDriver.setVisible ( false );

        try {
            Scene scene = new Scene ( FXMLLoader.load ( getClass ( ).getResource ( "../view/AddVehicleForm.fxml" ) ) );

            Stage primaryStage = new Stage ( );
            primaryStage.setScene ( scene );
            primaryStage.show ( );

        } catch ( IOException e ) {
            e.printStackTrace ( );
        }
    }

    public void addDriverOnAction ( ActionEvent actionEvent ){
        try {
            tblVehicle.setVisible ( false );
            tblOnDelivery.setVisible ( false );
            tblInParkingVehicle.setVisible ( false );
            tblOnDelivery.setVisible ( false );
            tblDriver.setVisible ( true );


            Scene scene = new Scene ( FXMLLoader.load ( getClass ( ).getResource ( "../view/AddDriverForm.fxml" ) ) );

            Stage primaryStage = new Stage ( );
            primaryStage.setScene ( scene );
            primaryStage.show ( );
        } catch ( IOException e ){
            e.printStackTrace ( );
        }
    }

    public void logOutOnAction ( ActionEvent actionEvent ) {
        Stage stage = (Stage) btnLogOut.getScene().getWindow();
        stage.close();
    }

    public void cmbManagementDash ( ActionEvent actionEvent ) {
        Object value = cmbStatus.getValue ( );
        if ( value=="In Parking" ){
            tblVehicle.setVisible ( false );
            tblOnDelivery.setVisible ( false );
            tblInParkingVehicle.setVisible ( true );
            tblOnDelivery.setVisible ( false );
            tblDriver.setVisible ( false );
        }else if ( value=="On Delivery" ){
            tblVehicle.setVisible ( false );
            tblOnDelivery.setVisible ( false );
            tblInParkingVehicle.setVisible ( false );
            tblOnDelivery.setVisible ( true );
            tblDriver.setVisible ( false );
        }else if ( value=="Vehicle" ){
            tblVehicle.setVisible ( true );
            tblOnDelivery.setVisible ( false );
            tblInParkingVehicle.setVisible ( false );
            tblOnDelivery.setVisible ( false );
            tblDriver.setVisible ( false );
        }else if ( value=="Driver" ){
            tblVehicle.setVisible ( false );
            tblOnDelivery.setVisible ( false );
            tblInParkingVehicle.setVisible ( false );
            tblOnDelivery.setVisible ( false );
            tblDriver.setVisible ( true );
        }

    }

    public void loadAllDrivers(){
        tblVehicle.refresh ();
        List< Driver > drivers = DriverController.getInstance ( ).getAll ( );

        ObservableList<DriverTM> driverTMS = FXCollections.observableArrayList ( );

        for (Driver driver: drivers) {
            driverTMS.add ( new DriverTM ( driver.getDriverName (),driver.getNic (),driver.getDrivingLicenseNo (),driver.getAddress (),driver.getContactNo () ) );
        }
        tblDriver.setItems ( driverTMS );
    }

    public void loadAllVehicles()  {
        tblVehicle.refresh ();
        try {
            List< Vehicle > vehicleArrayList = VehicleController.getInstance ().getAll ( );

            ObservableList< VehicleTM > vehicleTMS = FXCollections.observableArrayList ( );

            for ( Vehicle vehicle : vehicleArrayList ) {
                vehicleTMS.add ( new VehicleTM ( vehicle.getVehicleNumber ( ) , vehicle.getMaximumWeight ( ) , vehicle.getVehicleType ( ) , vehicle.getNoOfPassengers ( ) ) );
            }
            tblVehicle.setItems ( vehicleTMS );
        } catch (Exception e) {
            e.printStackTrace ( );
        }
    }

    public void loadAllParkingVehicle(){
        try {
            List< Parking > all = ParkingController.getInstance ( ).getAll ( );

            ObservableList< ParkingTM > parkingTMS = FXCollections.observableArrayList ( );

            for (Parking parking:all) {
                parkingTMS.add ( new ParkingTM ( parking.getVehicleNumber (),parking.getVehicleType (),parking.getParkingSlot (),parking.getDate () ) );
            }
            tblInParkingVehicle.setItems ( parkingTMS );
        } catch (Exception e) {
            e.printStackTrace ( );
        }
    }

    public void loadAllDeliveryVehicle(){
        List< Delivery > all = DeliveryController.getInstance ( ).getAll ( );

        ObservableList< DeliveryTM > deliveryTMS = FXCollections.observableArrayList ( );

        for ( Delivery delivery : all) {
            deliveryTMS.add ( new DeliveryTM ( delivery.getVehicleNumber (),delivery.getVehicleType (),delivery.getDriverName (),delivery.getLeftTime () ) );
        }
        tblOnDelivery.setItems ( deliveryTMS );
    }



}

