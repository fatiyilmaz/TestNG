package techproed.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import techproed.utilities.Driver;

public class TechproHomePage {

    public TechproHomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//input[@id='exampleInputEmail1']")
    public WebElement username;

    @FindBy(xpath = "//input[@id='exampleInputPassword1']")
    public WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitLogin;

    @FindBy(xpath = "//h2")
    public WebElement loginPageTextYazi;
}
