package Testler;

import Araclar.Testbase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Enable extends Testbase {

    @Test
    public void isEnabled(){



        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement enableButton = driver.findElement(By.xpath("(//button[@autocomplete='off'])[2]"));
        enableButton.click();

        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement enableMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));

        String expectedMessage = "It's enabled!";
        Assert.assertEquals(enableMessage.getText(), expectedMessage);

        WebElement textBox = driver.findElement(By.xpath("//input[@type='text']"));
        boolean isEnable = textBox.isEnabled();
        int sayi = 3;
        boolean durum = true;
        boolean durum2 = false;
        Assert.assertFalse(isEnable);

        // isEnable => elementin aktif işlem yapılabilir olup olmadığını sorugular. Sonuç True yada False'dur.
        // isSelected => radio button veya checkbox'ın seçili olup olmadığını sorgular.
        // isDisplayed => bir elementin görülebilir olup olmadğını sorgular.
    }
}
