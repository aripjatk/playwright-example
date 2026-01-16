package com.epam.ari_kaczmarek.steps;

import com.epam.ari_kaczmarek.pages.HomePage;
import com.microsoft.playwright.Page;

public class GoToProfileStep extends TestStep {
    public GoToProfileStep(Page page) {
        super(page);
    }

    @Override
    public void execute() {
        var homePage = new HomePage(page);
        homePage.goToProfilePage();
    }
}
