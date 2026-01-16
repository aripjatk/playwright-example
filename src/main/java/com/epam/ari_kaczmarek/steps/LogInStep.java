package com.epam.ari_kaczmarek.steps;

import com.epam.ari_kaczmarek.pages.HomePage;
import com.epam.ari_kaczmarek.pages.LoginPage;
import com.microsoft.playwright.Page;

public class LogInStep extends TestStep {
    private final String username;
    private final String password;

    public LogInStep(Page page, String username, String password) {
        super(page);
        this.username = username;
        this.password = password;
    }

    @Override
    public void execute() {
        HomePage homePage = new HomePage(page);
        homePage.clickLoginLink();
        LoginPage loginPage = new LoginPage(page);
        loginPage.fillUsername(username);
        loginPage.fillPassword(password);
        loginPage.clickLoginButton();
    }
}
