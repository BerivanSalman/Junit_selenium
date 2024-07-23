package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_AramaTesti {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //https://testotomasyonu.com sayfasına gidin
        driver.get("https://testotomasyonu.com");
        //arama kutusunu locate edelim VE phone" ile arama yapalım
        WebElement aramaKutusu = driver.findElement(By.id("global-search"));
        aramaKutusu.sendKeys("phone" );
        Thread.sleep(2000);
        aramaKutusu.submit();
        //Bulunan sonuc sayisini yazdiralim
        WebElement sonucSayisi = driver.findElement(By.xpath("//*[@class='product-count-text']"));
        System.out.println(sonucSayisi.getText());
        //Urunun stokta oldugunu test edin
        String actualSonucStr = sonucSayisi.getText().replaceAll("\\D","");
        int actualSonucInt = Integer.parseInt(actualSonucStr);
        if (actualSonucInt>0) {
            System.out.println("Urun stokta");
        }
        else {
            System.out.println("Urun stokta yok");
        }

        //İlk ürünü tıklayalım
    }



}

