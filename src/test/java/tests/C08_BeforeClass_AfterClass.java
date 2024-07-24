package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.AssertionFailedError;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C08_BeforeClass_AfterClass {
    /*
   Before Class testlerin en basında bir kere calısır ve After Class testlerin en sonunda 1 kere calısır
    */
    /*3 farklı test methodu olusturarak asagıdakileri yapin
    1-testotomasyonu.com sayfasina gidip url'in testotomasyonu icerdigini test edin
    2-phone icin arama yaptirin ve aramam sonucunda urun bulunabildigini test edin
    3-ilk urune tıklayın ve urun acıklamasında case sensitive olmadan phone gectigini test edin
     */
    /*
    Bu gorevler birbirine baglıdır ve saglıklı olarak yapılabilmesi icin
    -test methodlarının dogru sırada calısması gerekir (methodlara test01,test02,test03 gibi isimler veririz)
    -driver objesi um methodlardan nce olusturulmalı ve tum methodlar calıstıktan sonra kapatılmalıdır(BeforeClass, AfterClass olustururuz)
    Ancak dikkat etmemiz gereken konu bu notasyonlari kullanan methodlar STATIC olmalıdır
     */
    /*
    Before Class testlerin en basında bir kere calısır ve After Class testlerin en sonunda 1 kere calısır
     */
    static WebDriver driver;
    @BeforeClass
    public static void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    @AfterClass
    public static void teardown(){
        driver.quit();
    }
    @Test
    public void test01(){
        // 1-testotomasyonu.com sayfasina gidip url'in testotomasyonu icerdigini test edin
        driver.get("https://testotomasyonu.com");
        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "testotomasyonu";
        if (actualUrl.contains(expectedUrl)){
            System.out.println("Url test passed");
        }else {
            System.out.println("Url testi failed");
            throw new AssertionFailedError();
        }ReusableMethods.bekle(2);
    }
    @Test
    public void test02(){
        //phone icin arama yapın arama sonucunda urun bulunup bulunmadıgını test edin
        WebElement phone = driver.findElement(By.xpath("//input[@id='global-search']"));
        phone.sendKeys("phone" + Keys.ENTER);
        WebElement phoneSayisi = driver.findElement(By.className("product-count-text"));
        String elemansayisiStr = phoneSayisi.getText().replaceAll("\\D","");
        int elemanSayisiInt = Integer.parseInt(elemansayisiStr);
        if (elemanSayisiInt > 0) {
            System.out.println("Phone Test Passed");
        } else {
            System.out.println("Phone Test Failed");
            throw new AssertionFailedError();
        }
        ReusableMethods.bekle(2);
    }
    @Test
    public void test03(){
        //  3-ilk urune tıklayın ve urun acıklamasında case sensitive olmadan phone gectigini test edin
        driver.findElement(By.xpath("(//div[@class='product-box my-2  py-1'])[1]")).click();
        WebElement arananKelime = driver.findElement(By.xpath("//*[@class='product-short-desc  my-2']"));
        String expectedKelime ="phone";
        String actualText = arananKelime.getText().toLowerCase();
        if (actualText.contains(expectedKelime)){
            System.out.println("Aranan kelime testi Passed");
        }else {
            System.out.println("Aranan kelime testi Failed");
            throw new AssertionFailedError();
        }
    }
}
