package Gun04;

    /*
      Senaryo ;
      1- Siteyi açınız.
      2- mac kelimeini göndererek aratınız.
      3- Çıkan sonuçlarda mac kelimesinin geçtiğini doğrulayınız.
      4- aynı işlemi samsung için de yapınız
    */

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class _01_SearchFunctionality extends BaseDriver {

    @Test(parameters = "searchText")
    public void searchFunctionality(String arananKelime){

        By src = By.name("search");
        By urunler = By.cssSelector("[class=caption]>h4");

        WebElement inputSearch = driver.findElement(src);
        inputSearch.sendKeys(arananKelime + Keys.ENTER);

        List<WebElement> captions = driver.findElements(urunler);

        for (WebElement e: captions){
            //System.out.println("e.getText() = " + e.getText());
            Assert.assertTrue(e.getText().toLowerCase().contains(arananKelime),"Aranan kelime bulunamadı");
        }

    }
}
