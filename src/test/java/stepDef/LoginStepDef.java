package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import pages.LoginPage;

public class LoginStepDef {

    LoginPage loginPage;

    public LoginStepDef() {
        this.loginPage = new LoginPage();
    }

    @Given("open web login page")
    public void openWebLoginPage() {
        loginPage.openBrowser();
    }

    @And("input valid username {string} and password {string}")
    public void inputValidUsernameAndPassword(String user, String pwd) {
        loginPage.inputUsernameAndPassword(user,pwd);
    }


    @And("click button login")
    public void clickButtonLogin() {
        loginPage.clickButtonLogin();
    }

    @Then("user will direct to homepage")
    public void userWillDirectToHomepage() {
        loginPage.verifyHopePage();
    }

    @Then("user will see error message {string}")
    public void userWillSeeErrorMessage(String errorMessage) {
        loginPage.errorMessage(errorMessage);
    }
}
