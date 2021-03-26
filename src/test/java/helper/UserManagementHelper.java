package helper;

import io.restassured.response.Response;
import utils.RestUtils;
import utils.URLGenerator;

import java.util.Map;

public class UserManagementHelper {
    String baseURL;
    RestUtils utils;
    URLGenerator url;

    public UserManagementHelper(String baseURL) {
        this.baseURL = baseURL;
        utils = new RestUtils();
        url = new URLGenerator(baseURL);
    }

    public Response getSpecificUserDetails(Map<String, String> testData) throws Exception {
        Response response;
        int id = Integer.parseInt(testData.get("userId"));
        try {
            response = utils.get(url.getUsers + "/" + id); //http://localhost:8081/users/6
            if (response.getStatusCode() != 200) {
                throw new Exception("Failed to get the user details with id " + id + "and using API " + url.getUsers + "/" + id + " and the response body is " + response.getBody().asString());
            }
        } catch (Exception e) {
            throw new Exception(e.getMessage());
        }
        return response;
    }
}
