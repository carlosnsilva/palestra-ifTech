package EndToEnd.steps;

import EndToEnd.pages.homePage;
import EndToEnd.pages.productPage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class searchStep {

    private homePage pageHome;
    private productPage pageProduct;


    @Given("Dado a pagina inicial {string}")
    public void dado_a_pagina_inicial(String string) {
        pageHome = new homePage(string);
    }

    @When("Quando procuro por um produto {string}")
    public void quando_procuro_por_um_produto(String string) {
        pageProduct = pageHome.searchProduct(string);
    }

    @Then("Entao o produto é retornado")
    public void entao_o_produto_é_retornado() {
        pageProduct.validadeProduct();
        pageHome.quit();
    }
}
