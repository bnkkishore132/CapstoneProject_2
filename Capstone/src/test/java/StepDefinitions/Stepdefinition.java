package StepDefinitions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import browser.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Stepdefinition extends BaseClass{
    
	BaseClass bc = new BaseClass();
    
	@Given("")
	@Given("I am on the {string} page")
    public void i_am_on_the_page(String url) {
        
        bc.setUp();
    }

    @When("I click on the {string} link")
    public void i_click_on_the_link(String linkText) {
        WebElement link = driver.findElement(By.linkText(linkText));
        link.click();
    }

    @Then("I should be on the {string} page")
    public void i_should_be_on_the_page(String url) {
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Then("I should see the image carousel")
    public void i_should_see_the_image_carousel() {
        WebElement carousel = driver.findElement(By.id("carousel-example-generic"));
        Assert.assertTrue(carousel.isDisplayed());
    }

    @When("I click on the right arrow button")
    public void i_click_on_the_right_arrow_button() {
        WebElement rightArrow = driver.findElement(By.className("right"));
        rightArrow.click();
    }

    @Then("the image should change")
    public void the_image_should_change() {
        WebElement image = driver.findElement(By.xpath("//div[@class='item active']/img"));
        String src1 = image.getAttribute("src");
        WebElement rightArrow = driver.findElement(By.className("right"));
        rightArrow.click();
        image = driver.findElement(By.xpath("//div[@class='item active']/img"));
        String src2 = image.getAttribute("src");
        Assert.assertNotEquals(src1, src2);
    }
   
    
}
