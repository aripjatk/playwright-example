package com.epam.ari_kaczmarek.definitions;

import com.epam.ari_kaczmarek.steps.*;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;

import static com.epam.ari_kaczmarek.definitions.PageContext.getPage;

public class CartStepDefinitions {

    @And("the user searches for {string}")
    public void search(String searchTerm) {
        new ProductSearchStep(getPage(), searchTerm).execute();
    }

    @And("the user selects the search result {string}")
    public void selectSearchResult(String resultName) {
        new SelectSearchResultStep(getPage(), resultName).execute();
    }

    @And("the user adds {string} to the cart")
    public void addProductToCart(String productName) {
        new AddToCartStep(getPage(), productName).execute();
    }

    @Then("the cart should contain {string}")
    public void validateCart(String expectedProduct) {
        new ValidateCartStep(getPage(), expectedProduct).execute();
    }   
}
