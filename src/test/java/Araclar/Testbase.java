package Araclar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class Testbase {

    protected WebDriver driver;
    protected Actions actions;

    @BeforeMethod
    public void acilis() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
     //   driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("TestNG");
        actions = new Actions(driver);
    }

    @AfterMethod
    public void kapanis(){
        driver.close();
        System.out.println("Ben son çalışırım: Testimiz tamamlanmıştır!");
    }
}
