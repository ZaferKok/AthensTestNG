package pages;

import araclar.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AnaSayfa {

    public AnaSayfa() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(id = "search")
    public WebElement searchBox1;
    @FindBy(id = "gh-btn")
    public WebElement araIcon1;
    @FindBy(xpath = "(//span[@class='price'])[1]")
    public WebElement yogaPrice1;

}
