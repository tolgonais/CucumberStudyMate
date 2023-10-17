package pages;

import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SchedulePage {

    public SchedulePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public String url = "https://codewiser.studymate.us/admin/schedule";

    @FindBy(xpath = "//button[@tabindex='0']/span[@class='MuiButton-startIcon MuiButton-iconSizeMedium css-6xugel']")
    public WebElement createEventButton;

    @FindBy(xpath = "//input[@placeholder='MM/DD/YYYY']")
    public WebElement dateInput;

    @FindBy(xpath = "//input[@id='startTime']")
    public WebElement startTimeInput;

    @FindBy(xpath = "//input[@id='endTime']")
    public WebElement endTimeInput;

    @FindBy(xpath = "//input[@id='title']")
    public WebElement nameOfEventInput;

    @FindBy(id = "mui-component-select-groupIds")
    public WebElement groupsSelectDropdown;


    @FindBy(xpath = "//input[@class='PrivateSwitchBase-input css-1m9pwf3']")
    public WebElement checkboxGroupsSelect1;

    @FindBy(xpath = "(//div[@class='MuiBackdrop-root MuiBackdrop-invisible css-esi9ax'])[2]")
    public WebElement closingTheDropdown;

    @FindBy(xpath = "//button[contains(text(), 'Publish')]")
    public WebElement publishButton;

    @FindBy(xpath = "//div[contains(text(),'● Event')]")
    public WebElement eventShowingOnCalendar;


    public void createAnEvent(){

        createEventButton.click();

        dateInput.click();
        dateInput.sendKeys("09252023");

        startTimeInput.click();
        startTimeInput.sendKeys("0900");

        endTimeInput.click();
        endTimeInput.sendKeys("1200");

        nameOfEventInput.click();
        nameOfEventInput.sendKeys("Info session with HR");

        groupsSelectDropdown.click();
        checkboxGroupsSelect1.click();
        closingTheDropdown.click();

        publishButton.click();

        Assert.assertTrue(eventShowingOnCalendar.isDisplayed());
        System.out.println("Event successfully created!");
    }

}
