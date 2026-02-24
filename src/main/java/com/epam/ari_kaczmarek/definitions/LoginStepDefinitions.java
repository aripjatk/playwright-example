package com.epam.ari_kaczmarek.definitions;

import com.epam.ari_kaczmarek.steps.*;
import com.microsoft.playwright.*;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import io.cucumber.java.Before;
import io.cucumber.java.After;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;

import static com.epam.ari_kaczmarek.definitions.PageContext.getPage;

public class LoginStepDefinitions {
    private Browser browser;

    @Before
    public void setUp() {
        browser = Playwright.create()
            .chromium()
            .launch(new LaunchOptions().setHeadless(false));
        Page page = browser.newPage();
        PageContext.setPage(page);
    }

    @After
    public void tearDown() {
        PageContext.closePage();
        if (browser != null) {
            browser.close();
        }
    }

    @Given("the user opens the home page")
    public void openHomePage() {
        new OpenHomePageStep(getPage()).execute();
    }

    @When("the user logs in with username {string} and password {string}")
    public void logIn(String username, String password) {
        new LogInStep(getPage(), username, password).execute();
    }

    @Then("the displayed username should contain {string}")
    public void validateUserName(String expected) {
        new ValidateUserNameStep(getPage(), expected).execute();
    }
}