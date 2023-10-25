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
    WebDriver driver = Driver.getDriver();
    LoginPage loginPage = new LoginPage();
    CommonPage commonPage = new CommonPage();
    @Given("the user is on login page")
    public void the_user_is_on_login_page() {
        driver.get(Config.getProperty("studymateUrl"));
        Assert.assertEquals("The titles don't match!", "StudyMate", driver.getTitle());
        System.out.println("The user is on the right page");
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
    public void verify_the_user_logs_in_successfully() throws InterruptedException {
        String expectedURL = "https://codewiser.studymate.us/admin/analytics";
        Thread.sleep(5000);
        Assert.assertEquals("The user is not logged in!",expectedURL, driver.getCurrentUrl());
    }

}
