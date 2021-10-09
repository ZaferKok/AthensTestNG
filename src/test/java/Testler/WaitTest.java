package Testler;

import Araclar.Testbase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class WaitTest {

    protected WebDriver driver;

    @Test
    public void implicitWait() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

        WebElement removeButton = driver.findElement(By.xpath("(//button[@type='button'])[1]"));
        removeButton.click();

        WebElement textMessage = driver.findElement(By.xpath("//p[@id='message']"));
        String actualText = textMessage.getText();
        String expectedText = "It's gone!";

        Assert.assertEquals(actualText, expectedText);
        driver.close();
    }
        @Test
        public void explicitWait() {

        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        driver.manage().window().maximize();

        WebElement removeButton = driver.findElement(By.xpath("(//button[@type='button'])[1]"));
        removeButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 5);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));

        WebElement message = driver.findElement(By.id("message"));
            String actualText = message.getText();
            String expectedText = "It's gone!";

        Assert.assertEquals(actualText,expectedText);

        driver.close();


    }
}
