package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import BaseClass.*;

import org.testng.Assert;

public

class ImageVerificationSteps {
    private WebDriver driver;

    @Given("I launch the website {string}")
    public void launchWebsite(String url) {
        driver = BaseClass.getDriver();
        driver.get(url);
    }

    @When("I click on the {string} link")
    public void i_click_on_the_link(String linkText) {
        WebElement link = driver.findElement(By.linkText(linkText));
        link.click();
    }
    
    @Then("I switch to the new {string} tab")
    public void i_should_be_on_the_page(String url) {
        Assert.assertEquals(driver.getCurrentUrl(), url);
    }

    @Then("I verify that the image is present")
    public void I_verify_that_the_image_is_present() {
        WebElement carousel = driver.findElement(By.id("carousel-example-generic"));
        Assert.assertTrue(carousel.isDisplayed());
    }

    @When("I click on the right arrow button")
    public void i_click_on_the_right_arrow_button() {
        WebElement rightArrow = driver.findElement(By.className("right"));
        rightArrow.click();
    }

    @Then("I verify that the image has changed")
    public void I_verify_that_the_image_has_changed() {
        WebElement image = driver.findElement(By.xpath("//div[@class='item active']/img"));
        String src1 = image.getAttribute("src");
        WebElement rightArrow = driver.findElement(By.className("right"));
        rightArrow.click();
        image = driver.findElement(By.xpath("//div[@class='item active']/img"));
        String src2 = image.getAttribute("src");
        Assert.assertNotEquals(src1, src2);
    }
   
    
}
