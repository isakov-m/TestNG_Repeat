package Gun01;

import org.testng.annotations.Test;

public class _01_Giris {
//    public static void main(String[] args) {
//        driverIslemleriniYap();
//        websitesiniAc();
//        LoginTestiniYap()
//    }

//      @Test JUnit Test i
//      public void Test1()
//      {
//          driverIslemleriniYap();
//          websitesiniAc();
//          LoginTestiniYap()
//      }

    //Default olarak alfabetik sıraya göre çalışır

    @Test(priority = 1) // default : 0, aynı sevilere yine alfabetik çalışır
    public void driverIslemleriniYap() {
        System.out.println("driverIslemleriniYap yapıldı");
    }

    @Test(priority = 2)
    public void websitesiniAc() {
        System.out.println("websitesiniAc işlemi yapıldı");
    }

    @Test(priority = 3)
    public void loginTestiniYap() {
        System.out.println("loginTestiniYap işlemi yapıldı");
    }

    @Test(priority = 4)
    public void driverKapat() {
        System.out.println("driverKapat işlemi yapıldı");
    }

}
