package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C04_TestNotasyonu {
    //Bir classın icinde birden fazla bagımsız calısan test olur mu?
    //JUnit ile calıstıgımızda class da birden fazla test oldugunda
    //toplu calıstırdıgımızda hangi sıra ile calıstıgını BİLEMEYİZ ve KONTROL EDEMEYİZ
    @Test
    public void testOtomasyonuTest(){ //test methodlari static olmamalıdır
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        //https://testotomasyonu.com sayfasına gidin
        driver.get("https://testotomasyonu.com ");
        ReusableMethods.bekle(2);
        driver.close();
    }
    @Test
    public void wiseQuarterTest(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        //https://wisequarter.com adresine gidin
        driver.get("https://wisequarter.com");
        ReusableMethods.bekle(2);
        driver.close();

    }
    @Test
    public void googleTest(){
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        //https://google.com adresine gidin
        driver.get("https://google.com");
        ReusableMethods.bekle(2);
        driver.close();
    }
}
