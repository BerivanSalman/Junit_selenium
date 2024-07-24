package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C10_AssertionsQuestion {
    /*Ayrı ayrı test methodları olusturdugumuz icin birinin failed olması diğerlerini etkilemez
    Tek bir test methodunda yaparsak birinde hata olunca diğerleri calısmazdı. Bir test methodunda
    birden fazla assertion oldugunda her bir assertion ayri ayri raporlanmamıs olur once hata veren assertionu
    düzeltip sonra tekrar calıstırmamız gerekir
     */
    //https://www.bestbuy.com/ adresine gidin farklı test methodlari olusturarak sagidaki testleri yapin
    //sayfa URL'inin "https://www.bestbuy.com/ " ' a esit oldugunu test edin
    //titleTest=>Sayfa baslıgının "Rest" icermedigini (contains) test edin
    //logoTest => BestBuy logosunun goruntulendigini test edin
    static WebDriver driver;
    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        driver.get("https://www.bestbuy.com/");
    }
    @AfterClass
    public static void tearDown(){
        driver.quit();
    }
    @Test
    public void UrlTesti(){
        //sayfa URL'inin "https://www.bestbuy.com/ " ' a esit oldugunu test edin
        String expectedUrl = "https://www.bestbuy.com/";
        String actualUrl = driver.getCurrentUrl();
        Assert.assertEquals(expectedUrl,actualUrl);
    }
    @Test
    public void TitleTesti(){
        //titleTest=>Sayfa baslıgının "Rest" icermedigini (contains) test edin
        String unexpectedTitle = "Rest";
        String actualTitle = driver.getTitle();
        Assert.assertFalse(actualTitle.contains(unexpectedTitle)); //passed

    }
    @Test
    public void LogoTest(){
        WebElement Logo = driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue(Logo.isDisplayed());
    }
}
