Feature: scc homework test

  Scenario Outline: place an order
    Given user navigates to url '<url>'
    And user adds the product '<productA>' to cart
    And user adds the product '<productB>' to cart
    And user navigates to 'cart'
    And user removes the product '<productA>' from cart
    And user navigates to 'products'
    And user adds the product '<productC>' to cart
    And user navigates to 'cart'
    When user places the order
    Then successful order message is displayed
    And order id is displayed

    Examples:
      | url                    | productA      | productB          | productC |
      | http://localhost:3000/ | Cazafantasmas | Transmetropolitan | Gyo      |


  Scenario Outline: delete an order
    Given user navigates to url '<url>'
    And user purchases product '<product>'
    And user notes down the order id
    And user navigates to 'orders'
    And user searches the order id
    And user deletes the order
    And user navigates to 'orders'
    When user searches the order id
    Then the order is not displayed

    Examples:
      | url                    | product |
      | http://localhost:3000/ | Gyo     |