package Gun05;

import Utility.BaseDriver;
import Utility.BaseDriverParameter;
import Utility.MyFunc;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

/**
 * Daha önceki derslerde yaptğımız Search fonksiyonunu
 * mac,ipod ve samsung için Dataprovider ile yapınız.
 */

public class _04_Soru extends BaseDriverParameter {

    @Test(dataProvider = "getData")
    void search(String aranacak){
        WebElement search = driver.findElement(By.name("search"));
        search.clear();
        search.sendKeys(aranacak+ Keys.ENTER);

        List<WebElement> captions = driver.findElements(By.cssSelector("[class='caption']>h4"));

        for (WebElement e: captions){
            //System.out.println("e.getText() = " + e.getText());
            Assert.assertTrue(e.getText().toLowerCase().contains(aranacak), "Aranan kelime bulunamadi");
        }
    }

    @DataProvider
    Object[] getData(){
        Object [] data = {"mac", "samsung", "ipod"};

        return data;
    }
}
