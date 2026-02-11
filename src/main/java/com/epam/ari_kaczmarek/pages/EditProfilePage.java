package com.epam.ari_kaczmarek.pages;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.microsoft.playwright.Page;
import com.microsoft.playwright.Page.WaitForSelectorOptions;

public class EditProfilePage extends BasePage {
    private final String SUMMARY_TEXT_AREA_XPATH = "//textarea[@name='summary']";
    private final String ENABLED_SAVE_BUTTON_XPATH = "//button[@type='submit' and not(contains(@class, 'Disabled'))]";
    private final String DISABLED_SAVE_BUTTON_XPATH = "//button[@type='submit' and contains(@class, 'Disabled')]";
    private final String BACK_TO_PROFILE_LINK = "//a[contains(@href, 'profiles') and @class='Focusable']";
    private final String ERROR_TEXT = "An error occurred while setting account details";
    private final Logger logger = LogManager.getLogger(EditProfilePage.class);

    public EditProfilePage(Page page) {
        super(page);
    }
    
    public void fillSummaryTextArea(String newSummary) {
        logger.debug("Entering new summary: " + newSummary);
        page.locator(SUMMARY_TEXT_AREA_XPATH).fill(newSummary);
    }

    public void clickSaveButton() {
        logger.debug("Clicking Save button on Edit Profile page");
        page.locator(ENABLED_SAVE_BUTTON_XPATH).click();
    }

    public void waitForSaveButtonRefresh() {
        page.waitForSelector(DISABLED_SAVE_BUTTON_XPATH);
        page.waitForSelector(ENABLED_SAVE_BUTTON_XPATH);
    }

    public boolean checkForError() {
        try {
            var error = page.waitForSelector("text=" + ERROR_TEXT, new WaitForSelectorOptions().setTimeout(5000D));
            logger.warn("Error text found on Edit Profile page: " + error.innerText());
            return error.isVisible();
        } catch(Throwable t) {
            logger.debug("No error text found on Edit Profile page");
            return false;
        }
    }

    public void goBackToProfilePage() {
        logger.debug("Going back to profile page");
        page.locator(BACK_TO_PROFILE_LINK).click();
    }
}
