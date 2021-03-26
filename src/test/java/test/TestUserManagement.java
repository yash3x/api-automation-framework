package test;

import helper.GenericHelper;
import helper.UserManagementHelper;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class TestUserManagement {
    GenericHelper helper;
    Properties property;
    String baseURL;
    UserManagementHelper users;

    @BeforeClass
    public void setUp() throws IOException {
        helper = new GenericHelper();
        property = helper.loadProperty("Staging");
        baseURL = property.getProperty("baseURL");
        users = new UserManagementHelper(baseURL);
    }

    @Test
    public void getUserDetails() throws Exception {
        Response response;

        Map<String, String> testData = new HashMap<String, String>();
        testData = helper.readJsonfile("getSpecificUserDetails", "userManagementData1", "UserManagementTestData");

        response = users.getSpecificUserDetails(testData);
        response.prettyPrint();
        int statusCode = response.getStatusCode();
        String dob = JsonPath.from(response.getBody().asString()).get("dob");
        String name = JsonPath.from(response.getBody().asString()).get("name");
        String address = JsonPath.from(response.getBody().asString()).get("addressDetails.officeAddress.addressLine2");

        assertThat((new Object[]{Integer.parseInt(testData.get("ExpectedStatusCode")),
                        testData.get("ExpectedDateOfBirth"),
                        testData.get("ExpectedName"),
                        testData.get("ExpectedOfficeAddressLine2")}),
                is(new Object[]{statusCode, dob, name, address}));
    }
}
