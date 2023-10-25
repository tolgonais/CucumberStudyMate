package steps;

import com.github.javafaker.Faker;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pages.CommonPage;
import pages.GroupsPage;
import utilities.Driver;

public class BGroupsTest {

    GroupsPage groupsPage=new GroupsPage();
    CommonPage commonPage=new CommonPage();
    Faker faker=new Faker();
    WebDriver driver= Driver.getDriver();
    String groupName=faker.superhero().name();
    //WebElement createdGroup;
    @Given("the user is on Group page")
    public void the_user_is_on_group_page() {
    driver.get(groupsPage.url);
    }
    @When("the user clicks on Create  button")
    public void the_user_clicks_on_create_button() {
        groupsPage.createButton.click();
    }
    @When("provides name,date,discription")
    public void provides_name_date_discription() throws InterruptedException {
        groupsPage.groupNameInput.click();
        groupsPage.groupNameInput.sendKeys(groupName);
        groupsPage.descriptionInput.click();
        groupsPage.descriptionInput.sendKeys(faker.superhero().power());
        groupsPage.dateInputCalendar.click();
        groupsPage.dateSelectInCalendar.click();
        Thread.sleep(5000);
    }
    @When("click on create Group")
    public void click_on_create_Group(){
        groupsPage.createButtonAfterInput.click();
    }
    @Then("verify that the Group has been successfully created")
    public void verify_that_the_group_has_been_successfully_created() throws InterruptedException {
        Thread.sleep(5000);
        Assert.assertTrue("Group is not created", driver.getCurrentUrl().contains("groups"));
        System.out.println("Group is created successfully");

    }
}


