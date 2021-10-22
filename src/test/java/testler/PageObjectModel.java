package testler;

import araclar.ConfigReader;
import araclar.Driver;
import araclar.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.AnaSayfa;

public class PageObjectModel extends TestBase {

    AnaSayfa anaSayfa = new AnaSayfa();
    @Test
    public void SearchTest() {

        Driver.getDriver().get(ConfigReader.getProperty("url_women"));
        //driver.get("https://www.google.com/");
        anaSayfa.searchBox1.click();
        anaSayfa.searchBox1.sendKeys(ConfigReader.getProperty("a"));
        anaSayfa.searchBox1.submit();
        String expectedPrice = "$56.25";
        String actualPrice = anaSayfa.yogaPrice1.getText();

        Assert.assertEquals(expectedPrice, actualPrice);
    }
}
