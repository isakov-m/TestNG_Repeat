package Utility;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class BaseDriverParameter {

    public static WebDriver driver; // SingletonDriver method
    public static WebDriverWait wait;

    @BeforeClass
    @Parameters("browserTipi")
    public void baslangicIslemleri(String browserTipi){
        Logger logger= Logger.getLogger(""); // output yapılan logları al.
        logger.setLevel(Level.SEVERE); // sadece ERROR ları göster

        if (browserTipi.equals("chrome"))
        driver = new ChromeDriver(); // jenkins deyken : sen head olmadan yani hafızada çalış

        if (browserTipi.equals("firefox"))
            driver = new FirefoxDriver();

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
