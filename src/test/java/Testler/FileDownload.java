package Testler;

import Araclar.Testbase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.nio.file.Files;
import java.nio.file.Paths;

public class FileDownload extends Testbase {

    @Test
    public void isExistTest(){

        String currentFolder = System.getProperty("user.dir");
        System.out.println("Current Folder => " + currentFolder);

        String userFolder = System.getProperty("user.home");
        System.out.println("Current Home => " + userFolder);

        String pathOfFile = userFolder + "/Downloads/messi.jpg";

        boolean isFileExist = Files.exists(Paths.get(pathOfFile));

        Assert.assertTrue(isFileExist);

    }
    @Test
    public void downloadTest() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/download");

        WebElement resimLink1 = driver.findElement(By.xpath("//*[contains(text(),'puppy_and_kitten')]"));
        resimLink1.click();
        Thread.sleep(3000);

        String userFolder = System.getProperty("user.home");
        String pathOfFile = userFolder + "/Downloads/puppy_and_kitten.jpg";

        boolean isDownloaded = Files.exists(Paths.get(pathOfFile));
        Assert.assertTrue(isDownloaded);

    }
}
