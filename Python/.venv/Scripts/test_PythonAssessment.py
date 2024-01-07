# Import the required modules
import pytest
from selenium import webdriver
from selenium.webdriver.support.ui import Select
from selenium.webdriver.common.by import By




# Define the URL and the expected title
URL = "http://webdriveruniversity.com/index.html"
EXPECTED_TITLE = "WebDriverUniversity.com"

# Define a fixture to initialize and quit the driver
@pytest.fixture
def driver():
    driver = webdriver.Chrome()
    yield driver
    driver.quit()

# Define a test function to perform the steps
def test_webdriver_university(driver):
    # Launch the URL and verify the title
    driver.get(URL)
    assert driver.title == EXPECTED_TITLE

    # Click on the Dropdown-Checkboxes-RadioButtons link
    driver.find_element(By.ID,"dropdown-checkboxes-radiobuttons").click()

    # Verify that a new tab has opened and switch to it
    assert len(driver.window_handles) == 2
    driver.switch_to.window(driver.window_handles[1])

    # Select values from the drop menu and verify that value is selected
    select = Select(driver.find_element(By.ID,"dropdowm-menu-1"))
    select.select_by_visible_text("Python")
    assert select.first_selected_option.text == "Python"

    # Select multiple checkboxes and verify count of checked and unchecked checkboxes
    checkboxes = driver.find_elements(By.XPATH, "//input[@type='checkbox']")
    checked = 0
    unchecked = 0
    for checkbox in checkboxes:
        if checkbox.is_selected():
            checked += 1
        else:
            unchecked += 1
            checkbox.click()
    assert checked == 1
    assert unchecked == 2

    # Select a radio button and verify count of checked and unchecked radio buttons
    radio_buttons = driver.find_elements(By.XPATH,"//input[@type='radio']")
    checked = 0
    unchecked = 0
    for radio_button in radio_buttons:
        if radio_button.is_selected():
            checked += 1
        else:
            unchecked += 1
            if radio_button.get_attribute("value") == "cabbage":
                radio_button.click()
    assert checked == 1
    assert unchecked == 2

# Define a main function to run the test
if __name__ == "__main__":
    pytest.main([__file__])