package lk.ijse.vehiclepark.model;

public class Vehicle{
    private String vehicleNumber;
    private String vehicleType;
    private String maximumWeight;
    private int noOfPassengers;

    public Vehicle ( ) {
    }

    public Vehicle ( String vehicleNumber , String vehicleType , String maximumWeight , int noOfPassengers ) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.maximumWeight = maximumWeight;
        this.noOfPassengers = noOfPassengers;
    }

    public String getVehicleNumber ( ) {
        return vehicleNumber;
    }

    public void setVehicleNumber ( String vehicleNumber ) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getVehicleType ( ) {
        return vehicleType;
    }

    public void setVehicleType ( String vehicleType ) {
        this.vehicleType = vehicleType;
    }

    public String getMaximumWeight ( ) {
        return maximumWeight;
    }

    public void setMaximumWeight ( String maximumWeight ) {
        this.maximumWeight = maximumWeight;
    }

    public int getNoOfPassengers ( ) {
        return noOfPassengers;
    }

    public void setNoOfPassengers ( int noOfPassengers ) {
        this.noOfPassengers = noOfPassengers;
    }

    @Override
    public String toString ( ) {
        return "Vehicle{" +
               "vehicleNumber='" + vehicleNumber + '\'' +
               ", vehicleType='" + vehicleType + '\'' +
               ", maximumWeight='" + maximumWeight + '\'' +
               ", noOfPassengers=" + noOfPassengers +
               '}';
    }
}
