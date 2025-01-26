package Gun01;

import org.testng.annotations.*;

 /*
        @BeforeClass      -->   Class ın başında çalışacak   (driver işlemleri)

           @BeforeMethod  -->   Her metoddan(test metodları) önce çalışacak
               @Test      -->   testlerin çalıştığı metodlar
           @AfterMethod   -->   Her metoddan sonra çalışacak

           @BeforeMethod  -->   Her metoddan(test metodları) önce çalışacak
               @Test      -->   testlerin çalıştığı metodlar
           @AfterMethod   -->   Her metoddan sonra çalışacak

        @AfterClass       -->   Class ın çalışmasının sonunda çalışacak (driver kapat)

beforeClass

beforeMethod
test1
afterMethod

beforeMethod
test2
afterMethod

afterClass
     */

public class _03_Annotations {

    @Test
    public void Test1(){System.out.println("test 1 calisti");}

    @Test
    public void Test2(){System.out.println("test 2 calisti");}

    @BeforeClass
    public void beforeClass() {System.out.println("beforeClass calisti");}

    @AfterClass
    public void afterClass() {System.out.println("afterClass calisti");}

    @BeforeMethod
    public void beforeMethod() {System.out.println("beforeMethod calisti");}

    @AfterMethod
    public void afterMethod() {System.out.println("afterMethod calisti");}

}
