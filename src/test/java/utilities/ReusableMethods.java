package utilities;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;

import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class ReusableMethods {
    public static List<String> stringListeDonustur(List<WebElement> elementlerListesi) {
        List<String> stringlerListesi = new ArrayList<>();
        for (WebElement each : elementlerListesi
        ) {
            stringlerListesi.add(each.getText());
        }
        return stringlerListesi;

    }

    public static void bekle(int saniye) {
        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static void istenenelemanascrollyapma(WebDriver driver, WebElement scrollyapılacakelemet) {
        JavascriptExecutor javascriptExecutor = (JavascriptExecutor) driver;
        javascriptExecutor.executeScript("arguments[0].scrollIntoViewIfNeeded(true);", scrollyapılacakelemet);
    }

    public static WebDriver titleIleSayfaDegistir(WebDriver driver, String hedefSayfaTitle) {

        Set<String> tumWindowHandleSeti = driver.getWindowHandles();
        for (String each : tumWindowHandleSeti
        ) {
            String eachTitle = driver.switchTo().window(each).getTitle();
            if (eachTitle.equals(hedefSayfaTitle)) {
                return driver;
            }
        }
        return driver;


    }

    public static void tumSayfaTakeScreenshot(WebDriver driver) {
        // tum sayfanin fotografini cekip kaydedin

        // 1.adim tss objesi olustur

        TakesScreenshot tss = (TakesScreenshot) driver;

        // 2.adim fotografi kaydedecegimiz dosya yolu ile bir File olusturalim
        //   her yeni kaydedilen resmin oncekinin ustune kaydedilmemesi icin
        //   kaydedilecek dosya yolunu dinamik yapabiliriz
        //   dinamik yapmak icin dosya yoluna tarih etiketi ekleyelim

        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter istenenFormat = DateTimeFormatter.ofPattern("yyMMddHHmmss");
        String dinamikDosyaYolu = "target/screenshots/tumSayfaScreenshot" +
                localDateTime.format(istenenFormat) +
                ".jpg";

        File tumSayfaScreenshot = new File(dinamikDosyaYolu);

        // 3.adim tss objesini kullanarak fotografi cekip, gecici bir dosyaya kaydedelim

        File geciciDosya = tss.getScreenshotAs(OutputType.FILE);

        // 4.adim : gecici dosyayi, asil dosyaya kopyalayalim

        try {
            FileUtils.copyFile(geciciDosya, tumSayfaScreenshot);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ReusableMethods.bekle(5);
    }

    public static void tumSayfaTakeScreenshot(String testAdi, WebDriver driver) {
        // tum sayfanin fotografini cekip kaydedin

        // 1.adim tss objesi olustur

        TakesScreenshot tss = (TakesScreenshot) driver;

        // 2.adim fotografi kaydedecegimiz dosya yolu ile bir File olusturalim
        //   her yeni kaydedilen resmin oncekinin ustune kaydedilmemesi icin
        //   kaydedilecek dosya yolunu dinamik yapabiliriz
        //   dinamik yapmak icin dosya yoluna tarih etiketi ekleyelim

        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter istenenFormat = DateTimeFormatter.ofPattern("yyMMddHHmmss");
        String dinamikDosyaYolu = "target/screenshots/" +
                testAdi
                +
                localDateTime.format(istenenFormat) +
                ".jpg";

        File tumSayfaScreenshot = new File(dinamikDosyaYolu);

        // 3.adim tss objesini kullanarak fotografi cekip, gecici bir dosyaya kaydedelim

        File geciciDosya = tss.getScreenshotAs(OutputType.FILE);

        // 4.adim : gecici dosyayi, asil dosyaya kopyalayalim

        try {
            FileUtils.copyFile(geciciDosya, tumSayfaScreenshot);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        ReusableMethods.bekle(5);
    }

    public static void istenenWebelementScreenshot(WebElement istenenWebelement) {

        // 1.adim screenshot alacagimiz webelementi locate et

        // 2.adim scrennshot'i kaydedecegimiz file'i olusturalim
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter istenenFormat = DateTimeFormatter.ofPattern("yyMMddHHmmss");
        String dinamikDosyaYolu = "target/screenshots/istenenWebelementScreenshot" +
                localDateTime.format(istenenFormat) +
                ".jpg";


        File istenenWebelementScreenshot = new File(dinamikDosyaYolu);

        // 3.adim webelement uzerinden screenshot'i alip gecici bir dosyaya kaydedin

        File geciciDosya = istenenWebelement.getScreenshotAs(OutputType.FILE);

        // 4.adim gecici dosyayi asil dosyaya kopyalayalim

        try {
            FileUtils.copyFile(geciciDosya, istenenWebelementScreenshot);
        } catch (IOException e) {
            System.out.println("Screenshot kopyalanamadi");
            throw new RuntimeException(e);
        }
    }
}

