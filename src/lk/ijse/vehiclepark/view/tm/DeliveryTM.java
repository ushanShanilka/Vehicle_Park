package lk.ijse.vehiclepark.view.tm;

public class DeliveryTM {
    private String vehicleNumber;
    private String vehicleType;
    private String driverName;
    private String leftTime;

    public DeliveryTM ( ) {
    }

    public DeliveryTM ( String vehicleNumber , String vehicleType , String driverName , String leftTime ) {
        this.vehicleNumber = vehicleNumber;
        this.vehicleType = vehicleType;
        this.driverName = driverName;
        this.leftTime = leftTime;
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

    public String getDriverName ( ) {
        return driverName;
    }

    public void setDriverName ( String driverName ) {
        this.driverName = driverName;
    }

    public String getLeftTime ( ) {
        return leftTime;
    }

    public void setLeftTime ( String leftTime ) {
        this.leftTime = leftTime;
    }

    @Override
    public String toString ( ) {
        return "DeliveryTM{" +
               "vehicleNumber='" + vehicleNumber + '\'' +
               ", vehicleType='" + vehicleType + '\'' +
               ", driverName='" + driverName + '\'' +
               ", leftTime='" + leftTime + '\'' +
               '}';
    }
}
