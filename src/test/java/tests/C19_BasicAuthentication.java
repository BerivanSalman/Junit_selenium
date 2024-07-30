package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C19_BasicAuthentication extends TestBase {
    @Test
    public void basicAuntenticationTest(){
        //API bize sifre ve kullanıcı adını vermelidir ve biz de onu url e girmeliyiz. O zaman bizim onun kullanıcısı oldugumuzu anlar
        //https://testotomasyonu.com/basicauth sayfasina gidin
       // driver.get("https://testotomasyonu.com/basicauth"); boyle yapip gidince password ve username istiyor oralara bilgi girmek icin
        // inspect yapmamız gerekiyor ama sağ click çalısmıyor, inspect yapamıyoruz. Oyüzden asagıda soyledigi gibi gitmeliyiz;
        //asagidaki yontem ve datalari kullanarak authenticationu yapin
        //Html komutu : https;//username:password@URL
        driver.get("https://membername:sunflower@testotomasyonu.com/basicauth");
        //Username: membername
        //password: sunflower
        //basarılı bir sekilde sayfaya girdigini dogrulayın
        WebElement basariliGirisYaziElementi = driver.findElement(By.tagName("h3"));
        String expectedYazi = "Congratulations";
        String actualYazi = basariliGirisYaziElementi.getText();
        Assert.assertTrue(actualYazi.contains(expectedYazi));

    }

}
