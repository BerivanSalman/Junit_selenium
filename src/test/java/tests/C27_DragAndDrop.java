package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C27_DragAndDrop extends TestBase {
    @Test
    public void Test01(){
        //1- https://testotomasyonu.com/droppable adresine gidelim
        driver.get("https://testotomasyonu.com/droppable");

        //2- Accept bolumunde “Acceptable” butonunu tutup “Drop here” kutusunun ustune birakalim
        WebElement dragElementi = driver.findElement(By.id("draggable2"));
        WebElement dropElementi = driver.findElement(By.id("droppable2"));
        Actions actions = new Actions(driver);
         ReusableMethods.bekle(2); //bekleme yapmamız sart
        System.out.println("Tasımadan once = "+ dropElementi.getText());
        actions.dragAndDrop(dragElementi,dropElementi).perform();
        System.out.println("Tasıdıktan sonra = "+ dropElementi.getText());

        //3- “Drop here” yazisi yerine “Dropped!” oldugunu test edin
       WebElement droppedElement = driver.findElement(By.xpath("//*[text()='Dropped!']"));
        String expectedElement = "Dropped!";
        String actualElement = droppedElement.getText();
        Assert.assertEquals(expectedElement,actualElement);
        //4- Sayfayi yenileyin
        driver.navigate().refresh(); //sayfayi yeniledigimiz icin StaleElementException firlatir bize
        ReusableMethods.bekle(2);
        //5- “Not Acceptable” butonunu tutup “Drop Here” kutusunun ustune birakalim
        WebElement dragNotAcceptable = driver.findElement(By.id("draggable-nonvalid2"));
        dropElementi = driver.findElement(By.id("droppable2")); //yukarida zaten tanimlamistik bayatladıgı icin tekrar buraya koyuyoruz
        actions.dragAndDrop(dragNotAcceptable,dropElementi).perform();


    }

}
