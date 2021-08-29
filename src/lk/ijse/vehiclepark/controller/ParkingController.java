package lk.ijse.vehiclepark.controller;

import lk.ijse.vehiclepark.dao.CrudDAO;
import lk.ijse.vehiclepark.model.Parking;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ParkingController implements CrudDAO< Parking,String > {

    ArrayList< Parking > parkingArrayList=new ArrayList<> (13);

    ArrayList< Parking > vanParkingSlots=new ArrayList<> (5);

    private static ParkingController  parkingController;

    private ParkingController() throws Exception {
        getAll ();
    }

    public static ParkingController getInstance() throws Exception {
        if ( parkingController==null){
            parkingController = new ParkingController ();
            return parkingController;
        }
        return parkingController;
    }

    @Override
    public boolean save ( Parking parking ) {
        parkingArrayList.add ( parking );
        return true;
    }

    @Override
    public boolean delete ( String vehicleNumber ) {
        Parking parking = get ( vehicleNumber  );
        if ( parking!=null ){
            parkingArrayList.remove ( parking );
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean update ( Parking parking ) {
        return false;
    }

    @Override
    public List< Parking > getAll ( ) {
        return parkingArrayList;
    }

    @Override
    public Parking get ( String vehicleNumber ) {
        for ( int i = 0; i < parkingArrayList.size (); i++ ) {
            Parking parking = parkingArrayList.get ( i );
            if ( parking.getVehicleNumber ( ).equals ( vehicleNumber ) ){
                return parkingArrayList.get ( i );
            }
        }
        return null;
    }

    @Override
    public List< Parking > loadAll ( ) {
        return null;
    }

    public String vanSlot() throws Exception {
        ArrayList< Integer > vanSlot = new ArrayList<> ( );

        vanSlot.add ( 1 );
        vanSlot.add ( 2 );
        vanSlot.add ( 3 );
        vanSlot.add ( 4 );
        vanSlot.add ( 12 );
        vanSlot.add ( 13 );

        ArrayList< Integer > parkVan = new ArrayList<> ( );

        List< Parking > all = getInstance ( ).getAll ( );

        for ( Parking parking:all) {
            if ( parking.getVehicleType ().equals ( "Van" ) ){
                parkVan.add ( Integer.valueOf ( parking.getParkingSlot () ) );
            }
        }

        for ( int i:parkVan ){
            int x=0;
            for (int z:vanSlot ){
                if ( z==i ){
                    vanSlot.remove ( x );
                    break;
                }
                x++;
            }
        }

        Collections.sort ( vanSlot );

        return String.valueOf ( vanSlot.get ( 0 ) );
    }

    public String cargoSlot() throws Exception {
        ArrayList< Integer > cargoSlot = new ArrayList<> ( );

        cargoSlot.add ( 5 );
        cargoSlot.add ( 6 );
        cargoSlot.add ( 7 );
        cargoSlot.add ( 8 );
        cargoSlot.add ( 9 );
        cargoSlot.add ( 10 );
        cargoSlot.add ( 11 );

        ArrayList< Integer > parkCargo=new ArrayList<> ( );

        List< Parking > all=getInstance ( ).getAll ( );

        for ( Parking parking : all) {
            if ( parking.getVehicleType ().equals ( "Cargo Lorry" ) ){
                parkCargo.add ( Integer.valueOf ( parking.getParkingSlot () ) );
            }
        }

        for ( int i:parkCargo ){
            int x=0;
            for (int z:cargoSlot ){
                if ( z==i ){
                    cargoSlot.remove ( x );
                    break;
                }
                x++;
            }
        }

        Collections.sort ( cargoSlot );

        return String.valueOf ( cargoSlot.get ( 0 ) );
    }

}
