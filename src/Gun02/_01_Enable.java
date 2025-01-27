package Gun02;

import Utility.MyFunc;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class _01_Enable {

    @Test
    public void test1() {System.out.println("test 1 calisti");}

    @Test(enabled = false)
    public void test2() {System.out.println("test 2 calisti");}

    @Test
    public void test3() {System.out.println("test 3 calisti");}

    public static WebDriver driver; // SingletonDriver method
    public static WebDriverWait wait;

    @BeforeClass
    public void baslangicIslemleri(){

        System.out.println("baslangicIslemleri çalıştı");

        Logger logger= Logger.getLogger(""); // output yapılan logları al.
        logger.setLevel(Level.SEVERE); // sadece ERROR ları göster

        driver = new ChromeDriver(); // jenkins deyken : sen head olmadan yani hafızada çalış
        //driver.manage().window().maximize(); // Ekranı max yapıyor.
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20)); // 20 sn mühlet: sayfayı yükleme mühlet
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));  // 20 sn mühlet: elementi bulma mühleti
        wait = new WebDriverWait(driver, Duration.ofSeconds(20));
    }

    @AfterClass
    public void bitisIslemleri(){
        System.out.println("bitisIslemleri çalıştı");
        MyFunc.Bekle(5);
        driver.quit();
    }
}
