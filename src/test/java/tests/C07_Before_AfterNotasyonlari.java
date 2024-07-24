package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.AssertionFailedError;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C07_Before_AfterNotasyonlari {
    WebDriver driver;

    @Before
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    @After
    public void teardown() {
        driver.quit();
    }

    @Test
    public void phoneTesti() {
        // https://testotomasyonu.com sayfasina gidin
        driver.get("https://testotomasyonu.com");
        // phone icin arama yapın
        WebElement phone = driver.findElement(By.xpath("//input[@id='global-search']"));
        phone.sendKeys("phone" + Keys.ENTER);
        //arama sonucunda urun bulunup bulunmadıgını test edin
        WebElement phoneSayisi = driver.findElement(By.className("product-count-text"));
        String elemansayisiStr = phoneSayisi.getText().substring(0, 1);
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
    public void shoesTest() {
        driver.get("https://testotomasyonu.com");
        WebElement phone = driver.findElement(By.xpath("//input[@id='global-search']"));
        phone.sendKeys("shoes" + Keys.ENTER);
        WebElement shoesSayisi = driver.findElement(By.className("product-count-text"));
        String elemansayisiStr = shoesSayisi.getText().substring(0, 1);
        int elemanSayisiInt = Integer.parseInt(elemansayisiStr);
        if (elemanSayisiInt > 0) {
            System.out.println("Shoes Test Passed");
        } else {
            System.out.println("Shoes Test Failed");
            throw new AssertionFailedError();
        }
        ReusableMethods.bekle(2);
    }

    @Test
    public void dressTest() {
        driver.get("https://testotomasyonu.com");
        WebElement phone = driver.findElement(By.xpath("//input[@id='global-search']"));
        phone.sendKeys("dress" + Keys.ENTER);
        WebElement dressSayisi = driver.findElement(By.className("product-count-text"));
        String elemansayisiStr = dressSayisi.getText().substring(0, 1);
        int elemanSayisiInt = Integer.parseInt(elemansayisiStr);
        if (elemanSayisiInt > 0) {
            System.out.println("Dress Test Passed");
        } else {
            System.out.println("Dress Test Failed");
            throw new AssertionFailedError();
        }
        ReusableMethods.bekle(2);
    }
}
