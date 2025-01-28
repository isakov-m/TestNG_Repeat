package Gun05;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _01_DataProvider {

    @Test(dataProvider = "datalarim")
    public void searchTest(String aranacakText) {
        System.out.println("aranacakText = " + aranacakText);
    }

    @DataProvider
    Object[] datalarim() {
        Object[] aranacaklar = {"mac", "samsung", "laptop"};

        return aranacaklar;
    }
}
