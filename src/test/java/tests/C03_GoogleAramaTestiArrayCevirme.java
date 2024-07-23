package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_GoogleAramaTestiArrayCevirme {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        //https://www.google.com/ adresine gidin
        driver.get("https://www.google.com/");
        //Sayfa baslıgının "Google" ifadesi icerdigini test edin
        WebElement googleText= driver.findElement(By.className("lnXdpd"));
        if (googleText.equals("Google")){
            System.out.println("Google yazisi testi passed");
        }else {
            System.out.println("Google yazisi testi passed");
        }
        //Arama cubuguna Nutella yazıp aratın
        WebElement NutellaArama = driver.findElement(By.className("gLFyf"));
        NutellaArama.sendKeys("Nutella"+ Keys.ENTER);
        //Bulunan sonuc sayısını yazdırın
        WebElement elementSayisi = driver.findElement(By.id("result-stats"));
        System.out.println(elementSayisi.getText());
        //sonuc sayisinin 10 milyondan fazla oldugunu test edin
        String elemanSayisiStr = elementSayisi.getText(); //Yaklaşık 186.000.000 sonuç bulundu (0,35 saniye)
        //once array e ceviriyoruz;
        String[] sonucYazisiArr = elemanSayisiStr.split(" "); //indexlere ayırdık
        elemanSayisiStr = sonucYazisiArr[1];//186.000.000
        //simdi de integera cevircez once noktalardan kurtulcaz;
        //elemanSayisiStr =elemanSayisiStr.replace(".",""); ya da
        elemanSayisiStr =elemanSayisiStr.replaceAll("\\D","");//"186000000"
        //şimdi bunu int e cevircez;
        int sonucSayisiInt = Integer.parseInt(elemanSayisiStr);
        if (sonucSayisiInt>10000000) {
            System.out.println("Test Passed");
        }else {
            System.out.println("Test failed");
        }
        driver.close();
        //sayfayı kapatın
    }
}
