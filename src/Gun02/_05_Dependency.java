package Gun02;

import org.testng.Assert;
import org.testng.annotations.Test;

public class _05_Dependency {

    // Arabanin haraket sirasi : start, drive, park, stop

    @Test
    public void startCar() {
        System.out.println("startCar");
        //Assert.fail();
    }


    @Test(dependsOnMethods = {"startCar"})          // bu testin calismasi, startCar in hatasiz calismasina bagimli
    public void driveCar() {System.out.println("startCar");}

    @Test(dependsOnMethods = {"driveCar","startCar"})
    public void parkCar() {System.out.println("startCar");}

    // alwaysRun = true, sirasini bekler, bagimliliklari var ama hata cikarsa da yine calistir
    @Test(dependsOnMethods = {"parkCar"},alwaysRun = true)
    public void stopCar() {System.out.println("startCar");}

    // ayni seviyedeki testler icin priority verilebilir
}

// bağımlı testler, direk metodundan çalıştırdığınızda bağımlı olduğu metod zincirinde
// 1 üste kadar otomatik çağırıp çalışabilir.

//Dependency (bağımlılık):Bir testin diğer bir testin sonucuna veya
//belirli bir duruma bağlı olduğu durumları ifade eder.
//Örneğin, bir testin çalışabilmesi için önce başka bir testin başarılı
//bir şekilde tamamlanması gerekebilir. Bu tür senaryolarda TestNG'nin Dependency özelliği devreye girer.
