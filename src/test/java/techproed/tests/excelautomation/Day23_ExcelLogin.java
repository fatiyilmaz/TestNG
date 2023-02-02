package techproed.tests.excelautomation;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import techproed.pages.BlueRentalHomePage;
import techproed.pages.BlueRentalLoginPage;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;
import techproed.utilities.ExcelUtils;
import techproed.utilities.ReusableMethods;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public class Day23_ExcelLogin {

    BlueRentalHomePage blueRentalHomePage;
    BlueRentalLoginPage blueRentalLoginPage;
    ExcelUtils excelUtils;
    List<Map<String, String>> excelDatalari;


    //Bu method login sayfasina gitmek icin kullanilacak
    public void login(){
        //Sayfaya git
        Driver.getDriver().get(ConfigReader.getProperty("app_url"));

        //home page logine tikla
        blueRentalHomePage = new BlueRentalHomePage();
        blueRentalLoginPage = new BlueRentalLoginPage();

        //SADECE ILK GIRIS
        //loginLink butonu sadece ilk girisde sayfada gorunur
        //ikinci ve ucuncu girislerde sayfada gorunmeyeceginden NOSUCHELEMENTEXCEPTION alinir
        //Biz bu exception i try catch kullanarak yakalariz ve test cases calismaya devam eder
        try {
            blueRentalHomePage.loginLink.click();
            ReusableMethods.waitFor(1);//1 saniye bekle
            //LOGIN SAYFASINDAYIZ
        }catch (Exception e){
        }

        //SONRAKI GIRISLER
        try {
            //kullanici ID ye tikla   ---->> try catch
            blueRentalHomePage.userID.click();
            ReusableMethods.waitFor(1);
            //Logout linkine tikla    ---->> try catch
            blueRentalHomePage.logOutLink.click();
            ReusableMethods.waitFor(1);
            //OK e tikla              ---->> try catch
            blueRentalHomePage.OK.click();
            ReusableMethods.waitFor(1);
            //home page logine tikla  ---->> try catch
            blueRentalHomePage.loginLink.click();
            ReusableMethods.waitFor(1);
        }catch (Exception e){
        }

    }

//    @Test
//    public void test () {
//        String path = "./src/test/java/resources/mysmoketestdata.xlsx";
////        ./ ONCEKI TUM DOSYALARI ICER. RELATIVE PATH.
//        String sayfa = "customer_info";
//        excelUtils = new ExcelUtils(path, sayfa);
//        excelUtils.setCellData("team07", 1, 2);
//        System.out.println(excelUtils.rowCount());
//        System.out.println(excelUtils.columnCount());
//        System.out.println(excelUtils.getCellData(3, 1));
//        System.out.println(excelUtils.getColumnsNames());
//    }

    @Test
    public void customerLogin() throws IOException {
        //1.SAYFA YOLU
        String path = "./src/test/java/resources/mysmoketestdata.xlsx";
//      ./ ONCEKI TUM DOSYALARI ICER. RELATIVE PATH.

        //2.SAYFA ISMI
        String sayfa = "customer_info";

//      DATALARI EXCEL UTILS METHODLARINI KULLANRAK BU SINIFA ALACAZ
        excelUtils = new ExcelUtils(path,sayfa);

//      EXCEL DATALARINI getDataList METHODU ILE CEKELIM
        excelDatalari = excelUtils.getDataList();

//       LOOP KULLANARAK DATALARI TEK TEK TEST CASEDE KULAN
        for (Map<String,String> data : excelDatalari){
            ReusableMethods.waitFor(1);
            login();//Her loop da Login sayfasinda goturecek
            //kullanici adini
            ReusableMethods.waitFor(1);
            blueRentalLoginPage.emailBox.sendKeys(data.get("username"));
            //kullanici sifresini
            ReusableMethods.waitFor(1);
            blueRentalLoginPage.passwordBox.sendKeys(data.get("password"));
            //login butonuna tikla
            ReusableMethods.waitFor(1);
            blueRentalLoginPage.loginButton.click();
            ReusableMethods.waitFor(1);
            //Giris isleminin basarili oldugunu gostermek icin assertion yaptik
            ReusableMethods.verifyElementDisplayed(blueRentalHomePage.userID);
            ReusableMethods.waitFor(1);
            //Her bir girisden sonra ekran goruntusu aldik
            ReusableMethods.getScreenshot("EkranGoruntusu");
        }
    }

    @AfterMethod
    public void tearDown(){
        Driver.closeDriver();
    }
}


/*
sam.walker@bluerentalcars.com   c!fas_art
kate.brown@bluerentalcars.com   tad1$Fas
raj.khan@bluerentalcars.com v7Hg_va^
pam.raymond@bluerentalcars.com  Nga^g6!

*MANUAL TESTING*

------ILK GIRIS---------
HOME PAGE DEYIZ
home page logine tikla ---->> try catch
LOGIN PAGE DEYIZ
kullanici adini gir(excelden al)
kullanici sifresini git(excelden al)
login page login buttonuna tikla

------2. GIRIS-----
HOME PAGE DEYIZ
kullanici ID ye tikla   ---->> try catch
Logout linkine tikla    ---->> try catch
OK e tikla              ---->> try catch
home page logine tikla  ---->> try catch
LOGIN PAGE DEYIZ
kullanici adini gir(excelden al)
kullanici sifresini git(excelden al)
login page login buttonuna tikla

------3. GIRIS---------
HOME PAGE DEYIZ
kullanici ID ye tikla
Logout linkine tikla
OK e tikla
home page logine tikla
LOGIN PAGE DEYIZ
kullanici adini gir(excelden al)
kullanici sifresini git(excelden al)
login page login buttonuna tikla
---------4. GIRIS------------

HOME PAGE DEYIZ
kullanici ID ye tikla
Logout linkine tikla
OK e tikla
home page logine tikla
LOGIN PAGE DEYIZ
kullanici adini gir(excelden al)
kullanici sifresini git(excelden al)
login page login buttonuna tikla
 */
