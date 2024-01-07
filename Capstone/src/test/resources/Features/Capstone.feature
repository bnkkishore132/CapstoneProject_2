@testcapstone
Feature: Verify image in WebDriver University

  Scenario: Verify image functionality
    Given I am on the "http://webdriveruniversity.com/index.html" page
    When I click on the "IFrame" link
    Then I should be on the "http://webdriveruniversity.com/IFrame/index.html" page
    And I should see the image carousel
    When I click on the right arrow button
    Then the image should change
