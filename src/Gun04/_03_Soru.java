package Gun04;
/*
   bu örneği istediğin aşamada sorabilirsin, ister burda ister paralel testten sonra
   Senaryo
   1- Siteye gidiniz
   2- Specials tiklayiniz
   3- Cikan urun lerde (bütün ürünlerde indirim var mı, eski fiyat yeni fiyat var mı)
   4- Yukarıdaki işlemden sonra her ürünün önceki fiyatının şu andaki fiyattan
      yüksek olduğunu doğrulayınız.
   5- Yukarıdaki işlemi 2 farklı browserda ve paralel şekilde test ediniz.
*/

import Utility.BaseDriver;
import Utility.BaseDriverParameter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import java.util.List;

public class _03_Soru extends BaseDriverParameter {
    By link = By.linkText("Specials");
    By urunler = By.cssSelector("[class=caption]>h4");
    By newPrc = By.className("price-new");
    By oldPrc = By.className("price-old");

    @Test
    void specials(){

        WebElement specials = driver.findElement(link);
        specials.click();

        List<WebElement> products = driver.findElements(urunler);

        List<WebElement> newPrices = driver.findElements(newPrc);
        List<WebElement> oldPrices = driver.findElements(oldPrc);

        Assert.assertTrue(newPrices.size()==oldPrices.size(),"hepsinde indirim bulunamadi ");


        for (int i = 0; i < newPrices.size(); i++) {    // 2 kere donecek
            double newPrice = Double.parseDouble(newPrices.get(i).getText().replaceAll("[^0-9.,]","")); // $80 $90
            double oldPrice = Double.parseDouble(oldPrices.get(i).getText().replaceAll("[^0-9.,]","")); // $100 $100

            System.out.println(newPrice+" "+oldPrice);
            Assert.assertTrue(newPrice<oldPrice, "Yeni fiyat eski fiyattan kucuk degil");
        }
    }
}
