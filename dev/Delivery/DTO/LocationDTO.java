package Delivery.DTO;

import Delivery.BusinessLayer.Location;

import java.lang.invoke.LambdaConversionException;

public class LocationDTO {
    private String address;
    private String phoneNumber;
    private String contactName;

    public LocationDTO(String address, String phoneNumber, String contactName){
        this.address = address;
        this.contactName = contactName;
        this.phoneNumber = phoneNumber;
    }

    public LocationDTO(Location location){
        this.address = location.getAddress();
        this.phoneNumber = location.getPhoneNumber();
        this.contactName = location.getContactName();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    @Override
    public String toString() {
        return  address + " " +
                 phoneNumber + " " +
                 contactName;
    }
}
