package lk.ijse.vehiclepark.view.tm;

public class VehicleTM {
    private String vehicleNumber;
    private String vehicleType;
    private String maximumWeight;
    private int noOfPassengers;

    public VehicleTM ( ) {
    }

    public VehicleTM ( String vehicleNumber , String maximumWeight , String vehicleType , int noOfPassengers ) {
        this.vehicleNumber = vehicleNumber;
        this.maximumWeight = maximumWeight;
        this.vehicleType = vehicleType;
        this.noOfPassengers = noOfPassengers;
    }

    public String getVehicleNumber ( ) {
        return vehicleNumber;
    }

    public void setVehicleNumber ( String vehicleNumber ) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getMaximumWeight ( ) {
        return maximumWeight;
    }

    public void setMaximumWeight ( String maximumWeight ) {
        this.maximumWeight = maximumWeight;
    }

    public String getVehicleType ( ) {
        return vehicleType;
    }

    public void setVehicleType ( String vehicleType ) {
        this.vehicleType = vehicleType;
    }

    public int getNoOfPassengers ( ) {
        return noOfPassengers;
    }

    public void setNoOfPassengers ( int noOfPassengers ) {
        this.noOfPassengers = noOfPassengers;
    }

    @Override
    public String toString ( ) {
        return "VehicleTM{" +
               "vehicleNumber='" + vehicleNumber + '\'' +
               ", maximumWeight='" + maximumWeight + '\'' +
               ", vehicleType='" + vehicleType + '\'' +
               ", noOfPassengers=" + noOfPassengers +
               '}';
    }
}
