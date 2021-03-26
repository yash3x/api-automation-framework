package test;

import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojo.UserPOJO;
import utils.RestUtils;

import java.util.HashMap;
import java.util.Map;

public class TestGetRequest {
    @Test
    public void getUsers() {
        RestUtils restUtils = new RestUtils();
        String url = "http://localhost:8081/users";
        Response response = restUtils.get(url);
        response.prettyPrint();
    }

    @Test
    public void getUsersWithParams() {
        RestUtils restUtils = new RestUtils();
        String url = "http://localhost:8081/users";
        String key = "data";
        int id = 1;
        Map<String, Integer> map = new HashMap<String, Integer>();
        map.put(key, id);
        Response response = restUtils.getWithParams(url, map);
        response.prettyPrint();
    }

    @Test
    public void addUsers() {
        RestUtils restUtils = new RestUtils();
        String url = "http://localhost:8081/users";
        UserPOJO users = new UserPOJO();
        Map<String, String> testData = new HashMap<String, String>();
        //Office
        testData.put("buildingNumber", "1");
        testData.put("OfficeAddress1", "Office Main Road 1");
        testData.put("OfficeAddress2", "Office Main Road 2");
        testData.put("landMark", "Opposite to something");
        testData.put("cardId", "Employee-001");
        testData.put("pin", "8989");

        //Home
        testData.put("houseNumber", "1");
        testData.put("aadharNumber", "1001");
        testData.put("OfficeAddressLine1", "Office 1");
        testData.put("OfficeAddressLine2", "Office 2");
        testData.put("landmark", "Some Landmark");
        testData.put("homePinNumber", "4356");

        //User
        testData.put("id", "103");
        testData.put("Name", "Max");
        testData.put("DateOfBirth", "21-02-1989");

        String payLoad = users.getUserPayload(testData);
        Response response = restUtils.post(url, payLoad);
        response.prettyPrint();
    }

    @Test
    public void updateUsers() {
        RestUtils restUtils = new RestUtils();
        String url = "http://localhost:8081/user/6";
        UserPOJO users = new UserPOJO();
        Map<String, String> testData = new HashMap<String, String>();

        //User
        testData.put("Name", "YashMax");
        testData.put("DateOfBirth", "23-02-1989");

        String payLoad = users.updateUserPayload(testData);
        Response response = restUtils.put(url, payLoad);
        response.prettyPrint();
    }

    @Test
    public void deleteUsers() {
        RestUtils restUtils = new RestUtils();
        String url = "http://localhost:8081/users";
        UserPOJO users = new UserPOJO();

        Map<String, Integer> testdata = new HashMap<String, Integer>();
        testdata.put("data", 9);

        Response response = restUtils.delete(url, testdata);
        response.prettyPrint();
    }
}
