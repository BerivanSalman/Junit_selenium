package tests;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class C21_iFrame extends TestBase {
    //COOKies de iframe içinde olabilir
    @Test
    public void test01(){
         //1-http://demo.guru99.com/test/guru99home/ adresine gidin
        driver.get("http://demo.guru99.com/test/guru99home/");
        //2-sayfadaki iframe sayisini bulunuz
        //Once list olustururuz birden fazla oldugu icin
        List<WebElement> iframeList = driver.findElements(By.tagName("iframe"));
        System.out.println("Sayfadaki iframe sayisi: "+iframeList.size());
        //3-ilk iframedeki  (Youtube) play butonuna basiniz (Bu da iframe icindedir)
        //Once iframe i locate ediyoruz
        WebElement playIframe = driver.findElement(By.xpath("(//iframe)[2]"));
        driver.switchTo().frame(playIframe);
        driver.findElement(By.xpath("//button[@aria-label=\"Play\"]")).click();
        //4-ilk iframe den cıkıp ana sayfaya donunun
        driver.switchTo().defaultContent();
    }
}
