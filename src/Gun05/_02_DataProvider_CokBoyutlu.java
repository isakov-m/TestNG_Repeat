package Gun05;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class _02_DataProvider_CokBoyutlu {

    @Test(dataProvider = "UserData")
    public void userTest(String username, String password){
        // username, password
        System.out.println(username+" "+password);
    }

    @DataProvider
    public Object [][] UserData(){
        Object[][] data = {
                {"ihsan","122334"},
                {"sokol","rustemi5"},
                {"zeynep","zeynep111"},
                {"serkan","serkan500"},
        };

        return data;

    }


}
