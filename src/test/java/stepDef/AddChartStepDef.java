package stepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.HomePage;
import pages.LoginPage;

public class AddChartStepDef {

    LoginPage loginPage;
    HomePage homePage;

    public AddChartStepDef() {
        this.loginPage = new LoginPage();
        this.homePage = new HomePage();
    }

    @Given("user is on homepage")
    public void userIsOnHomepage() {
        loginPage.verifyHopePage();
    }

    @When("user clicks {string} button for Item")
    public void userClicksButtonFor(String buttonText) throws InterruptedException {
        homePage.addItemToCart();
    }

    @Then("the button should change to {string}")
    public void theButtonShouldChangeTo(String buttonTextChangeRemove) {
        homePage.validateRemoveButtonVisible();
    }

    @And("cart count should increase by {int}")
    public void cartCountShouldIncreaseBy(int count) {
        homePage.validateCartCount(count);
        homePage.getEvidance();
    }

}
