package testler;

import araclar.Driver;
import araclar.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class WebTable extends TestBase {

    @Test
    public void tableTest(){
        Driver.getDriver().get("http://demo.guru99.com/test/web-table-element.php");
        WebElement tBody = Driver.getDriver().findElement(By.xpath("//tbody"));
        System.out.println(tBody.getText());

        WebElement tRow = Driver.getDriver().findElement(By.xpath("//tbody//tr[3]"));
        System.out.println(tRow.getText());

        WebElement tData = Driver.getDriver().findElement(By.xpath("//tbody//tr[3]//td[4]"));
        System.out.println(tData.getText());

        System.out.println("--------------------------");

        List<WebElement> satir4 = Driver.getDriver().findElements(By.xpath("//tbody//tr[4]"));

        for (WebElement hucre: satir4){
            System.out.println(hucre.getText());
            System.out.println();
        }
    }
    public void  printData (int satir, int hucre){
        //tbody//tr[3]//td[4]
        String dinamikXpath = "//tbody//tr["+ satir +"]//td["+ hucre + "]";
        WebElement data = Driver.getDriver().findElement(By.xpath(dinamikXpath));
        System.out.println(data.getText());
    }
    @Test
    public void dinamikTabloTesti(){
        Driver.getDriver().get("http://demo.guru99.com/test/web-table-element.php");
        printData(1,1);
        printData(2,2);
        printData(3,3);
        printData(4,4);
    }

    public String  printData2 (int satir, int hucre){
        //tbody//tr[3]//td[4]
        String dinamikXpath = "//tbody//tr["+ satir +"]//td["+ hucre + "]";
        WebElement data = Driver.getDriver().findElement(By.xpath(dinamikXpath));
        return data.getText();
    }
    @Test
    public void dinamikTabloTesti2() {
        Driver.getDriver().get("http://demo.guru99.com/test/web-table-element.php");
        System.out.println(printData2(1, 1));
        System.out.println(printData2(2, 1));
        System.out.println(printData2(3, 1));
        System.out.println(printData2(4, 1));
    }
    @Test
    public void dinamikTabloTesti3() {
        Driver.getDriver().get("http://demo.guru99.com/test/web-table-element.php");
        String expectedData = printData2(3,1);
        String actualData = printData2(3,1);
        Assert.assertEquals(expectedData,actualData);

    }
    @Test
    public void dinamikTabloTesti4() {
        Driver.getDriver().get("http://demo.guru99.com/test/web-table-element.php");
        String expectedData = printData3(3, 1);
        String actualData = printData3(3, 1);
        Assert.assertEquals(expectedData, actualData);
    }
}
