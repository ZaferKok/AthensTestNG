package testler;

import araclar.Driver;
import araclar.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class Iframe extends TestBase {

    @Test
    public void iframeWork() throws InterruptedException {
        Driver.getDriver().get("https://the-internet.herokuapp.com/iframe");
        WebElement iframeBox = Driver.getDriver().findElement(By.id("mce_0_ifr"));
        Driver.getDriver().switchTo().frame(iframeBox);
        WebElement textBox = Driver.getDriver().findElement(By.xpath("//*[contains(text(),'Your content goes here.')]"));
        textBox.sendKeys("Athens");
        Thread.sleep(2000);
        textBox.clear();
        textBox.sendKeys("Athens2");
        Thread.sleep(2000);
        Driver.getDriver().switchTo().defaultContent();
        WebElement pageTitle = Driver.getDriver().findElement(By.xpath("//h3"));
        System.out.println(pageTitle.getText());
        Assert.assertEquals(pageTitle.getText(),"An iFrame containing the TinyMCE WYSIWYG Editor");

        //I HAVE IFRAME ON THE PAGE. SO I HAVE TO SWITCH TO THAT IFRAME FIRST
        //THERE ARE 3 WAYS TO SWITCH TO AN IFRAME:1.index,2.id,3.webelement
        //driver.switchTo().frame(0);//switching to the first iframe using index
        //driver.switchTo().defaultContent()   framelerden çıkar en üste geçer.
        //switching back to parent frame
        //driver.switchTo().parentFrame(); bir üst frame geçmek için kullanırız

    }
}
