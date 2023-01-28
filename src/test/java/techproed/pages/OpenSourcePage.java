package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class OpenSourcePage {

    //Page Objelerini bu sinifta buluruz
    // 1.constructor   her bir page sinifinin bir constructor'i olacak
    public OpenSourcePage(){
        //PageFactory seleniumdan gelen ve bu sayfa elemenlerini instantiate(baslangic degeri vermek) etmek icin kullanilir
        //Sayfa objeleri cagrildiginda null pointer exception alinmaz
        PageFactory.initElements(Driver.getDriver(),this);

        //BURAYA KADARKI YUKARIDAKI KISIM STANDART TUM PAGES CLASS'INDA UYGULANIR!

        //PAGE OBJELERINI OLUSTUR
        //GELENEKSEL : public WebElement username = Driver.getDriver().findElement(By.name("username"));

    }
    @FindBy(name = "username")
    public WebElement username;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitButton;
}
