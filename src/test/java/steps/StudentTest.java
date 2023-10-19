package steps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.StudentsPage;
import utilities.Driver;

public class StudentTest {
    StudentsPage studentsPage = new StudentsPage();
    WebDriver driver = Driver.getDriver();
    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();

    @Given("the user is on Student page")
    public void the_user_is_on_student_page(){
        driver.get(studentsPage.url);
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals("The URL's doesn't match!", actualURL, studentsPage.url);
        System.out.println("The user is on Students page");
    }
    @When("the user clicks on Add Student button")
    public void the_user_clicks_on_add_student_button() {
        studentsPage.addStudentButton.click();
    }
    @When("the user provides first name, last name, phone number and email")
    public void the_user_provides_first_name_last_name_phone_number_and_email() {
        studentsPage.firstNameInput.click();
        studentsPage.firstNameInput.sendKeys(firstName);
        studentsPage.lastNameInput.click();
        studentsPage.lastNameInput.sendKeys(lastName);
        studentsPage.phoneNumberInput.click();
        studentsPage.phoneNumberInput.sendKeys(faker.phoneNumber().phoneNumber().replace("-", ""));
        studentsPage.emailInput.click();
        studentsPage.emailInput.sendKeys(faker.internet().emailAddress());
    }
    @When("selects group")
    public void selects_group() {
        studentsPage.groupDropDown.click();
        studentsPage.selectDropDown1.click();
    }
    @When("selects study format")
    public void selects_study_format() {
        studentsPage.studyFormatDropDown.click();
        studentsPage.onlineStudyFormat.click();
    }
    @When("clicks on Add button")
    public void clicks_on_add_button() {
        studentsPage.addButton.click();
    }
    @Then("verify that new student is created")
    public void verify_that_new_student_is_created() {

    }

}
