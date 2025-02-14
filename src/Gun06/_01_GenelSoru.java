package Gun06;
/*
  Senaryo;
  1- Brands menusune gidiniz.
  2- Burada her bir markanın üstünde yer alan harf ile başladığını doğrulayınız
*/

import Utility.BaseDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class _01_GenelSoru extends BaseDriver {

    @Test
    void test1(){

        WebElement brands = driver.findElement(By.linkText("Brands"));
        brands.click();

        List<WebElement> harfler = driver.findElements(By.cssSelector("[id='content']>h2"));    // harfler
        List<WebElement> markalarSatirlari = driver.findElements(By.cssSelector("[id='content']>div"));    // markaSatirlari

        for (int i = 0; i < harfler.size(); i++) {
            List<WebElement> markalar = markalarSatirlari.get(i).findElements(By.tagName("div"));
            //By.cssSelector("[class='col-sm-3']")
            // element içinde element aranırken xpath kullanılmaz, çünkü o tüm sayafya bakar.

            for(WebElement marka: markalar) {
                System.out.println(harfler.get(i).getText()+" "+marka.getText().charAt(0)+" "+marka.getText() );
                Assert.assertEquals(harfler.get(i).getText().charAt(0), marka.getText().charAt(0));
            }
        }

        // TODO: isteyenler aynı soruyu  https://www.ebay.com/n/all-brands bu siteden testedebilir.

    }
}
