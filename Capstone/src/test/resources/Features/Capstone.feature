@testcapstone
Feature: Verify image carousel

  Scenario: Verify image functionality
    Given I open the URL "http://webdriveruniversity.com/index.html"
    When I click on the "IFrame" link
    And I switch to the new tab
    Then I verify that the image is present
    And I click on the right arrow button
    And I verify that the images are changing accordingly