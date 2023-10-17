package pages;


import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class LoginPage {

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public String url = "https://codewiser.studymate.us/login";

    @FindBy(name = "email")
    public WebElement usernameInput;

    @FindBy(name = "password")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[contains(text(), 'Log in')]")
    public WebElement loginButton;


    public void login(){
        usernameInput.sendKeys("admin@codewise.com");
        passwordInput.sendKeys("codewise123");
        loginButton.click();
    }

}
