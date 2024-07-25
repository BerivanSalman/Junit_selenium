package tests;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.util.List;

import static tests.C08_BeforeClass_AfterClass.driver;

public class C14_DropdownMenu extends TestBase {
    @Test
    //Her acılan menu dropdown menu değildir.
    // Eger acılır menu select tag ı ile olusturulmussa ve secenekleri de optionla olusturulmussa dropdown menudur
    // Dropdown menuler 'select' ile ve secilebilecek opsiyonlar da "option" tagi ile olusturulmustur.
    //İlk adım Webelement ile locate etmektir
    //İkinci adim select classından bir obje olusturmalıyız ve new Select() icine yukarda olusturulan webelement konulmalıdır
    // selectByIndex, selectByValue ya da selectByVisibleText kullanmalıyız duruma gore. index 0 dan baslar
    public void dropdownTesti(){
        //● https://testotomasyonu.com/form adresine gidin.
        driver.get("https://testotomasyonu.com/form");
        //	1.Dogum tarihi gun seçeneğinden index kullanarak 5’i secin
        // - ilk adim : kullanacagimiz ddm locate edip kaydedelim
        //locate alırken select olmasına dikkat edelim
        WebElement dogumGunuDdm = driver.findElement(By.xpath("(//select[@class='form-control'])[1]"));
        // - ikinci adim : bir select objesi olusturalim
        //   parametre olarak locate etttigimiz ddm'yu yazalim
        Select selectGun = new Select(dogumGunuDdm);
        // -ucuncu adim : olusturdugumuz select objesi ile istenen islemleri yapin
        selectGun.selectByIndex(5);
        //	2. Dogum tarihi ay seçeneğinden visibleText kullanarak Nisan’i secin
        WebElement ayDdm = driver.findElement(By.xpath("(//select[@class='form-control'])[2]"));
        Select selectAy = new Select(ayDdm);
        selectAy.selectByVisibleText("Nisan");
        //	3. Dogum tarihi yil seçeneğinden visible text kullanarak 1990’i secin
        WebElement yilDdm = driver.findElement(By.xpath("(//select[@class='form-control'])[3]"));
        Select selectYil= new Select(yilDdm);
        selectYil.selectByVisibleText("1990");

        //  4. Secilen degerleri konsolda yazdirin
        //System.out.println(selectGun); selectGun bir obje oldugu icin referansı yazdırır
        // Dropdown menude secim yaptiktan sonra yapilan secimi yazdirmak isterseniz
        // .getFirstSelectedOption().getText() kullaniriz
        //getFirstSelectedOption() bir Webelement getirir getText diyerek o Webelementteki yaziyi alırız
        System.out.println("Secilen gun: "+selectGun.getFirstSelectedOption().getText() +
                "\nSecilen ay: "+ selectAy.getFirstSelectedOption().getText()+
                "\nSecilen yil: "+selectYil.getFirstSelectedOption().getText());

        //	5. Ay dropdown menüdeki tum değerleri(value) yazdırın getOptions diyerek List<Weblement> icinde bir list dondurur bize
        List<WebElement> ayOpsiyonlariElementList = selectAy.getOptions();
        System.out.println(ReusableMethods.stringListeDonustur(ayOpsiyonlariElementList));
        // [Ay, Ocak, Şubat, Mart, Nisan, Mayıs, Haziran, Temmuz, Ağustos, Eylül, Ekim, Kasım, Aralık]

        //	6. Ay Dropdown menusunun boyutunun 30 olduğunu test edin
        Assert.assertEquals(30,ayOpsiyonlariElementList.size());

    }
    }
