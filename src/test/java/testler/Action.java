package testler;

import araclar.Driver;
import araclar.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class Action extends TestBase {
//    Create a class: ActionsClassExample
//    Create a test method : contextClickMethod() and test the following scenario:
//    Given user is on the https://the-internet.herokuapp.com/context_menu
//    When use Right clicks on the box
//    Then verify the alert message is “You selected a context menu”
//    Then accept the alert

    @Test
    public void rightClick(){

        Driver.getDriver().get("https://the-internet.herokuapp.com/context_menu");

        WebElement box = Driver.getDriver().findElement(By.id("hot-spot"));
        actions.contextClick(box).perform();
        String actualText = Driver.getDriver().switchTo().alert().getText();
        Assert.assertEquals(actualText,"You selected a context menu");
        Driver.getDriver().switchTo().alert().accept();
    }
    //    Create a method in the same class: keysUpDown()
    //    Go to google
    //    Search for IPHONE X PRICES (all capital)
    //    And double click on the text box

    @Test
    public void keyUpDown() throws InterruptedException {

        Driver.getDriver().get("https://www.ebay.de/");

        WebElement searchBox = Driver.getDriver().findElement(By.name("_nkw"));
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

        Driver.getDriver().get("https://www.ebay.de/");

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

        Driver.getDriver().get("https://www.amazon.com/");
    WebElement signInBox =     Driver.getDriver().findElement(By.cssSelector("a#nav-link-accountList"));
    actions.moveToElement(signInBox).perform();
    Thread.sleep(1000);
    WebElement myAccount =     Driver.getDriver().findElement(By.xpath("(//*[contains(text(),'Account')])[4]"));
    myAccount.click();
    Thread.sleep(1000);
    WebElement title =     Driver.getDriver().findElement(By.xpath("(//*[contains(text(),'Your Account')])[4]"));
    String actualTitle = title.getText();
    String expectedTitle = "Your Account";

        softAssert.assertTrue(actualTitle.contains(expectedTitle));

    Thread.sleep(1000);
        String actualTitle2 =     Driver.getDriver().getTitle();

      softAssert.assertTrue(actualTitle2.contains("Your Account"));

        softAssert.assertAll();
    }
    @Test
    public void doubleClick() throws InterruptedException {

        Driver.getDriver().get("https://www.amazon.com/");
        WebElement searchBox = Driver.getDriver().findElement(By.id("twotabsearchtextbox"));
        searchBox.sendKeys("Computer");
        actions.doubleClick(searchBox).perform();
        Thread.sleep(2000);
    }
}
