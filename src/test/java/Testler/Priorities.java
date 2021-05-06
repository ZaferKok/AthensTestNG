package Testler;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class Priorities {

    @Ignore
    @Test(priority = 1)
    public void tanaEkran(){
        System.out.println("Ben 1. çalışırım!");
    }

    @Test(priority = 2)
    public void ikinciEkran(){
        System.out.println("Ben 2. çalışırım!");
        Assert.assertEquals(2,2);
    }
    @Test(priority = 3, dependsOnMethods = "ikinciEkran")
    public void reklamSayfasi(){
        System.out.println("Ben 3. çalışırım!");
    }
}
