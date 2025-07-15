package pages;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static helper.Utility.driver;
import static helper.Utility.wait;

public class HomePage {

    By product1 = By.id("add-to-cart-sauce-labs-backpack");
    By cart = By.xpath("//*[@id=\"shopping_cart_container\"]/a");
    By productRemove = By.id("remove-sauce-labs-backpack");

    public void addItemToCart() throws InterruptedException {
        WebElement addButton = wait.until(ExpectedConditions.elementToBeClickable(product1));
//        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", addButton);

        Assert.assertTrue(addButton.isDisplayed());

        try {
            addButton.click();
        } catch (Exception e) {
            ((JavascriptExecutor) driver).executeScript("arguments[0].click();", addButton);
        }
        wait.until(ExpectedConditions.invisibilityOfElementLocated(product1));
    }

    public void validateRemoveButtonVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(productRemove));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(productRemove, "Remove"));
        WebElement removeButton = driver.findElement(productRemove);
        Assert.assertTrue(removeButton.isDisplayed());
        Assert.assertEquals("Remove", removeButton.getText());
    }

    public void validateCartCount(int expectedCount) {
        WebElement cartBadge = driver.findElement(cart);
        Assert.assertTrue(cartBadge.isDisplayed());
        Assert.assertEquals(String.valueOf(expectedCount), cartBadge.getText());
    }

//    public void clickCart() {
//        WebElement cartBadge = driver.findElement(cart);
//        Assert.assertTrue(cartBadge.isDisplayed());
//        cartBadge.click();
//    }

    public void getEvidance() {

        try {
            File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss"));
            String fileName = "screenshot_" + timestamp + ".png";
            File targetFile = new File("screenshots/HomePage/" + fileName);
            targetFile.getParentFile().mkdirs();
            FileUtils.copyFile(screenshot, targetFile);

            System.out.println("Screenshot saved to: " + targetFile.getAbsolutePath());

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }

    }

}
