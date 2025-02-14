package Gun05;
/*
  Senaryo
  1- Siteyi açınız.
  2- Top Menudeki menu elemanlarının olduğunu doğrulayınız.(menuValidation)
  3- Desktops, Laptops & Notebooks, Components, Tablets, Software, Phones & PDAs, Cameras, MP3 Players
 */

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class _05_GenelSoru extends BaseDriver {
    // webden menuyu okuyun, ve 3.siradaki menu ile karsilastirin

    @Test
    void menuValidation(){

        // Beklenen Listemiz
        List<String> menuExpectedList = new ArrayList<>();
        menuExpectedList.add("Desktops");
        menuExpectedList.add("Laptops & Notebooks");
        menuExpectedList.add("Components");
        menuExpectedList.add("Tablets");
        menuExpectedList.add("Software");
        menuExpectedList.add("Phones & PDAs");
        menuExpectedList.add("Cameras");
        menuExpectedList.add("MP3 Players");

        // Web den menu listemizi alalim
        List<WebElement> menuActualList = driver.findElements(By.cssSelector("[class='nav navbar-nav']>li"));

        for (int i = 0; i < menuExpectedList.size(); i++) {
            Assert.assertEquals(menuActualList.get(i).getText(),menuExpectedList.get(i),"Menu beklendigi gibi degil");
        }

        // Assert ya testNG ye ait          , yada JUnit e ait
        // Actual, Expected, Mesaj        , Mesaj, Actual, Expected

    }
}
