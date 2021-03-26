package pojo;

import com.google.gson.Gson;

import java.util.Map;

public class UserPOJO {
    private int id;
    private String name;
    private String dob;
    private HomeAddressPOJO addressDetails;

    public HomeAddressPOJO getAddressDetails() {
        return addressDetails;
    }

    public void setAddressDetails(HomeAddressPOJO addressDetails) {
        this.addressDetails = addressDetails;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getUserPayload(Map<String, String> testData) {

        //Office Address
        OfficeAddressPOJO officeAddress = new OfficeAddressPOJO();


        officeAddress.setBuildingNumber(Integer.parseInt(testData.get("buildingNumber")));
        officeAddress.setAddressLine1(testData.get("OfficeAddress1"));
        officeAddress.setAddressLine2(testData.get("OfficeAddress2"));
        officeAddress.setLandMark(testData.get("landMark"));
        officeAddress.setCardId(testData.get("cardId"));
        officeAddress.setPin(Integer.parseInt(testData.get("pin")));

        //Home Address
        HomeAddressPOJO home = new HomeAddressPOJO();

        home.setHouseNumber(Integer.parseInt(testData.get("houseNumber")));
        home.setAadharNumber(Integer.parseInt(testData.get("aadharNumber")));
        home.setAddressLine1(testData.get("OfficeAddressLine1"));
        home.setAddressLine2(testData.get("OfficeAddressLine2"));
        home.setLandmark(testData.get("landmark"));
        home.setPin(Integer.parseInt(testData.get("homePinNumber")));
        home.setOfficeAddress(officeAddress);

        UserPOJO user = new UserPOJO();
        user.setId(Integer.parseInt(testData.get("id")));
        user.setName(testData.get("Name"));
        user.setDob(testData.get("DateOfBirth"));
        user.setAddressDetails(home);

        Gson gson = new Gson();
        return gson.toJson(user);

    }

    public String updateUserPayload(Map<String, String> testData) {
        UserPOJO user = new UserPOJO();
        user.setName(testData.get("Name"));
        user.setDob(testData.get("DateOfBirth"));
        Gson details = new Gson();
        String payload = details.toJson(user);
        return payload;
    }
}
