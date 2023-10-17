package pages;

import com.github.javafaker.Faker;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class AnnouncementsPage {
    public AnnouncementsPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public String url = "https://codewiser.studymate.us/admin/announcements";

    @FindBy(xpath = "//button[text()='Add an announcement']")
    public WebElement createButton;

    @FindBy(xpath = "//textarea[@name='text']")
    public WebElement textInput;

    @FindBy(id = "mui-component-select-groups")
    public WebElement groupsDropdown;

    @FindBy(xpath = "//*[@id='menu-groups']/div[3]/ul/li[3]")
    public WebElement groupChoise;

    @FindBy(xpath = "//button[text()='Add']")
    public WebElement addButton;

    @FindBy(xpath = "//p[@class='sc-jKvnYE cIrycx']")
    public WebElement createdAnnouncement;


    public void addAnnouncement(){
        Faker faker = new Faker();

        createButton.click();
        String announcementText = faker.harryPotter().spell();
        textInput.sendKeys(announcementText);
        groupsDropdown.click();
        groupChoise.click();
        addButton.click();

        String actualText = createdAnnouncement.getText();

        Assert.assertEquals(actualText, announcementText);

    }


}
