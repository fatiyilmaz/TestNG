package techproed.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import techproed.pages.TechproHomePage;
import techproed.pages.TechproHomePage2;
import techproed.utilities.ConfigReader;
import techproed.utilities.Driver;

public class Day21_techproLoginPage {
    @Test
    public void OpenSourceLogin() {
        //https://testcenter.techproeducation.com/index.php?page=form-authentication
        //Page object Model kullanarak sayfaya giriş yapildigini test edin
        //Sayfadan cikis yap ve cikis yapildigini test et
        //techproed
        //SuperSecretPassword


        Driver.getDriver().get(ConfigReader.getProperty("open_source_url_login"));

        TechproHomePage techproHomePage = new TechproHomePage();

        techproHomePage.username.sendKeys(ConfigReader.getProperty("open_source_username_login"));
        techproHomePage.password.sendKeys(ConfigReader.getProperty("open_source_password_login"));
        techproHomePage.submitLogin.click();

        TechproHomePage2 techproHomePage2 = new TechproHomePage2();
        Assert.assertTrue(techproHomePage2.textYazi.isDisplayed());

        techproHomePage2.logout.click();

        Assert.assertTrue(techproHomePage.loginPageTextYazi.isDisplayed());

    }
}
