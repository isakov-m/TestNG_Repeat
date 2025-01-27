package Gun03;

/*
  Senaryo
  1- Siteyi açınız.
  2- Edit Account sayfasına ulaşınız.
  3- Ad ve soyadı değiştirip tekrar kaydedidiniz.
 */

import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class _01_Ornek extends BaseDriver {

    By editAccount = By.xpath("(//a[text()='Edit Account'])[1]");
    By firstName = By.name("firstname");
    By lastName = By.name("lastname");
    By con = By.cssSelector("input[type='submit']");
    By suc = By.className("alert-success");

    @Test
    public void editAccount(){

        WebElement edit = driver.findElement(editAccount);
        edit.click();

        WebElement txtFirstName = driver.findElement(firstName);
        txtFirstName.clear();
        txtFirstName.sendKeys("Lamine");

        WebElement txtLastName = driver.findElement(lastName);
        txtLastName.clear();
        txtLastName.sendKeys("Yamal");

        WebElement btnSubmit = driver.findElement(con);
        btnSubmit.click();

        MyFunc.successMessageValidation();
    }
}
