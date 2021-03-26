package utils;

public class URLGenerator {
    public String getUsers = "/users";
    public String addUsers = "/users";
    public String updateUsers = "/user/";
    public String deleteUsers = "/users";

    public URLGenerator(String baseURL) {
        getUsers = baseURL + getUsers;
        addUsers = baseURL + addUsers;
        updateUsers = baseURL + updateUsers;
        deleteUsers = baseURL + deleteUsers;
    }
}
