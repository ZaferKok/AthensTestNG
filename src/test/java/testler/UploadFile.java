package testler;

import araclar.Driver;
import araclar.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class UploadFile extends TestBase {

    @Test
    public void uploadFileMethod() throws InterruptedException {
        // "https://the-internet.herokuapp.com/upload"

        Driver.getDriver().get("https://the-internet.herokuapp.com/upload");
        WebElement choseFile1 = Driver.getDriver().findElement(By.id("file-upload"));
        WebElement choseFile = Driver.getDriver().findElement(By.cssSelector("input[id='file-upload']"));
        String fileHome = System.getProperty("user.home");
        String filePath1 = fileHome + "/Downloads/messi.jpg";
        String filePath = "C:/Users/CIMBOM/Downloads/messi.jpg";// !!!!! Herkes kendi pathini tanımlamalı
        choseFile.sendKeys(filePath1); // bu şekilde ilgili doysayı sisteme yüklüyoruz.
        WebElement uploadButton = Driver.getDriver().findElement(By.cssSelector("input#file-submit"));
        uploadButton.click();
        WebElement actualUploadMessage = Driver.getDriver().findElement(By.xpath("//h3"));
        String expectedMessage = "File Uploaded!";
        Assert.assertEquals(actualUploadMessage.getText(), expectedMessage);

    }
}
