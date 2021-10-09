package Testler;

import Araclar.Testbase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class FaceBook extends Testbase {
    @Test
    public void Registration() throws InterruptedException {
        driver.get("https://www.facebook.com/");

        WebElement cookiesButton = driver.findElement(By.xpath("(//button[@value='1'])[3]"));
        cookiesButton.click();
        Thread.sleep(3000);

        WebElement yeniKayit = driver.findElement(By.xpath("(//a[@role='button'])[2]"));
        yeniKayit.click();
        Thread.sleep(3000);

        WebElement firstName = driver.findElement(By.name("firstname"));
        firstName.sendKeys("Athens");
        Thread.sleep(3000);
    }
}
