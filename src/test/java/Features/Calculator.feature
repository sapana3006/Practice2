Feature: Basic calculation
  
  Scenario Outline:  Addition of two numbers
    Given  I am on calculator page
    When I enter '<n1>' in calculator
    And I press  '<op>'
    And I enter '<n2>' in calculator
    Then I see result is '<result>'
    Examples:
    |n1|op|n2|result|
    |3 |+| 4 |7     |
    |4 |-|6  |-2     |
    |5 |*|2  |10     |



