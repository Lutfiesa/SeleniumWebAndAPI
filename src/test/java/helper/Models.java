package helper;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.json.JSONObject;

import static helper.Utility.generateRandomEmail;

public class Models {

    private static RequestSpecification request;

    public static void setupHeaders() {
        request = RestAssured.given()
                .header("Content-Type", "application/json")
                .header("Accept", "application/json")
                .header("Authorization", "Bearer 6857341e2de7eb72d9faddaf2e2e7ed52235838aa88349882e48bc466877e55c");
    }

    public static Response getListUsers(String endpoint) {
        setupHeaders();
        return request.when().get(endpoint);
    }

    public static Response deleteUser(String endpoint, String user_id) {
        setupHeaders();
        String finalEndpoint = endpoint + "/" + user_id;
        return request.when().delete(finalEndpoint);
    }

    public static Response updateUser(String endpoint, String user_id) {
        String name = "Lutfi Esa P";
        String status = "inactive";
        String email = generateRandomEmail();
        JSONObject payload = new JSONObject();
        payload.put("name", name);
        payload.put("status", status);
        payload.put("email", email);

        setupHeaders();
        String finalEndpoint = endpoint + "/" + user_id;
        return request.body(payload.toString()).when().patch(finalEndpoint);
    }

    public static Response postCreateUser(String endpoint) {
        String name = "Lutfi Esa P";
        String gender = "male";
        String email = generateRandomEmail();
        String status = "active";

        JSONObject payload = new JSONObject();
        payload.put("name", name);
        payload.put("gender", gender);
        payload.put("email", email);
        payload.put("status", status);

        setupHeaders();
        return request.body(payload.toString()).when().post(endpoint);
    }
}
