package Gun02;

import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

public class _02_Ornek extends BaseDriver {


    @Test
    public void loginTest() {
        System.out.println("testim calisti");

        driver.get("https://opencart.abstracta.us/index.php?route=account/login");
        MyFunc.Bekle(2);

        WebElement email = driver.findElement(By.id("input-email"));
        email.sendKeys("kg@mail.ru");
        WebElement password = driver.findElement(By.id("input-password"));
        password.sendKeys("Barca");
        WebElement loginBtn = driver.findElement(By.cssSelector("[type='submit']"));
        loginBtn.click();

        Assert.assertTrue(driver.getTitle().equals("My Account"));

    }
}
