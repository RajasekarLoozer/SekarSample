Feature: login functionality

  Scenario: Checking the username and password
    When Url launch using "<browser>" 
    Given Enter the "<username>" and "<password>" using examples
      | username | password | browser |
      | selva    | Raja     | chrome  |
