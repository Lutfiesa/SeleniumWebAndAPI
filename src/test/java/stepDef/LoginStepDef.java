package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.LoginPage;

public class WebStepDef {

    LoginPage webPage;

    public  WebStepDef() {
        this.webPage = new LoginPage();
    }

    @Given("open web login page")
    public void openWebLoginPage() {
        webPage.openBrowser();
    }

    @And("input valid username {string} and password {string}")
    public void inputValidUsernameAndPassword(String user, String pwd) {
        webPage.inputUsernameAndPassword(user,pwd);
    }


    @And("click button login")
    public void clickButtonLogin() {
        webPage.clickButtonLogin();
    }

    @Then("user will direct to homepage")
    public void userWillDirectToHomepage() {
        webPage.verifyHopePage();
    }

    @Then("user will see error message {string}")
    public void userWillSeeErrorMessage(String errorMessage) {
        webPage.errorMessage(errorMessage);
    }
}
