package pages;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.Driver;

import java.time.Duration;

public class StudentsPage {
    public StudentsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public String url = "https://codewiser.studymate.us/admin/students?size=6&page=1";
    @FindBy(xpath = "//li[contains(text(), 'Students')]")
    public WebElement studentsButton;

    @FindBy(xpath = "//button[contains(text(), 'Add student')]")
    public WebElement addStudentButton;

    @FindBy(xpath = "//input[@name='name']")
    public WebElement firstNameInput;

    @FindBy(xpath = "//input[@name='lastName']")
    public WebElement lastNameInput;

    @FindBy(xpath = "//input[@name='phoneNumber']")
    public WebElement phoneNumberInput;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailInput;

    @FindBy(xpath = "//div[@id='mui-component-select-groupId']")
    public WebElement groupDropDown;

    @FindBy(xpath = "//li[text()='TestGroup']")
    public WebElement selectDropDown1;

    @FindBy(xpath = "//div[@id='mui-component-select-studyFormat']")
    public WebElement studyFormatDropDown;

    @FindBy(xpath = "//li[contains(text(), 'ONLINE')]")
    public WebElement onlineStudyFormat;

    @FindBy(xpath = "//button[text()='Add']")
    public WebElement addButton;

    @FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiIconButton-root MuiIconButton-sizeMedium css-1yxmbwk'])[4]")
    public WebElement studentOptions;

    @FindBy(xpath = "(//li[text()='Edit'])[2]")
    public WebElement editStudentInfo;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement editEmail;

    @FindBy(xpath = "//button[contains(text(), 'Save')]")
    public WebElement saveEditsButton;

    @FindBy(xpath = "(//td[@class= 'MuiTableCell-root MuiTableCell-body MuiTableCell-alignLeft MuiTableCell-sizeMedium css-q34dxg'])[12]")
    public WebElement emailShownOnThePage;

    @FindBy(xpath = "(//p[@class='css-7zvtr8'])[3]")
    public WebElement fromShownStudentsToCheck;

    @FindBy(xpath = "(//li[text()='Delete'])[2]")
    public WebElement deleteButton;

    @FindBy(xpath = "//button[text()='Delete']")
    public WebElement deleteConfirm;

    public void createStudent() throws InterruptedException {
        Faker faker = new Faker();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), Duration.ofSeconds(5));
        String fromBefore = fromShownStudentsToCheck.getText();

        addStudentButton.click();

        firstNameInput.click();
        firstNameInput.sendKeys(faker.name().firstName());

        lastNameInput.click();
        lastNameInput.sendKeys(faker.name().lastName());

        phoneNumberInput.click();
        phoneNumberInput.sendKeys(faker.phoneNumber().cellPhone().replace("-", "").replace(".", ""));

        emailInput.click();
        emailInput.sendKeys(faker.internet().emailAddress());

        groupDropDown.click();
        selectDropDown1.click();

        studyFormatDropDown.click();
        onlineStudyFormat.click();

        addButton.click();

        System.out.println("Student is successfully added");

    }


    public void editEmail(){
        Faker faker = new Faker();
        studentOptions.click();

        editStudentInfo.click();

        Actions actions = new Actions(Driver.getDriver());
        actions.click(editEmail)
                .keyDown(Keys.COMMAND)
                .sendKeys("a")
                .keyUp(Keys.COMMAND)
                .sendKeys(Keys.BACK_SPACE)
                .build()
                .perform();

        editEmail.sendKeys(faker.internet().emailAddress());

        saveEditsButton.click();

        String checkEmail = emailShownOnThePage.getText();
        System.out.println("Email after editing: " + checkEmail);
    }

}
