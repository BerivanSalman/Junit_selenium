package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.AssertionFailedError;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C06_BeforeAfterNotasyonlari {
    /*
    JUnite'e gore bir testin Failed olabilmesi icin kodların bir sorunla karsılasması ve
    odların methodun sonuna kadar calısmaması gerekir
    Ornek olması icin biz bu methodda throw new AssertionFailedError() diyerek test failed oldugunda
    kodun calısmayı durdurmasını sağladık
    JUnitte xception olustugu icin bu testi FAILED olarak etiketledi
     */
    WebDriver driver;
    @Before //@Before yazınca driverOlustur methodunu call yapmadan da calıstırır asagısaki testler
    public void setup(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    @After //bunu olusturunca asagıdaki testlerin sonuna quit demesek de quit bu methodla calısır
    public void teardown(){
        driver.quit();
    }
    @Test
    public void wisequarterTest(){
        //https://testotomasyonu.com sayfasına gidin
        driver.get("https://testotomasyonu.com ");
        ReusableMethods.bekle(2);
    }
    @Test
    public void testOtomasyonuTest(){
        //https://testotomasyonu.com sayfasına gidin
        driver.get("https://testotomasyonu.com ");
        //title ın "Google"icerdigini test edin
        String expectedTitle = "Google";
        String actualTitle = driver.getTitle();
        if (actualTitle.contains(expectedTitle))
        {
            System.out.println("test passed");
        }else {
            System.out.println("test failed"); //testin calıstıgı bolum asagıda tik olarak cıkmaması icin ;
            throw new AssertionFailedError();
        }
        ReusableMethods.bekle(2);
    }

    @Test @Ignore
    public void googleTest(){
        //https://google.com adresine gidin
        driver.get("https://google.com");
        ReusableMethods.bekle(2);
    }
}
