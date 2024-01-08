Feature: Image Verification

  Scenario: Verify image change in iframe
    Given I launch the website "http://webdriveruniversity.com/index.html"
    When I click on the "IFRAME" link
    And I switch to the new "http://webdriveruniversity.com/index.html" tab
    Then I verify that the image is present
    And I click on the right arrow button
    And I verify that the image has changed