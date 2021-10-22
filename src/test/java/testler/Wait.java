package testler;

import araclar.Driver;
import araclar.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Wait extends TestBase {
    //"https://the-internet.herokuapp.com/dynamic_controls"

    @Test
    public void implicitlyWait() throws InterruptedException {
    // driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Testbase alarak sürekli yazmaktan kurtuluruz. Testimiz daha düzenli temiz durur.
    // implicitlyWait(): sayfa yüklendikten sonra her bir element için tahsis edilen süre içinde gerektiği kadar bekler. Bu süre
    // biz şimdilik Testbase'imizde 10 sn olarak tahsis ettik ve herbir Test senaryosu için ayrı ayrı Wait oluşturmamak için
    // onu Testbase yerleştirdik ve extend ile kullandık. Eğer WebElement 1,5 saniyede locate edilirse 8,5 saniye bekleme yapmadan driver
    // testi koşturmaya devem eder.

        Driver.getDriver().get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement addButton = Driver.getDriver().findElement(By.xpath("//button[@type='button']"));
        addButton.click();
    //  Thread.sleep(5000); // Bunu artık testlerimizde kullanmaya gerek yok. Ancak senkronizasyon hatısını bulmak için testcase yazımında geçici olarak kullanılabilir.
        WebElement message = Driver.getDriver().findElement(By.id("message"));
        String expectedMessage = "It's gone!"; // Test dökümantasyonundan tedarik edilir
        Assert.assertEquals(message.getText(), expectedMessage);
    }
    @Test
    public void emplicitlyWait(){
        // https://the-internet.herokuapp.com/dynamic_controls
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10); // Özel olarak bazı locate durumlarında kullanılır.
        // ExplicitlyWait için obje oluşturmak gerekir. wait.until metodu ile element spesifik olarak locate edilir.

        Driver.getDriver().get("https://the-internet.herokuapp.com/dynamic_controls");
        WebElement removeButton = Driver.getDriver().findElement(By.xpath("//button[@type='button']"));
        removeButton.click();
        WebElement goneMessage = wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));
        String expectedMessage = "It's gone!"; // Test dökümantasyonundan tedarik edilir
        Assert.assertEquals(goneMessage.getText(), expectedMessage);
    }
}
