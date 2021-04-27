@end2end
Feature: Signup New account and send message

  @signup
  Scenario Outline: User Signup and send Message
    Given User launches a browser and navigate to elearning URL
    When User click signup
    #And User enter all Mandatory information
    And User enter valid "<Firstname>","<Lastname>","<Username>","<email>","<Password>" and "<ConfirmPassword>"
    And User click register
    And User see successful registration message
    And User clicks homepage from successful registration page
    And User clicks on profile dropdown
    And User clicks on Message
    And User enters mandatory information in compose message
    And User click send message
    Then User see success message
    And User logout and close the browser

    Examples: 
      | Firstname | Lastname | Username | email          | Password | ConfirmPassword |
      |        11 |       23 |     1149 | 1149@gmail.com | 12345678 |        12345678 |
