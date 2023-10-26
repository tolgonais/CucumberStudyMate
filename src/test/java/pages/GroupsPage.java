package pages;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

import java.util.List;

public class GroupsPage {
    public GroupsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public String url = "https://codewiser.studymate.us/admin/groups?size=8&page=1";

    @FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium MuiButton-root MuiButton-contained MuiButton-containedPrimary MuiButton-sizeMedium MuiButton-containedSizeMedium css-79mk38'])")
    public WebElement createButton;

    @FindBy(xpath = "//input[@name='name']")
    public WebElement groupNameInput;

    @FindBy(xpath = "//textarea[@name='description']")
    public WebElement descriptionInput;

    @FindBy(css = "svg[class='MuiSvgIcon-root MuiSvgIcon-fontSizeMedium css-vubbuv']")
    public WebElement dateInputCalendar;

    @FindBy(xpath = "(//button[@class='MuiButtonBase-root MuiPickersDay-root MuiPickersDay-dayWithMargin css-bekps4'])[8]")
    public WebElement dateSelectInCalendar;

    @FindBy(xpath = "(//*[contains(text(),'Create')])[3]")
    public WebElement createButtonAfterInput;

    @FindBy(xpath = "(//div[@class='sc-jIILKH frksvl'])[1]")
    public WebElement createdGroup;

//    @FindBy(xpath = "//div[@class='sc-jrcTuL ktiWgV actions']//button[text()='Create']")
//    public WebElement createdGroupButton;

//    @FindBys(@FindBy(how = How.CLASS_NAME, using="MuiTypography-root MuiTypography-h5 MuiTypography-gutterBottom sc-jIILKH jQpKBu css-1i17kim"))
//    public List<WebElement> groupsList;

    @FindBy(xpath = "(//div[@class='css-yys58j'])[1]")
    public WebElement groupsOptions;

    @FindBy(xpath = "(//li[text()='Delete group'])[1]")
    public WebElement deleteGroupButton;

    @FindBy(xpath = "//button[text()='Delete']")
    public WebElement deleteConfirmation;

    @FindBy(xpath = "(//p[@class='css-7zvtr8'])[3]")
    public WebElement numberOfGroupsOnThePage;
    public void createAGroup(){
        Faker faker = new Faker();

        createButton.click();

        groupNameInput.click();
        String groupName = faker.superhero().name();
        groupNameInput.sendKeys(groupName);

        descriptionInput.click();
        descriptionInput.sendKeys(faker.superhero().power());

        dateInputCalendar.click();
        dateSelectInCalendar.click();

        createButtonAfterInput.click();
        Assert.assertTrue(createdGroup.getText().contains(groupName));
        System.out.println("Group is created successfully");
    }



}

