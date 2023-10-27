package steps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import pages.AnnouncementsPage;
import utilities.Driver;

public class AnnouncementsTest {
    WebDriver driver = Driver.getDriver();
    AnnouncementsPage announcementsPage = new AnnouncementsPage();
    Faker faker = new Faker();

    @Given("the user is on the Announcements page")
    public void the_user_is_on_the_announcements_page() {
        driver.get(announcementsPage.url);
    }
    @When("the user clicks on Add announcement button")
    public void the_user_clicks_on_add_announcement_button() {
        announcementsPage.createButton.click();
    }
    @When("provides the description of the Announcement")
    public void provides_the_description_of_the_announcement() {
        announcementsPage.textInput.sendKeys(faker.harryPotter().quote());
    }
    @When("picks a group")
    public void picks_a_group() {
        announcementsPage.groupsDropdown.click();
        announcementsPage.groupChoise.click();
    }
    @When("clicks on Add announcement button")
    public void clicks_on_add_announcement_button() {
        announcementsPage.addButton.click();
    }
    @Then("verify that the announcement is successfully created")
    public void verify_that_the_announcement_is_successfully_created() {
        Assert.assertTrue("The annoncement is not created!", announcementsPage.allAnnouncementsOnThePage.getText().contains("1")
        || announcementsPage.allAnnouncementsOnThePage.getText().contains("2") || announcementsPage.allAnnouncementsOnThePage.getText().contains("3"));
    }

}
