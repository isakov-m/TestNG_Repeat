package Gun01;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class _02_Annotations {

    @BeforeClass    // class in icindekilerden once calisir
    public void baslangicIslemleri(){
        System.out.println("before classs islemleri calisti");
    }

    @Test // Annotation : metodun turunu ve calisma ozelliklerini belirtir
    public void Test1(){    // Test1 : test metodunun adi
        System.out.println("test 1 calisti");
    }

    @Test // Annotation : metodun turunu ve calisma ozelliklerini belirtir
    public void Test2(){    // Test1 : test metodunun adi
        System.out.println("test 2 calisti");
    }

    @AfterClass // class in icindekilerden sonra calisir
    public void bitisIslemleri(){
        System.out.println("after class islemleri calisti");
    }

}
