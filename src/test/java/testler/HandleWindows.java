package testler;

import araclar.Driver;
import araclar.TestBase;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import java.util.Set;

public class HandleWindows extends TestBase {

    @Test
    public void windowHandle() throws InterruptedException {

        Driver.getDriver().get("https://the-internet.herokuapp.com/windows");
        ((JavascriptExecutor)Driver.getDriver()).executeScript("window.open('https://www.google.com/', '_blank');");
Thread.sleep(2000);
        ((JavascriptExecutor)Driver.getDriver()).executeScript("window.open('https://www.amazon.com/', '_blank');");
Thread.sleep(2000);
        Set<String> tabs = Driver.getDriver().getWindowHandles();
Thread.sleep(5000);
        Driver.getDriver().switchTo().window(tabs.toArray()[1].toString());

        for (int i = 0; i < tabs.size(); i++) {
            Driver.getDriver().switchTo().window(tabs.toArray()[i].toString());
            System.out.println(i + ". window ==> " + Driver.getDriver().getTitle());

        }

    }
}
