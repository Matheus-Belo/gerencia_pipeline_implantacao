Feature: Teste de integração para Paciente

  Scenario: Calcular IMC
    Given existe um paciente com nome "Matheus" e sobrenome "Belo"
    And o paciente tem altura 170 cm e peso 70.5 kg
    When eu calcular o IMC
    Then o IMC deve ser 24.39

  Scenario: Obter Situação IMC
    Given existe um paciente com nome "Matheus" e sobrenome "Sobrenome"
    And o paciente tem altura 170 cm e peso 70.5 kg
    When eu verificar a situação do IMC
    Then a situação do IMC deve ser "Peso normal"

  Scenario: Calcular Idade
    Given existe um paciente com nome "Matheus" e sobrenome "Belo"
    And o paciente nasceu em "2002-12-17"
    When eu calcular a idade
    Then a idade deve ser 21
