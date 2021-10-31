Feature: Procurando produtos

  Scenario: Procurado diversos produtos
    Given Dado a pagina inicial "<pagina>"
    When Quando procuro por um produto "<produto>"
    Then Entao o produto é retornado
    Examples:
    |pagina                      |produto    |
    |https://www.amazon.com.br   |mi band 6  |