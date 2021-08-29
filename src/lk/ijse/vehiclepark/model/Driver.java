package lk.ijse.vehiclepark.model;

public class Driver {
    private String driverName;
    private String nic;
    private String drivingLicenseNo;
    private String address;
    private String contactNo;

    public Driver ( ) {
    }

    public Driver ( String driverName , String nic , String drivingLicenseNo , String address , String contactNo ) {
        this.driverName = driverName;
        this.nic = nic;
        this.drivingLicenseNo = drivingLicenseNo;
        this.address = address;
        this.contactNo = contactNo;
    }

    public String getDriverName ( ) {
        return driverName;
    }

    public void setDriverName ( String driverName ) {
        this.driverName = driverName;
    }

    public String getNic ( ) {
        return nic;
    }

    public void setNic ( String nic ) {
        this.nic = nic;
    }

    public String getDrivingLicenseNo ( ) {
        return drivingLicenseNo;
    }

    public void setDrivingLicenseNo ( String drivingLicenseNo ) {
        this.drivingLicenseNo = drivingLicenseNo;
    }

    public String getAddress ( ) {
        return address;
    }

    public void setAddress ( String address ) {
        this.address = address;
    }

    public String getContactNo ( ) {
        return contactNo;
    }

    public void setContactNo ( String contactNo ) {
        this.contactNo = contactNo;
    }

    @Override
    public String toString ( ) {
        return "Driver{" +
               "driverName='" + driverName + '\'' +
               ", nic='" + nic + '\'' +
               ", drivingLicenseNo='" + drivingLicenseNo + '\'' +
               ", address='" + address + '\'' +
               ", contactNo='" + contactNo + '\'' +
               '}';
    }
}
