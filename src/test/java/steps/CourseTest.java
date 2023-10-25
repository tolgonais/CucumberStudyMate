package steps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.CommonPage;
import pages.CoursesPage;
import pages.GroupsPage;
import utilities.Driver;

public class CourseTest {

    CoursesPage coursesPage=new CoursesPage();
    CommonPage commonPage=new CommonPage();
    Faker faker=new Faker();
    WebDriver driver= Driver.getDriver();


    @Given("the user is on Course page")
    public void the_user_is_on_course_page() {
        driver.get(coursesPage.url);

    }

    @When("click on create")
    public void click_on_create() {
        coursesPage.createCourseButton.click();
    }
    @When("provides name,date, time")
    public void provides_name_date_time() {
        coursesPage.courseName.click();
        coursesPage.courseName.sendKeys(faker.educator().university());
        coursesPage.description.sendKeys(faker.superhero().descriptor());
        coursesPage.pushclick.click();
        coursesPage.pushclick.sendKeys("10/28/2023");
        coursesPage.createButton.click();

    }

    @Then("verify that the Course has been successfully created")
    public void verify_that_the_course_has_been_successfully_created() {
        Assert.assertTrue("Course is not created ", driver.getCurrentUrl().contains("courses"));
        System.out.println("Course is creatd successfullly");
    }



}
