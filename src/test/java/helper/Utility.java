package helper;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class Utility {

    public static WebDriver driver;
    public static WebDriverWait wait;

    public static File getJSONSchemaFile(String JSONFile){
        return new File("src/test/resources/JSONSchema/"+JSONFile);
    }

    public static String generateRandomEmail() {
        String allowedChars = "abcdefghijklmnopqrstuvwxyz" + "1234567890" + "-_.";
        String email = "";
        String temp = RandomStringUtils.randomAlphanumeric(10);
        email = temp + "@testdata.com";
        return email;
    }

    public static void startDriver() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
//        options.addArguments("--headless");
        options.addArguments("--no-sanbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--remote-allow-origins=*");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }

    public static void quitDriver() {
        driver.quit();
    }

}
