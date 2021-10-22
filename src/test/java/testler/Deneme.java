package testler;

import araclar.Driver;
import araclar.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Deneme extends TestBase {

    @Test
    public void bilgisayarSonucTesti(){

        Driver.getDriver().get("https://signal-telecom.net/shop/");
        WebElement searchBox = Driver.getDriver().findElement(By.id("search"));
        searchBox.sendKeys("yoga");
        searchBox.submit();
        WebElement yogaPrice = Driver.getDriver().findElement(By.xpath("(//span[@class='price'])[1]"));
        String actualData = yogaPrice.getText();
        String expectedData = "$56.25";

        Assert.assertEquals(actualData,expectedData);
    }
}
