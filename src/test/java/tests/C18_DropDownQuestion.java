package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.List;

public class C18_DropDownQuestion extends TestBase {
    @Test
    public void Question01(){
        //● https://www.amazon.com/ adresine gidin.
        driver.get("https://www.amazon.com/");
        //Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 54
        //oldugunu test edin
        driver.findElement(By.id("searchDropdownBox")).click();
        WebElement kategorilerDdm = driver.findElement(By.xpath("//*[@title='Search in']"));
        Select select = new Select(kategorilerDdm);
        //Tum opsiyonları almamızı istediği icin;
        List<WebElement> kategoriListesi  = select.getOptions();
        System.out.println(ReusableMethods.stringListeDonustur(kategoriListesi));
        Assert.assertEquals(54,kategoriListesi.size());
        /*
        Java.lang.AssertionError:
        Expected :54
       Actual   :28
         */
    }
    @Test
    public void Question02() throws InterruptedException {
        //● https://www.amazon.com/ adresine gidin.
        driver.get("https://www.amazon.com/");
        // Kategori menusunden Books secenegini secin
        driver.findElement(By.id("searchDropdownBox")).click();
        WebElement kategorilerDdm = driver.findElement(By.xpath("//*[@title='Search in']"));
        Select select = new Select(kategorilerDdm);
        select.selectByVisibleText("Books");
        // Arama kutusuna Java yazin ve aratin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);
        // Bulunan sonuc sayisini yazdirin
        WebElement sonucYazisi = driver.findElement(By.className("sg-col-inner"));
        String sonucSayisiStr = sonucYazisi.getText().replaceAll("\\D","");
        int sonucSayisiInt = Integer.parseInt(sonucSayisiStr);
        System.out.println(sonucSayisiInt);
        // Sonucun Java kelimesini icerdigini test edin
        WebElement sonuc = driver.findElement(By.className("sg-col-inner"));
        String sonucYazisiStr = sonucYazisi.getText();
        System.out.println(sonucYazisiStr);
        Assert.assertFalse(sonucSayisiStr.contains("Java"));
    }
}
