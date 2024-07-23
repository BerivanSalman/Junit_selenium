package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.time.Duration;

public class C02_WebappTesti {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().window().maximize();
        //http://zero.webappsecurity.com sayfasına gidin
        driver.get("http://zero.webappsecurity.com");
        //Signin butonuna tıklayın
        driver.findElement(By.id("signin_button")).click();
        //Login alanına "username" yazdırın
        //Password alanına "password" yazdırın
        //Sign in butonuna tıklayın
        Actions actions = new Actions(driver);
        WebElement signin = driver.findElement(By.id("user_login"));
        actions.contextClick(signin).sendKeys("username")
                .sendKeys(Keys.TAB).sendKeys("password")
                .sendKeys(Keys.TAB).perform();
        WebElement singIn = driver.findElement(By.xpath("//*[@type='submit']"));
        singIn.click();
        driver.navigate().back();
        //Online Banking menusunden Pay Bills sayfasina gidin
        driver.findElement(By.id("onlineBankingMenu")).click();
        driver.findElement(By.id("pay_bills_link")).click();

    }
}
