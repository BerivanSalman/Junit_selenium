package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C17_FacebookQuestion extends TestBase {
    @Test
    public void FacebookTest(){
        // Verilen web sayfasına gidin https://facebook.com
        driver.get("https://facebook.com");
        // Create an account buton’una basin
        driver.findElement(By.xpath("//*[@data-testid='open-registration-form-button']")).click();
        // Radio button elementlerini locate edin ve size uygun olani secin
        WebElement femaleRadioButton = driver.findElement(By.xpath("//input[@value=\"1\"]"));
       WebElement maleRadioButton =  driver.findElement(By.xpath("//input[@value=\"2\"]"));
        WebElement customRadioButton = driver.findElement(By.xpath("//input[@value=\"-1\"]"));
        femaleRadioButton.click();
        //Sectiginiz radio button’un seçili, ötekilerin seçili olmadigini test edin
        Assert.assertTrue(femaleRadioButton.isSelected());
        Assert.assertFalse(maleRadioButton.isSelected());
        Assert.assertFalse(customRadioButton.isSelected());

    }
}
