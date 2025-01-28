package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chromium.ChromiumDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriverParameter {

    public  WebDriver driver;
    public static WebDriverWait wait;

    @BeforeClass
    @Parameters("browserTipi")
    public void baslangicIslemleri(String browserTipi){
        Logger logger= Logger.getLogger(""); // output yapılan logları al.
        logger.setLevel(Level.SEVERE); // sadece ERROR ları göster

        switch (browserTipi.toLowerCase()){
            case "firefox" :
                driver = new FirefoxDriver();
                break;
            case "edge" :
                driver = new EdgeDriver();
                break;
            case "safari" :
                driver = new SafariDriver();
                break;
            default:
                driver = new ChromeDriver();
        }

        driver.manage().window().maximize(); // Ekranı max yapıyor.
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20)); // 20 sn mühlet: sayfayı yükleme mühlet
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));  // 20 sn mühlet: elementi bulma mühleti
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        loginTest();
    }

    @AfterClass
    public void bitisIslemleri(){
        MyFunc.Bekle(5);
        driver.quit();
    }

    public void loginTest(){

        driver.get("https://opencart.abstracta.us/index.php?route=account/login");
        MyFunc.Bekle(2);

        WebElement email = driver.findElement(By.id("input-email"));
        email.sendKeys("kgs@gmail.com");
        WebElement password = driver.findElement(By.id("input-password"));
        password.sendKeys("Barca");
        WebElement loginBtn = driver.findElement(By.cssSelector("[type='submit']"));
        loginBtn.click();

        MyFunc.Bekle(10);
        //Assert.assertTrue(driver.getTitle().equals("My Account"));

    }
}
