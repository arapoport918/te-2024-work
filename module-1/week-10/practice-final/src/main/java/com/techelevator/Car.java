package com.techelevator;

public class Car {

    public static final String COMPACT = "compact";
    public static final String MIDSIZE = "midsize";
    public static final String FULLSIZE = "fullsize";

    private String type;
    private String license;

    public Car(String type, String license) {
        this.type = type;
        this.license = license;
    }

    public boolean park(Car c) throws ParkingLotException {
        if (c == null) {
            // throw a new ParkingLotException
            throw new ParkingLotException();
        }

        return true;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    @Override
    public String toString() {
        return "Car{" +
                "type='" + type + '\'' +
                ", license='" + license + '\'' +
                '}';
    }
}
