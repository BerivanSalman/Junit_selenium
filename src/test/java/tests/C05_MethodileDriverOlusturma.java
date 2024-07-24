package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.ReusableMethods;

import java.time.Duration;

public class C05_MethodileDriverOlusturma {
    WebDriver driver; //bunu classın icinde olusturduk tum classda kullanabilelim diye
    public void driverOlustur(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
    }
    @Test
    public void wisequarterest(){
        driverOlustur(); //method call yaptık
        //https://testotomasyonu.com sayfasına gidin
        driver.get("https://testotomasyonu.com ");
        ReusableMethods.bekle(2);
        driver.close();
    }
    @Test
    public void testOtomasyonuTest(){
        driverOlustur();
        //https://testotomasyonu.com sayfasına gidin
        driver.get("https://testotomasyonu.com ");
        ReusableMethods.bekle(2);
        driver.close();
    }
    @Test
    public void googleTest(){
        driverOlustur();
        //https://google.com adresine gidin
        driver.get("https://google.com");
        ReusableMethods.bekle(2);
        driver.quit();
    }
}
