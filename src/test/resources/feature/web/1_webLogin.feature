Feature: Test Automation Web Login

  @login
  Scenario: Test login web normal
    Given open web login page
    And input valid username "standard_user" and password "secret_sauce"
    When click button login
    Then user will direct to homepage

  @login
  Scenario: Test login web invalid user
    Given open web login page
    And input valid username "locked_out_user" and password "secret_sauce"
    When click button login
    Then user will see error message "Epic sadface: Sorry, this user has been locked out"

  @login
  Scenario: Test login web blank username
    Given open web login page
    And input valid username "" and password "secret_sauce"
    When click button login
    Then user will see error message "Epic sadface: Username is required"

  @login
  Scenario: Test login web blank password
    Given open web login page
    And input valid username "locked_out_user" and password ""
    When click button login
    Then user will see error message "Epic sadface: Password is required"