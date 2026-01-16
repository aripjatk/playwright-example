package com.epam.ari_kaczmarek.pages;

import com.microsoft.playwright.Page;

public class LoginPage extends BasePage {
    private static final String USERNAME_INPUT_XPATH = "//input[@type='text' and not(@placeholder)]";
    private static final String PASSWORD_INPUT_XPATH = "//input[@type='password']";
    private static final String LOGIN_BUTTON_XPATH = "//input[@type='password']/parent::*/following-sibling::*/button[@type='submit']";

    public LoginPage(Page page) {
        super(page);
    }
    public void fillUsername(String username) {
        page.locator(USERNAME_INPUT_XPATH).fill(username);
    }
    public void fillPassword(String password) {
        page.locator(PASSWORD_INPUT_XPATH).fill(password);
    }
    public void clickLoginButton() {
        page.locator(LOGIN_BUTTON_XPATH).click();
    }
}
