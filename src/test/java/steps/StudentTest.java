package steps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import pages.StudentsPage;
import utilities.Driver;

public class StudentTest {
    StudentsPage studentsPage = new StudentsPage();
    WebDriver driver = Driver.getDriver();
    Faker faker = new Faker();
    String firstName = faker.name().firstName();
    String lastName = faker.name().lastName();
    String editedEmail = faker.internet().emailAddress();

    Actions actions = new Actions(driver);

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
    public void verify_that_new_student_is_created() throws InterruptedException {
        Thread.sleep(5000);
        String toAssert = studentsPage.fromShownStudentsToCheck.getText();
        Assert.assertTrue("The student is not created!", toAssert.contains("2") || toAssert.contains("3") || toAssert.contains("4"));
    }




    @When("the user clicks on Student options")
    public void the_user_clicks_on_student_options() {
        studentsPage.studentOptions.click();
    }
    @When("clicks on Edit student's info button")
    public void clicks_on_edit_student_s_info_button() {
       studentsPage.editStudentInfo.click();
    }
    @When("edits Student's email")
    public void edits_student_s_email() {
        actions.click(studentsPage.editEmail)
                .keyDown(Keys.COMMAND)
                .sendKeys("a")
                .keyUp(Keys.COMMAND)
                .sendKeys(Keys.BACK_SPACE)
                .build()
                .perform();
        studentsPage.editEmail.sendKeys(editedEmail);
    }

    @When("clicks on Save button")
    public void clicks_on_save_button() {
        studentsPage.saveEditsButton.click();
    }

    @Then("verify that the Student's email edited successfully")
    public void verify_that_the_student_s_email_edited_successfully() throws InterruptedException {
        Thread.sleep(4000);
        String actualEmail = studentsPage.emailShownOnThePage.getText();
        Assert.assertTrue("The email in not matching", actualEmail.equals(editedEmail));
    }



    @When("clicks on Delete student button")
    public void clicks_on_delete_student_button() {
        studentsPage.deleteButton.click();
    }

    @When("confirms deletion")
    public void confirms_deletion() {
        studentsPage.deleteConfirm.click();
    }

    @Then("verify that the Student has been deleted successfully")
    public void verify_that_the_student_has_been_deleted_successfully() throws InterruptedException {
        Thread.sleep(4000);
        Assert.assertTrue("The Student has not been deleted!", studentsPage.fromShownStudentsToCheck.getText().contains("1"));
    }

}
