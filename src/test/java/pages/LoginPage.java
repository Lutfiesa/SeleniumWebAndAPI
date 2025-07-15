package pages;

import org.openqa.selenium.By;

import static helper.Utility.driver;

public class WebPage {

    By input_username = By.id("user-name");
    By input_password = By.id("password");
    By button_login = By.id("login-button");
    By cart = By.xpath("//*[@class='shopping_cart_link']");
    By error_message = By.xpath("//*[@class='error-button']");

    public void openBrowser(){
        driver.get("https://www.saucedemo.com/");
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

    public void errorMessage(){
        driver.findElement(error_message).isDisplayed();
    }

}
