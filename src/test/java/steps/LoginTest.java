package steps;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.CommonPage;
import pages.LoginPage;
import utilities.Config;
import utilities.Driver;

public class LoginTest {
    WebDriver driver;
    LoginPage loginPage = new LoginPage();
    CommonPage commonPage = new CommonPage();
    @Given("the user is on login page")
    public void the_user_is_on_login_page() {
        driver = Driver.getDriver();
        driver.get(Config.getProperty("studymateUrl"));
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals(actualURL,Config.getProperty("studymateUrl"));
    }
    @When("the user enters correct <admin@codewise.com> email")
    public void the_user_enters_correct_admin_codewise_com_email() {
       loginPage.usernameInput.sendKeys(Config.getProperty("email"));
    }
    @When("the user enters correct <codewise123> password")
    public void the_user_enters_correct_codewise123_password() {
        loginPage.passwordInput.sendKeys(Config.getProperty("password"));
    }
    @When("the user clicks on Login button")
    public void the_user_clicks_on_login_button() {
        loginPage.loginButton.click();
    }
    @Then("verify the user logs in successfully")
    public void verify_the_user_logs_in_successfully() {
        Assert.assertEquals(driver.getCurrentUrl(), commonPage.url);
    }

}
