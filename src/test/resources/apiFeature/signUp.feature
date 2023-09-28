Feature: User Tests

  Scenario Outline: Register new user

    When The user creates a POST request with "<name>" and "<email>" and "<password>" and "<about>" and "<terms>"
    Then The user verifies that the status code is <statusCode>
    And The user verifies that response body contains "<content>"
    And The compiler gets the token
    Examples:
      | name | email | password | about | terms | statusCode | content |
      | Ahsoka Tako | aksoka69@yahoo.com | Test1234 | From Space | 9 | 200 | token |

  Scenario Outline: The user can be able to Patch request and update own profile
    When The user creates a PATCH request and send token with "<name>" and "<password>" and "<admin>" and "<about>" and "<terms>" and "<job>" and "<company>" and "<website>" and "<location>" and "<skills>"
    Then The user verifies that the status code is <statusCode>
    When The user creates a GET request to get own profile
    Then The user verifies that name as "<name>" and email as "<email>"
    Examples:
      | name | password | admin | about | terms | job | company | website | location | skills | statusCode | email |
      | Ahsoka Tako1 | Test123 | 1 | From Ex | 3 | SDET | Nevarro | www.nasa.org | Galaxy | Commander | 204 | aksoka69@yahoo.com |