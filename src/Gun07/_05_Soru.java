package Gun07;

/*
   Senaryo :
   1- Siteyi açınız.
   2- Sitede "ipod" kelimesini aratınız
   3- Çıkan sonuçlardan random birini sepete atınız.
   4- Shopping Chart a tıklatınız.
   5- Seçilen ürünün sepette olduğunu doğrulayınız.
   6- POM ile çözünüz.
 */

import Gun06._04_PlaceOrder_Elementleri;
import Utility.BaseDriver;
import Utility.MyFunc;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class _05_Soru extends BaseDriver {

    @Test
    public void addToCart() {

        _04_PlaceOrder_Elementleri poe=new _04_PlaceOrder_Elementleri();
        _03_WishList_Elements wle=new _03_WishList_Elements();
        poe.searchBox.sendKeys("ipod" + Keys.ENTER);

        int randomSecim= MyFunc.randomGenerator(wle.productList.size()); // random bir sayı üretildi
        String cartItemText=wle.productList.get(randomSecim).getText(); // random daki ürünün adı alındı

        wle.addToChart.get(randomSecim).click(); // ilgili Random ürünün wish butonuna tıklandı
        wle.shoppingCart.click();

        boolean bulundu=MyFunc.listContainsString(wle.wishList, cartItemText);
        Assert.assertTrue(bulundu,"Sepet Listesinde aranan ürün bulunamadı");
    }
}
