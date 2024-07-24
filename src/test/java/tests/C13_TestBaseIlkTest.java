package tests;

import utilities.TestBase;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;


public class C13_TestBaseIlkTest extends TestBase {
    @Test
    public void aramaTesti(){
        driver.get("https://testotomasyonu.com");
        //phone icin arama yapin
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" + Keys.ENTER);
        //arama sonucunda urun bulunabildigini test edin
        WebElement aramaSonucElementi = driver.findElement(By.className("product-count-text"));
        String aramaSonucElementiStr = aramaSonucElementi.getText().replaceAll("\\D","");
        int aramaSonucElementiInt = Integer.parseInt(aramaSonucElementiStr);
        Assert.assertTrue(aramaSonucElementiInt>0);
    }

}
