package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
public class CommonPage {
    public CommonPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }
    public String url="https://codewiser.studymate.us/admin/analystics";
    @FindBy(xpath = "//li[text()='Courses']")
    public WebElement courses;
    @FindBy(xpath = "//li[text()='Groups']")
    public WebElement groups;

    @FindBy(xpath = "//li[contains(text(), 'Students')]")
    public WebElement students;

    @FindBy(xpath = "//li[text()='Schedule']")
    public WebElement schedule;


}