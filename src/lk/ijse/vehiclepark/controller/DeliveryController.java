package lk.ijse.vehiclepark.controller;

import lk.ijse.vehiclepark.dao.CrudDAO;
import lk.ijse.vehiclepark.model.Delivery;

import java.util.ArrayList;
import java.util.List;

public class DeliveryController implements CrudDAO< Delivery,String > {

    ArrayList< Delivery > deliveryArrayList=new ArrayList<> ();

    private static DeliveryController deliveryController;

    private DeliveryController(){

    }

    public static DeliveryController getInstance(){
        if ( deliveryController== null){
            deliveryController=new DeliveryController ();
            return deliveryController;
        }
        return deliveryController;
    }

    @Override
    public boolean save ( Delivery delivery ) {
        boolean add = deliveryArrayList.add ( delivery );
        return add;
    }

    @Override
    public boolean delete ( String vehicleNumber ) {
        Delivery delivery = get ( vehicleNumber );
        if ( delivery!=null ){
            deliveryArrayList.remove ( delivery );
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean update ( Delivery delivery ) {
        return false;
    }

    @Override
    public List< Delivery > getAll ( ) {
        return deliveryArrayList;
    }

    @Override
    public Delivery get ( String vehicleNumber ) {
        for ( int i = 0; i < deliveryArrayList.size (); i++ ) {
            Delivery delivery = deliveryArrayList.get ( i );
            if ( delivery.getVehicleNumber ( ).equals ( vehicleNumber ) ){
                return deliveryArrayList.get ( i );
            }
        }
        return null;
    }

    @Override
    public List< Delivery > loadAll ( ) {
        return null;
    }
}
