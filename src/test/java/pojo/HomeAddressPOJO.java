package pojo;

public class HomeAddressPOJO {
    private int houseNumber;
    private int aadharNumber;
    private String addressLine1;
    private String addressLine2;
    private String landmark;
    private int pin;
    private String addressDetails;
    private OfficeAddressPOJO officeAddress;

    public OfficeAddressPOJO getOfficeAddress() {
        return officeAddress;
    }

    public void setOfficeAddress(OfficeAddressPOJO officeAddress) {
        this.officeAddress = officeAddress;
    }

    public String getAddressDetails() {
        return addressDetails;
    }

    public void setAddressDetails(String addressDetails) {
        this.addressDetails = addressDetails;
    }

    public int getHouseNumber() {
        return houseNumber;
    }

    public void setHouseNumber(int houseNumber) {
        this.houseNumber = houseNumber;
    }

    public int getAadharNumber() {
        return aadharNumber;
    }

    public void setAadharNumber(int aadharNumber) {
        this.aadharNumber = aadharNumber;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String getLandmark() {
        return landmark;
    }

    public void setLandmark(String landmark) {
        this.landmark = landmark;
    }

    public int getPin() {
        return pin;
    }

    public void setPin(int pin) {
        this.pin = pin;
    }

}
