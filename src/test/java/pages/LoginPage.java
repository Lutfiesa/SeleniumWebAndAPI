package pages;

import org.junit.Assert;
import org.openqa.selenium.By;

import static helper.Endpoint.WEB_URL;
import static helper.Utility.driver;

public class LoginPage {

    By input_username = By.id("user-name");
    By input_password = By.id("password");
    By button_login = By.id("login-button");
    By cart = By.xpath("//*[@class='shopping_cart_link']");

    public void openBrowser(){
        driver.get(WEB_URL);
    }

    public void inputUsernameAndPassword(String username, String password){
        driver.findElement(input_username).sendKeys(username);
        driver.findElement(input_password).sendKeys(password);
    }

    public void clickButtonLogin(){
        driver.findElement(button_login).click();
    }

    public void verifyHopePage(){
        driver.findElement(cart).isDisplayed();
    }

    public By getErrorMessage(String message) {
        return By.xpath("//h3[contains(text(),'" + message + "')]");
    }

    public void errorMessage(String errorMessage){
        boolean isDisplayed = driver.findElement(getErrorMessage(errorMessage)).isDisplayed();
    }

}
