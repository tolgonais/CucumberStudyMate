package steps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.CommonPage;
import pages.SchedulePage;
import utilities.Driver;


public class ScheduleTest {
    SchedulePage schedulePage = new SchedulePage();
    CommonPage commonPage = new CommonPage();
    Faker faker = new Faker();
    WebDriver driver = Driver.getDriver();
    String name = faker.educator().course();

    @Given("the user is on Schedule page")
    public void the_user_is_on_schedule_page() {
        driver.get(schedulePage.url);
        String actualURL = driver.getCurrentUrl();
        Assert.assertEquals("The URL's doesn't match!",actualURL, schedulePage.url);
        System.out.println("The user is on Schedule page!");
    }
    @When("the user clicks on Create event button")
    public void the_user_clicks_on_create_event_button() {
        schedulePage.createEventButton.click();
    }
    @When("provides date, time, name")
    public void provides_date_time_name() {
        schedulePage.dateInput.click();
        schedulePage.dateInput.sendKeys("10292023");
        schedulePage.startTimeInput.click();
        schedulePage.startTimeInput.sendKeys("0900");
        schedulePage.endTimeInput.click();
        schedulePage.endTimeInput.sendKeys("1100");
        schedulePage.nameOfEventInput.click();
        schedulePage.nameOfEventInput.sendKeys(name);
    }
    @When("chooses a group")
    public void chooses_a_group() {
        schedulePage.groupsSelectDropdown.click();
        schedulePage.checkboxGroupsSelect1.click();
        schedulePage.closingTheDropdown.click();
    }
    @When("clicks on Publish button")
    public void clicks_on_publish_button() {
        schedulePage.publishButton.click();
    }
    @Then("verify that the event has been successfully created")
    public void verify_that_the_event_has_been_successfully_created() {
        Assert.assertTrue("The event is not displayed!",schedulePage.eventShowingOnCalendar.isDisplayed());
        System.out.println("The event is created successfully!");
    }



    @When("the user clicks on created Event")
    public void the_user_clicks_on_created_event() {
        schedulePage.evetToEdit.click();
    }
    @When("clicks on Edit button")
    public void clicks_on_Edit_button() {
       schedulePage.editButton.click();
    }
    @When("edits the day of Event")
    public void edits_the_day_of_Event() throws InterruptedException {
        schedulePage.dateEditField.click();
        Thread.sleep(3000);
        schedulePage.dateChosen.click();
    }
    @Then("verify that the Event is now updated to the new date")
    public void verify_that_the_Event_is_now_to_the_new_date() throws InterruptedException {
        Thread.sleep(2000);
        schedulePage.eventShowingOnCalendar.click();
        Assert.assertTrue("The event is not edited!", schedulePage.editCheck.getText().contains("15"));
    }




    @When("the user clicks on edited Event")
    public void the_user_clicks_on_edited_Event() {
        schedulePage.eventToDelete.click();
    }
    @When("clicks on Delete button")
    public void clicks_on_delete_button() {
        schedulePage.deleteButton.click();
        schedulePage.deleteConfirmation.click();
    }
    @Then("verify that the event is deleted")
    public void verify_that_the_event_is_deleted() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue("The event is not deleted!", driver.getCurrentUrl().contains("schedule"));
    }


}
