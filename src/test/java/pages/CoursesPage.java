package pages;

import com.github.javafaker.Faker;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;
public class CoursesPage {
    public CoursesPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    public String url="https://codewiser.studymate.us/admin/courses?size=8&page=1";
    @FindBy(xpath ="//button[text()='Create course']")
    public WebElement createCourseButton;
    @FindBy(css = "input[name=courseName]")
    public WebElement courseName;
    @FindBy(css = "textarea[name=description]")
    public WebElement description;
    @FindBy(xpath = "//input[@placeholder='MM/DD/YYYY']")
    public WebElement pushclick;
    @FindBy(xpath = "//button[text()='Create']")
    public WebElement createButton;


    @FindBy(xpath = "(//div[@class='css-yys58j'])[1]")
    public WebElement courseOptions;

    @FindBy(xpath = "(//li[text()='Delete'])[1]")
    public WebElement deleteCourseButton;

    @FindBy(xpath = "(//p[@class='css-7zvtr8'])[3]")
    public WebElement allCoursesOnThePage;

    @FindBy(xpath = "//button[text()='Cancel']")
    public WebElement toExit;
    public void createCourse(){
        createCourseButton.click();
        Faker faker=new Faker();
        courseName.sendKeys(faker.educator().university());
        description.sendKeys(faker.superhero().descriptor());
        //pushclick.click();
        pushclick.sendKeys("09/09/2023");
        createButton.click();
        System.out.println("Course is created successfully");
    }
}
