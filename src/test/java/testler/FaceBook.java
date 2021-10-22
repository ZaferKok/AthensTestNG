package testler;

import araclar.Driver;
import araclar.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FaceBook extends TestBase {
    @Test
    public void Registration() throws InterruptedException {
        Driver.getDriver().get("https://www.facebook.com/");

        WebElement cookiesButton = Driver.getDriver().findElement(By.xpath("(//button[@value='1'])[3]"));
        cookiesButton.click();
        Thread.sleep(3000);

        WebElement yeniKayit = Driver.getDriver().findElement(By.xpath("(//a[@role='button'])[2]"));
        yeniKayit.click();
        Thread.sleep(3000);

        WebElement firstName = Driver.getDriver().findElement(By.name("firstname"));
        firstName.sendKeys("Athens");
        Thread.sleep(3000);
    }
}
