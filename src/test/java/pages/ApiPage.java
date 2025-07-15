package pages;

import helper.Endpoint;

import static helper.Models.*;
import static org.assertj.core.api.Assertions.assertThat;

import helper.Utility;
import io.restassured.module.jsv.JsonSchemaValidator;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import java.io.File;
import java.util.List;

public class ApiPage {

    String setURL, global_id;
    Response res;

    public void prepareUrl(String url) {
        switch (url) {
            case "GET_LIST_USERS":
                setURL = Endpoint.GET_LIST_USERS;
                break;
            case "CREATE_NEW_USER":
                setURL = Endpoint.CREATE_NEW_USER;
                break;
            case "DELETE_USER":
                setURL = Endpoint.DELETE_USER;
                break;
            case "UPDATE_USER":
                setURL = Endpoint.UPDATE_USER;
                break;
            default:
                System.out.println("URL NOT FOUND");
        }
//        System.out.println("Set URL To : " + setURL);
    }

    public void hitApiGetListUsers() {
        res = getListUsers(setURL);
//        System.out.println(res.body().asString());
    }

    public void hitApiCreateNewUser() {
        res = postCreateUser(setURL);
//        System.out.println(res.getBody().asString());
    }

    public void hitApiDeleteUser() {
        res = deleteUser(setURL,global_id);
//        System.out.println(res.getBody().asString());
    }

    public void hitApiUpdateUser() {
        res = updateUser(setURL,global_id);
//        System.out.println(res.getBody().asString());
    }

    public void validationStatusCodeIsEquals(int status_code) {
        assertThat(res.statusCode()).isEqualTo(status_code);
    }

    public void validationResponseBodyCreateNewUser() {
        JsonPath jsonPathEvaluator = res.jsonPath();
        Integer id = jsonPathEvaluator.get("id");
        String name = jsonPathEvaluator.get("name");
        String email = jsonPathEvaluator.get("email");
        String gender = jsonPathEvaluator.get("gender");
        String status = jsonPathEvaluator.get("status");

        assertThat(id).isNotNull();
        assertThat(name).isNotNull();
        assertThat(email).isNotNull();
        assertThat(gender).isIn("female", "male");
        assertThat(status).isIn("active", "inactive");

        global_id = Integer.toString(id);
    }

    public void validationResponseBodyGetListUsers() {
        List<Object> id = res.jsonPath().getList("id");
        List<Object> name = res.jsonPath().getList("name");
        List<Object> email = res.jsonPath().getList("email");
        List<Object> gender = res.jsonPath().getList("gender");
        List<Object> status = res.jsonPath().getList("status");

        assertThat(id.get(0)).isNotNull();
        assertThat(name.get(0)).isNotNull();
        assertThat(email.get(0)).isNotNull();
        assertThat(gender.get(0)).isIn("female", "male");
        assertThat(status.get(0)).isIn("active", "inactive");
    }

    public void validationResponseBodyUpdateUsers() {
        JsonPath jsonPathEvaluator = res.jsonPath();
        Integer id = jsonPathEvaluator.get("id");
        String name = jsonPathEvaluator.get("name");
        String email = jsonPathEvaluator.get("email");
        String gender = jsonPathEvaluator.get("gender");
        String status = jsonPathEvaluator.get("status");

        assertThat(id).isNotNull();
        assertThat(name).isNotNull();
        assertThat(email).isNotNull();
        assertThat(gender).isIn("female", "male");
        assertThat(status).isIn("active", "inactive");
    }

    public void validationResponseJsonWithJSONSchema(String Filename) {
        File JSONFile = Utility.getJSONSchemaFile(Filename);
        res.then().assertThat().body(JsonSchemaValidator.matchesJsonSchema(JSONFile));
    }

}
