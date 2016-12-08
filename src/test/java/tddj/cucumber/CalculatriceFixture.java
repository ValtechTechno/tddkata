package tddj.cucumber;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatriceFixture {
    Calculatrice calculatrice = new Calculatrice();
    int a1 = 1, b1 = 1;
    private int result;

    @Then("^j'obtiens (\\d+)$")
    public void jobtiens(int result) throws Throwable {
        assertThat(this.result).isEqualTo(result);
    }

    @Given("^j'introduis le premier nombre (\\d+) et le second nombre (\\d+)$")
    public void jintroduisLePremierNombreEtLeSecondNombre(int a, int b) throws Throwable {
        a1 = a;
        b1 = b;
    }

    @When("^je demande le resultat$")
    public void jeDemandeLeResultat() throws Throwable {
        result = calculatrice.addDeuxInters(a1,b1);
    }
}
