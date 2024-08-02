package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C25_Actions_ContextClick extends TestBase {
    @Test
    public void sagClickTesti(){
        //https://testotomasyonu.com/click adresine gidin
        driver.get("https://testotomasyonu.com/click");
        ReusableMethods.bekle(2); //bazen java scriptlerde senkronizasyon sorunu yasayabiliriz
        // o yuzden boyle bekletme yapmak sorunu cozer

        //DGI Drones üzerine sağ click yapin.
        Actions actions = new Actions(driver);
        WebElement drones = driver.findElement(By.id("pic2_thumb")); //Gidip o bölgede locate aliriz ve buraya yazariz
        actions.contextClick(drones).perform();
        ReusableMethods.bekle(3);

        //Alette cıkan yazının "Tebrikler!... Sağ click yaptiniz." oldugunu test edin
        String expectedAlertText = "Tebrikler!... Sağ click yaptınız.";
        String actualAlertText = driver.switchTo().alert().getText();//aletteki yazıyı almamız icin alerte gecis yapmalıyız
        Assert.assertEquals(expectedAlertText,actualAlertText);
        //Tamam diyerek alerti kapatın. Yine alerte geceriz
        driver.switchTo().alert().accept();

    }

}
