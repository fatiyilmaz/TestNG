package techproed.tests.dataprovider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.utilities.DataProviderUtils;
import techproed.utilities.ExcelUtils;

public class Day25_DataProviderTest4 {

    //Bu ornekte, data provider methodumuz Util classdan gelecek

    //musteriVerileri
    @Test(dataProvider = "musteriVerileri",dataProviderClass = DataProviderUtils.class)
    public void musteriVerileriTest(String username, String password ,String sube){
        System.out.println("Username : " + username + ". Password : " + password + ". Sube "+sube);

    }

    //musteriHizmetleriVerileri
    @Test(dataProvider = "musteriHizmetleriVerileri",dataProviderClass = DataProviderUtils.class)
    public void musteriHizmetleriVerileriTest(String username, String password){
        System.out.println("Username : " + username + ". Password : " + password);
    }

    //personelVerileri
    @Test(dataProvider = "personelVerileri",dataProviderClass = DataProviderUtils.class)
    public void personelVerileriTest(String username, String password){
        System.out.println("Username : " + username + ". Password : " + password);
    }

    @Test(dataProvider = "customerData",dataProviderClass = DataProviderUtils.class)
    public void customerDataTest(String email, String password){
        System.out.println("EXCEL DATALARIM");
        System.out.println(email + " | | | "+password);

    }
}
