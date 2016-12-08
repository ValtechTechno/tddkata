Feature: En tant que formateur je fais une démo sur la calculatrice
  Scenario: Addition de deux nombres entiers
    Given j'introduis le premier nombre 1 et le second nombre 1
    When je demande le resultat
    Then j'obtiens 2