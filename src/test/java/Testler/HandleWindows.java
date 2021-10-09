package Testler;

import Araclar.Testbase;
import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;

import java.util.Set;

public class HandleWindows extends Testbase {

    @Test
    public void windowHandle() throws InterruptedException {

        driver.get("https://the-internet.herokuapp.com/windows");
        ((JavascriptExecutor)driver).executeScript("window.open('https://www.google.com/', '_blank');");
Thread.sleep(2000);
        ((JavascriptExecutor)driver).executeScript("window.open('https://www.amazon.com/', '_blank');");
Thread.sleep(2000);
        Set<String> tabs = driver.getWindowHandles();
Thread.sleep(5000);
        driver.switchTo().window(tabs.toArray()[1].toString());

        for (int i = 0; i < tabs.size(); i++) {
            driver.switchTo().window(tabs.toArray()[i].toString());
            System.out.println(i + ". window ==> " + driver.getTitle());

        }

    }
}
