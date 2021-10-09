package Testler;

import Araclar.Testbase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import sun.awt.windows.ThemeReader;

public class Action extends Testbase {
//    Create a class: ActionsClassExample
//    Create a test method : contextClickMethod() and test the following scenario:
//    Given user is on the https://the-internet.herokuapp.com/context_menu
//    When use Right clicks on the box
//    Then verify the alert message is “You selected a context menu”
//    Then accept the alert

    @Test
    public void rightClick(){

        driver.get("https://the-internet.herokuapp.com/context_menu");

        WebElement box = driver.findElement(By.id("hot-spot"));
        actions.contextClick(box).perform();
        String actualText = driver.switchTo().alert().getText();
        Assert.assertEquals(actualText,"You selected a context menu");
        driver.switchTo().alert().accept();
    }
    //    Create a method in the same class: keysUpDown()
    //    Go to google
    //    Search for IPHONE X PRICES (all capital)
    //    And double click on the text box

    @Test
    public void keyUpDown() throws InterruptedException {

        driver.get("https://www.ebay.de/");

        WebElement searchBox = driver.findElement(By.name("_nkw"));
        //searchBox.sendKeys("iphone x prices");
        // 1.Yöntem
        // searchBox.sendKeys(Keys.SHIFT + "iphone x prices");
        // Thread.sleep(2000);

        // 2.Yöntem
        actions.
                keyDown(searchBox, Keys.SHIFT).
                sendKeys("iphone x prices").
                keyUp(searchBox, Keys.SHIFT).
                perform();
         Thread.sleep(2000);
    }
    @Test
    public void scrollUpDown() throws InterruptedException {

        driver.get("https://www.ebay.de/");

        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.PAGE_DOWN).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.ARROW_DOWN).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.PAGE_UP).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.ARROW_UP).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.END).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.UP).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.END).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.HOME).perform();
        Thread.sleep(1000);
        actions.sendKeys(Keys.DOWN).perform();
        Thread.sleep(1000);
    }
    @Test
    public void hoverover() throws InterruptedException {

        SoftAssert softAssert = new SoftAssert();

    driver.get("https://www.amazon.com/");
    WebElement signInBox = driver.findElement(By.cssSelector("a#nav-link-accountList"));
    actions.moveToElement(signInBox).perform();
    Thread.sleep(1000);
    WebElement myAccount = driver.findElement(By.xpath("(//*[contains(text(),'Account')])[4]"));
    myAccount.click();
    Thread.sleep(1000);
    WebElement title = driver.findElement(By.xpath("(//*[contains(text(),'Your Account')])[4]"));
    String actualTitle = title.getText();
    String expectedTitle = "Your Account";

        softAssert.assertTrue(actualTitle.contains(expectedTitle));

    Thread.sleep(1000);
        String actualTitle2 = driver.getTitle();

      softAssert.assertTrue(actualTitle2.contains("Your Account"));

        softAssert.assertAll();
    }
    @Test
    public void doubleClick() throws InterruptedException {

        driver.get("https://www.amazon.com/");
        WebElement searchBox = driver.findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Computer");
        actions.doubleClick(searchBox).perform();
        Thread.sleep(2000);
    }
}
