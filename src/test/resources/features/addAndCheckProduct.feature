Feature: I add product in shopping basket and check what it is

  Scenario: Add product in the basket and check
    Given Open main page
    When Find product "Пылесос Samsung SC4520 (VCC4520S3S/XEV)" and add in the Basket
    And Go to Basket page
    Then Check that the name product "Пылесос Samsung SC4520 (VCC4520S3S/XEV)" is correct
    And Checking the cost of the product
    And Сheck that the product is "1"