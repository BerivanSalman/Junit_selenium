package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C20_iFrame extends TestBase {
    /*
HTML kodlarda kullanilan <iframe> tag’i bir HTML sayfasinin icerisine baska bir
HTML sayfasi gömmek(embed) icin kullanilir. Sayfa icinde sayfa olusturabilirizz bu sekilde.Mesela bir sayfa icinde youtube
bulunması gibi. O sayfanın icinde o sayfanın elemanı gibi gorunebilir ama direkt YOUTUBE un kendi elemanıdır sayfada olan youtube.
Bir uygulama sadece kendi kabiliyetleri degil baskalarının da kabiliyetlerini rahatca kullanabilir bu sekilde
Her iframe icinde yeniden baska html kodları olabilir
COOKIES de iframe icinde olabilir

     */
    @Test
    public void test01(){
        // https://the-internet.herokuapp.com/iframe adresine gidin
        driver.get("https://the-internet.herokuapp.com/iframe");
        // -"An IFrame containing... ." textinin erişilebilir oldugunu test edin ve konsolda yazdirin
        WebElement anIframeYaziElementi = driver.findElement(By.tagName("h3"));
        Assert.assertTrue(anIframeYaziElementi.isEnabled());
        System.out.println(anIframeYaziElementi.getText());
        // -Test box a "Merhaba Dünya" yazin
        /*
        Text boxı locate edip icine yazi gönderdik fakat gitmedi cunku textbox bir iframe 'in icindedir.
        Iframin icinde olan elementlere ulasabilmek icin once
        iframe'e gecis yapmalısınız.  Gecis yapabilmek icin önce iframe i  bir webelement olarak locate etmeliyiz. Driver a tanıtmalıyız ki gecebilsin.
         Iframe yazan html koduna gelio ordan locate edebiliriz
        -sonrada switchTo(); ile iFrame e gecmeliyiz
        iFrame e gecis yapinca driver orda kalır. Yeniden anasayfa ile ilgili bir islem yapmak istersek driveri
        yeniden anasayfaya gecirmemiz gerek
         */
        WebElement iFarmeElementi = driver.findElement(By.id("mce_0_ifr")); //İframe i locate ettik
        driver.switchTo().frame(iFarmeElementi);
        //  simdide ordaki texboxın locate ini alırız yazı göndermek icin
        WebElement textBox = driver.findElement(By.tagName("p"));
        textBox.clear();
        textBox.sendKeys("Merhaba Dünya");
        //Simdi switch to ile  iframe e gecti ve orda kaldı alertte boyle birsey yoktu orda kalmıyordu. iframe e gecis yaptıktan sonra
        //iframe icinde olmayan testlerimizi yapmamız icin normal sayfaya donmemiz gerek
        //Text box'in altında bulunan "Elemental Selenium" linkini textinin gorunur oldugunu dogrulayın ve konsolda yazdirin
        driver.switchTo().defaultContent(); //direkt anasayfaya gecer. Zaten bir tane iframe var burda o yüzden bunu kullandık
        //driver.switchTo().parentFrame() bu da olur. Eger içice birden fazla iFrame varsa bir üstteki iFrame e gecis yapar
        WebElement linkText = driver.findElement(By.xpath("//*[text()='Elemental Selenium']"));
        Assert.assertTrue(linkText.isDisplayed());
        System.out.println(linkText.getText());
    }
}
