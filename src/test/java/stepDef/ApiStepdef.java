package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.ApiPage;

public class ApiStepdef {
    ApiPage apiPage;

    public ApiStepdef() {
        this.apiPage = new ApiPage();
    }

    @Given("prepare url for {string}")
    public void prepareUrl(String url) {
        apiPage.prepareUrl(url);
    }

    @And("hit api get list users")
    public void hitApiGetListUsers() {
        apiPage.hitApiGetListUsers();
    }

    @Then("validation status code is equals {int}")
    public void validationStatusCodeIsEquals(int status_code) {
         apiPage.validationStatusCodeIsEquals(status_code);
    }

    @Then("validation response body get list users")
    public void validationResponseBodyGetListUsers() {
        apiPage.validationResponseBodyGetListUsers();
    }

    @Then("validation response json with JSONSchema {string}")
    public void validationResponseJsonWithJSONSchema(String Filename) {
        apiPage.validationResponseJsonWithJSONSchema(Filename);
    }

    @And("hit api create new user")
    public void hitApiCreateNewUser() {
        apiPage.hitApiCreateNewUser();
    }

    @Then("validation response body create new user")
    public void validationResponseBodyCreateNewUser() {
        apiPage.validationResponseBodyCreateNewUser();
    }

    @And("hit api delete user")
    public void hitApiDeleteUser() {
        apiPage.hitApiDeleteUser();
    }

    @And("hit api update user")
    public void hitApiUpdateUser() {
        apiPage.hitApiUpdateUser();
    }

    @Then("validation response body update user")
    public void validationResponseBodyUpdateUser() {
        apiPage.validationResponseBodyUpdateUsers();
    }
}
