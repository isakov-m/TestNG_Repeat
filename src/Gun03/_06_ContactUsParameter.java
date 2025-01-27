package Gun03;
/*
  1- ContactUs a tıklayınız
  2- Mesaj kutusuna en az 10 karakterlik bir mesaj yazınız.
  3- Submit ettikten sonra url deki success yazısını doğrulayınız.
 */

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class _06_ContactUsParameter extends BaseDriver {

    By link = By.linkText("Contact Us");
    By inputMsg = By.id("input-enquiry");
    By submit = By.cssSelector("[type='submit']");
    By contactUs = By.cssSelector("[id='content']>h1");

    @Test
    @Parameters ("mesaj")   // xml deki parametre name i
    public void contactUs(String gelenMesaj){

        WebElement contactUsLink = driver.findElement(link);
        contactUsLink.click();

        WebElement inputMsj = driver.findElement(inputMsg);
        inputMsj.sendKeys(gelenMesaj);

        WebElement btnSubmit = driver.findElement(submit);
        btnSubmit.click();

        WebElement contactUsMsj = driver.findElement(contactUs);

        wait.until(ExpectedConditions.visibilityOfElementLocated(contactUs));
        Assert.assertTrue(driver.getCurrentUrl().contains("contact"));
    }
}
