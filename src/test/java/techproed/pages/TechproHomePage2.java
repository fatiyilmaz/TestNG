package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class TechproHomePage2 {
    public TechproHomePage2(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(xpath = "//*[@class='alert alert-success alert-dismissible fade show']")
    public WebElement textYazi;

    @FindBy(xpath = "//*[@class='btn btn-dark']")
    public WebElement logout;
}
