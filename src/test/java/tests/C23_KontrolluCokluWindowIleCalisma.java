package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C23_KontrolluCokluWindowIleCalisma extends TestBase {
    @Test
    public void Test01(){
        // Testotomasyonu anasayfaya gidin
        driver.get("https://testotomasyonu.com");

        // url'in testotomasyonu icerdigini test edin
        String expectedUrl = "testotomasyonu";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertTrue(actualUrl.contains(expectedUrl));
        String anasayfaWindowHandleDegeri = driver.getWindowHandle();

        // yeni bir tab olarak electronics linkini acin. TAB dedigi icin WindowType ı TAB seceriz
        driver.switchTo().newWindow(WindowType.TAB).get("https://testotomasyonu.com");
        driver.findElement(By.xpath("(//a[text()='Electronics'])[3]")).click();
        String electronicsWindowHandleDegeri = driver.getWindowHandle(); //window handle degerini kaydetmek icin yaparız

        // acilan sayfanin electronics sayfasi oldugunu test edin
        // Title'da Electronics oldugunu test edelim
        String expectedTitle = "Electronics";
        String actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        // yeni bir     WİNDOW'da acilacak sekilde menfashion linkini tiklayin
        driver.switchTo().newWindow(WindowType.WINDOW).get("https://testotomasyonu.com");
        driver.findElement(By.xpath("(//a[text()='Men Fashion'])[3]")).click();
        String menFashionWindowHandleDegeri = driver.getWindowHandle();

        // menfashion sayfasinin acildigini test edin
        expectedTitle = "Men Fashion";
        actualTitle = driver.getTitle();
        Assert.assertTrue(actualTitle.contains(expectedTitle));

        // ilk actigimiz sayfaya donun
        // EGER bir test'de acilan windowlar farkli tab veya farklı window'larda aciliyorsa
        // ve testimizde bu sayfalar arasinda gecis isteniyorsa
        // gectigimiz her sayfanin WindowHandleDegerini kaydetmeliyiz
        driver.switchTo().window(anasayfaWindowHandleDegeri);

        // test otomasyon anasayfada oldugumuzu test edin
        // url ile test edelim https://testotomasyonu.com/
        String expectedUrll = "https://testotomasyonu.com/";
        String actualUrll = driver.getCurrentUrl();
        Assert.assertTrue(actualUrll.contains(expectedUrll));

        // tekrar electronics acik olan tab'a gecin
        driver.switchTo().window(electronicsWindowHandleDegeri);

        // tekrar men fashion acik olan tab'a gecin
        driver.switchTo().window(menFashionWindowHandleDegeri);

    }

}
