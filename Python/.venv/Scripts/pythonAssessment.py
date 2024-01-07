from selenium import webdriver
from selenium.webdriver.common.keys import Keys
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import Select
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

# Launch a below URL and verify the title of the Page
url = "http://webdriveruniversity.com/index.html"
driver = webdriver.Chrome()
driver.get(url)
assert "WebDriverUniversity" in driver.title

# Click on Dropdown-Checkboxes-RadioButtons link
link = driver.find_element(By.XPATH, "//a[@id='dropdown-checkboxes-radiobuttons']")
link.click()

# Verify that new tab has opened and switch to that tab using Selenium Web Driver Concepts
wait = WebDriverWait(driver, 10)
wait.until(EC.number_of_windows_to_be(2))
driver.switch_to.window(driver.window_handles[1])

# Select values from Drop Menu and verify that value is selected
select = Select(driver.find_element(By.XPATH, "//select[@id='dropdowm-menu-1']"))
select.select_by_visible_text('Python')
assert select.first_selected_option.text == 'Python'

# Select Multiple Checkboxes and verify count of Checked and Unchecked
checkboxes = driver.find_elements(By.XPATH, "//input[@type='checkbox']")
checked_count = 0
unchecked_count = 0
for checkbox in checkboxes:
    if checkbox.is_selected():
        checked_count += 1
    else:
        unchecked_count += 1
assert checked_count == 1
assert unchecked_count == 3

# Select a radio button and verify count of checked and not checked
radios = driver.find_elements(By.XPATH, "//input[@type='radio']")
checked_count = 0
unchecked_count = 0
for radio in radios:
    if radio.is_selected():
        checked_count += 1
    else:
        unchecked_count += 1


driver.quit()
