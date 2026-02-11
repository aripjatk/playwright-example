package com.epam.ari_kaczmarek.steps;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.epam.ari_kaczmarek.pages.EditProfilePage;
import com.epam.ari_kaczmarek.pages.ProfilePage;
import com.microsoft.playwright.Page;

public class ValidateProfileSummaryEditStep extends TestStep {
    private final String expectedSummary;
    private static Logger logger = LogManager.getLogger(ValidateProfileSummaryEditStep.class);

    public ValidateProfileSummaryEditStep(Page page, String expectedSummary) {
        super(page);
        this.expectedSummary = expectedSummary;
    }

    @Override
    public void execute() {
        var editProfilePage = new EditProfilePage(page);
        editProfilePage.goBackToProfilePage();
        var profilePage = new ProfilePage(page);
        String actualSummary = profilePage.getProfileSummaryText();
        logger.info("Expected summary: " + expectedSummary);
        logger.info("Actual summary: " + actualSummary);
        try {
            assertEquals(expectedSummary, actualSummary);
            logger.info("Profile summary validation successful");
        } catch (AssertionError e) {
            logger.error("Profile summary validation failed", e);
            throw e;
        }
    }
}
