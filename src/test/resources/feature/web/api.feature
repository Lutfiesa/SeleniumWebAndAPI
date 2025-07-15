Feature: Test Automation Rest API

  @api
  Scenario: Test Get List Data Normal
    Given prepare url for "GET_LIST_USERS"
    And hit api get list users
    Then validation status code is equals 200
    Then validation response body get list users
    Then validation response json with JSONSchema "get_list_users_normal.json"

  @api
  Scenario: Test Create Normal User
    Given prepare url for "CREATE_NEW_USER"
    And hit api create new user
    Then validation status code is equals 201
    Then validation response body create new user
    Then validation response json with JSONSchema "post_create_user.json"

  @api
  Scenario: Test Delete Normal User
    Given prepare url for "DELETE_USER"
    And hit api create new user
    Then validation status code is equals 201
    Then validation response body create new user
    And hit api delete user
    Then validation status code is equals 204

  @api
  Scenario: Test Update Normal User
    Given prepare url for "UPDATE_USER"
    And hit api create new user
    Then validation status code is equals 201
    Then validation response body create new user
    And hit api update user
    Then validation status code is equals 200
    Then validation response body update user
    Then validation response json with JSONSchema "update_user.json"