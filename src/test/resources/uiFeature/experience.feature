Feature: Compare UI and API experiences
@wip
  Scenario Outline: UI and API experiences
    When The user creates a POST request for experience with "<job>" and "<company>" and "<location>" and "<fromdate>" and "<todate>" and "<current>" and "<description>"
    Then The user verifies that the status code is <statusCode>
    When The user creates a GET request to get added experience
    Then The user verifies that job as "<job>" and company as "<company>"
    When The user is on the Profile Page
    Then The user verifies that UI experience and API experience matches by using "<job>"
  Examples:
    | job | company | location | fromdate | todate | current | description | statusCode |
    | Master | Galaxy | Space | 1200-01-01 | 1300-01-01 | false | may the force be with you | 200 |
