package araclar;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.util.concurrent.TimeUnit;

public class TestBase {

//    protected WebDriver driver;
    protected Actions actions;

    @BeforeMethod
    public void Ilk() {
        Driver.getDriver().manage().window().maximize();
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        System.out.println("Testimiz başlamıştır");
//        WebDriverManager.chromedriver().setup();
//        driver = new ChromeDriver();
//        driver.manage().window().maximize();
//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
//        System.out.println("TestNG");
        System.out.println("***********************");
//        actions = new Actions(driver);
        actions = new Actions(Driver.getDriver());
    }

    @AfterMethod
    public void Son(){
        Driver.getDriver().close();
        // driver.close();
        System.out.println("***********************");
        System.out.println("Testimiz tamamlanmıştır!");
    }


    //-------------------------------------------------------------------
    // Web Table da kullanmak üzere dinamik hücre bilgisi alma metodu
    public String  printData3 (int satir, int hucre){
        //tbody//tr[3]//td[4]
        String dinamikXpath = "//tbody//tr["+ satir +"]//td["+ hucre + "]";
        //WebElement data = driver.findElement(By.xpath(dinamikXpath));
        WebElement data = Driver.getDriver().findElement(By.xpath(dinamikXpath));
        return data.getText();
    }
}
