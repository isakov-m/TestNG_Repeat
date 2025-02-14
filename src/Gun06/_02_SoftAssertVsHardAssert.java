package Gun06;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class _02_SoftAssertVsHardAssert {
    @Test
    public void hardAssert() {
        String s1 = "Merhaba";

        System.out.println("Assert öncesi");
        Assert.assertEquals("Merhaba123", s1, "Oluşanla beklenen aynı değil"); // hata oluştuğunda program kırılır
        System.out.println("Assert sonrası");

    }

    @Test
    public void softAssert() {
        String strHomePage = "www.facebook.com/homepage";
        String strCartPage = "www.facebook.com/cartpage";
        String strEditAccount = "www.facebook.com/editaccountpage";

        SoftAssert _softAssert=new SoftAssert();

        _softAssert.assertEquals("www.facebook.com/homepage", strHomePage); // pass
        System.out.println("Assert 1");

        _softAssert.assertEquals("www.facebook.com/profile", strCartPage,"oluşanla beklenen aynı olmadı"); // fail
        System.out.println("Assert 2");

        _softAssert.assertEquals("www.facebook.com/settings", strEditAccount); // fail
        System.out.println("Assert 3");

        _softAssert.assertAll(); // bütün assert sonuçlarını işleme koyuyor.
        System.out.println("soft assertAll: aktiflik sonrası");
        // bu bölüm assertAll dan sonra olduğu ve öncesinde hata oluştuğu için ekrana çıkamayacak
    }
}
