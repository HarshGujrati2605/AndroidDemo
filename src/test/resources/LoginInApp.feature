Feature: Login scenarios

  @logout-test @Logintest
  Scenario Outline: Validating the logout functionality
    When I enter username as "<username>"
    And I enter password as "<password>"
    And I login
    And I am on homepage    
    Then I click on "Logout" from the menu 
    
    Examples: 
      | username      |  password      |
      | standard_user |  secret_sauce  |
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      
      

    
 
    
      
      
    
    