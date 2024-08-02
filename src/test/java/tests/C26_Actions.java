package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C26_Actions extends TestBase {
    @Test
    public void sagClickTesti(){
        //2- https://the-internet.herokuapp.com/context_menu sitesine gidin
        driver.get("https://the-internet.herokuapp.com/context_menu");

        //3- Cizili alan uzerinde sag click yapin
        Actions actions = new Actions(driver);
        WebElement cizgiAlan = driver.findElement(By.id("hot-spot"));
        actions.contextClick(cizgiAlan).perform();

        //4- Alert’te cikan yazinin “You selected a context menu” oldugunu test edin.
        String expectedText = "You selected a context menu";
        String actualTect = driver.switchTo().alert().getText();
        Assert.assertEquals(expectedText,actualTect);
        //5- Tamam diyerek alert’i kapatalim
        driver.switchTo().alert().accept();

        //6- Elemental Selenium linkine tiklayalim
       driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();
       //Elemental Selenium linkine  tiklayinca yeni window da acılıyor. Yeni sayfadaki yaziyi okuyabilmem icin
        // driver ımı yeni sayfaya gecirmem gerekiyor.

        //7- Acilan  yeni sayfada h1 taginda “Make sure your code lands” yazdigini test edelim
        driver = ReusableMethods.titleIleSayfaDegistir(driver,"Elemental Selenium | Elemental Selenium");
        WebElement h1Yazielementi = driver.findElement(By.tagName("h1"));
        String expectedYazi = "Make sure your code lands";
        String actualH1Yazi = h1Yazielementi.getText();

        Assert.assertEquals(expectedYazi,actualH1Yazi);

    }

}
