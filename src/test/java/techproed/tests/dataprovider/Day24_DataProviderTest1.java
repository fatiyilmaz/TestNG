package techproed.tests.dataprovider;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import techproed.utilities.Driver;


public class Day24_DataProviderTest1 {
    /*
        Data Provider Nedir ?
        *** Veri deposudur. Bir cok veriyi Test Caselere loop kullanmadan aktarmak icin kullanilir.
        *** Data provider 2D (2 boyutlu) object return eder.
        *** Data provider TestNG den gelen bir ozelliktir.

        Data Provider ne icin kullanilir ?
        *** Data provider DDT(Data Driven Testing) icin kullanilir. Birden fazla datayi test caselerde kullanmak icin kullanilir.

        Data provider'i nasil kullanirsin ?
        *** @DataProvider annotasyonu ile veri havuzu olusturulur.
        *** @Test methodlarina data dataProvider parametresi ile baglanir.

        Data provider da 2 tane parametre vardir :
        ***name : method ismini override etmek icin, yani farkli bir isim ile data provider'i cagirmak icin kullanilir.
        ***paralel : paralel test caseler olusturmak icin kullanilir.
     */

    //DATA PROVIDER
    @DataProvider(name = "smoke_test_data")//Zorunlu olmamakla beraber verilebilir. Yeni method ismi Override edilmis olur.
    public Object[][] urunler(){
        Object urunListesi[][]= {
                {"tesla"},
                {"bmw"},
                {"mercedes"},
                {"honda"},
                {"toyota"},
                {"volvo"}
        };
        return urunListesi;
    }


    //TEST METHODU
    @Test(dataProvider = "urunler")//Buraya methodun adi urunler diye yazmistik ama sonrasinda smoke_test_data boyle yapinca, suan calisilmaz durumda.
    public void aramaTesti(String data){
        System.out.println(data);
    }

    //GOOGLE ARAMASI
    @Test(dataProvider = "smoke_test_data")//yeni method ismi yazili oludugu icin, calisir durumda.
    public void googleAramasi(String araclar){
        //google a git
        Driver.getDriver().get("https://www.google.com");
        //araclari arama kutusuna gir ve Enrer'a bas
        Driver.getDriver().findElement(By.name("q")).sendKeys(araclar+ Keys.ENTER);
        //sayfa title'inin aradigim kelimeyi icerdigini assert et
        Assert.assertTrue(Driver.getDriver().getTitle().contains(araclar));
        //driver'i kapat
        Driver.closeDriver();
    }

}


//        GOOGLE ARAMASINDA COOKIES CIKANLAR ICIN
//        try {
//            Driver.getDriver().findElement(By.xpath("(//div[@class='QS5gu sy4vM'])[2]")).click();
//        }catch (Exception e){
//
//        }