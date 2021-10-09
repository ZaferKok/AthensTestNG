package Testler;

import Araclar.Testbase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Alert extends Testbase {
    /*
    Create 3 methods
    1. acceptAlert
    2. dismissAlert
    3. sendKeysAlert
    Create a @BeforeMethod
    Go to https://demoqa.com/alerts
     */
    @BeforeMethod
    public void acilis() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("TestNG");
        actions = new Actions(driver);
    }

    @AfterMethod
    public void kapanis(){
        //driver.close();
        System.out.println("Ben son çalışırım: Testimiz tamamlanmıştır!");
    }
    @Test
    public void acceptAlert() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        WebElement click1 = driver.findElement(By.id("alertButton"));
        click1.click();
        Thread.sleep(2000);
        driver.switchTo().alert().accept();
        Thread.sleep(2000);
    }
    @Test
    public void confirmAlert() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        WebElement click3 = driver.findElement(By.id("confirmButton"));
        click3.click();
        Thread.sleep(1000);
        driver.switchTo().alert().dismiss();
        Thread.sleep(1000);
        WebElement text1 = driver.findElement(By.xpath("//*[contains(text(),'You selected ')]"));
        Thread.sleep(1000);
        System.out.println(text1.getText());
        Assert.assertEquals(text1.getText(),"You selected Cancel");
    }
    @Test
    public void sendMessageAlert() throws InterruptedException {
        driver.get("https://demoqa.com/alerts");
        WebElement click4 = driver.findElement(By.id("promtButton"));
        click4.click();
        Thread.sleep(1000);
        driver.switchTo().alert().sendKeys("Athens");
        Thread.sleep(3000);
        driver.switchTo().alert().accept();
        Thread.sleep(1000);
        WebElement text2 = driver.findElement(By.xpath("//*[contains(text(),'You entered ')]"));
        Thread.sleep(1000);
        System.out.println(text2.getText());
        Assert.assertEquals(text2.getText(),"You entered Athens");
    }
}
