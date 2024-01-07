package StepDefinitions;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Stepdefinition {
    private WebDriver driver;

    @Given("I open the URL {string}")
    public void i_open_the_url(String url) {
        System.setProperty("webdriver.chrome.driver", "./Drivers.chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(url);
    }

    @When("I click on the {string} link")
    public void i_click_on_the_link(String linkText) {
        WebElement link = driver.findElement(By.linkText(linkText));
        link.click();
    }

    @When("I switch to the new tab")
    public void i_switch_to_the_new_tab() {
        String currentWindowHandle = driver.getWindowHandle();
        for (String windowHandle : driver.getWindowHandles()) {
            if (!windowHandle.equals(currentWindowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }
    }

    @Then("I verify that the image is present")
    public void i_verify_that_the_image_is_present() {
        WebElement image = driver.findElement(By.cssSelector(".carousel-inner .item.active img"));
        Assert.assertTrue(image.isDisplayed());
    }

    @Then("I click on the right arrow button")
    public void i_click_on_the_right_arrow_button() {
        WebElement rightArrowButton = driver.findElement(By.cssSelector(".carousel-control.right"));
        rightArrowButton.click();
    }

    @Then("I verify that the images are changing accordingly")
    public void i_verify_that_the_images_are_changing_accordingly() throws InterruptedException {
        WebElement firstImage = driver.findElement(By.cssSelector(".carousel-inner .item.active img"));
        Thread.sleep(2000);
        WebElement secondImage = driver.findElement(By.cssSelector(".carousel-inner .item.active img"));
        Assert.assertNotEquals(firstImage.getAttribute("src"), secondImage.getAttribute("src"));
    }
}
